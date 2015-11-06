package com.connvertex.candor.controller;

import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.connvertex.candor.model.Address;
import com.connvertex.candor.model.Person;
import com.connvertex.candor.service.AddressService;
import com.connvertex.candor.service.PersonService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	PersonService service;

	@Autowired
	AddressService addService;

	@Autowired
	MessageSource messageSource;

	private static final Logger logger = LoggerFactory
			.getLogger(AppController.class);

	/*
	 * This method will list all existing persons.
	 */
	@RequestMapping(value = { "/", "/personList" }, method = RequestMethod.GET)
	public String listPersons(ModelMap model) {

		List<Person> persons = service.findAllPersons();
		model.addAttribute("persons", persons);
		return "/PE/Person_list";
	}

	/*
	 * This method will provide the medium to add a new person.
	 */
	@RequestMapping(value = { "/personRegistration" }, method = RequestMethod.GET)
	public String newPerson(ModelMap model) {
		Person person = new Person();
		Address address = new Address();

		model.addAttribute("person", person);
		model.addAttribute("address", address);
		model.addAttribute("edit", false);
		return "/PE/Person_registration";
	}

	/*
	 * This method will provide the medium to view an existing person.
	 */
	@RequestMapping(value = { "/viewPerson-{ssn}" }, method = RequestMethod.GET)
	public String viewPerson(@PathVariable String ssn, ModelMap model) {
		Person person = service.findPersonBySsn(ssn);
		model.addAttribute("person", person);
		return "/PE/Person_home";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving person in database. It also validates the user input
	 */
	@RequestMapping(value = { "/personRegistration" }, method = RequestMethod.POST)
	public String savePerson(@Valid @ModelAttribute("person") Person person,
			BindingResult personResults,
			@Valid @ModelAttribute("address") Address address,
			BindingResult addressResults, ModelMap model) {

		if (personResults.hasErrors()) {
			logger.info("Errors on Person_registration.jsp page");
			model.addAttribute("person", person);
			return "/PE/Person_registration";
		}

		if (addressResults.hasErrors()) {
			logger.info("Errors on Person_registration.jsp page");
			model.addAttribute("address", address);
			return "/PE/Person_registration";
		}
		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be
		 * implementing custom @Unique annotation and applying it on field [ssn]
		 * of Model class [Person].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you
		 * can fill custom errors outside the validation framework as well while
		 * still using internationalized messages.
		 */
		if (!service.isPersonSsnUnique(person.getPersonID(), person.getSsn())) {
			FieldError ssnError = new FieldError("person", "ssn",
					messageSource.getMessage("non.unique.ssn",
							new String[] { person.getSsn() },
							Locale.getDefault()));

			personResults.addError(ssnError);
			model.addAttribute("Person", person);
			return "/PE/Person_registration";
		}

		logger.info("Errors on Person_registrationSuccess.jsp page");
		model.addAttribute("person", person);
		model.addAttribute("address", address);
		person.setAddressID(address.getAddressID());
		service.savePerson(person);
		addService.saveAddress(address);

		model.addAttribute("Person_registrationSuccess_message", "Person "
				+ person.getFirstName() + " " + person.getMiddleInitial() + " "
				+ person.getLastName() + " registered successfully");
		return "/PE/Person_registrationSuccess";
	}

	/*
	 * This method will provide the medium to update an existing person.
	 */
	@RequestMapping(value = { "/editPerson-{ssn}" }, method = RequestMethod.GET)
	public String editPerson(@PathVariable String ssn, ModelMap model) {
		Person person = service.findPersonBySsn(ssn);
		model.addAttribute("person", person);
		model.addAttribute("edit", true);
		return "/PE/Person_registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating person in database. It also validates the user input
	 */
	@RequestMapping(value = { "/editPerson-{ssn}" }, method = RequestMethod.POST)
	public String updatePerson(@Valid Person person, BindingResult result,
			ModelMap model, @PathVariable String ssn) {

		if (result.hasErrors()) {
			return "/PE/Person_registration";
		}

		if (!service.isPersonSsnUnique(person.getPersonID(), person.getSsn())) {
			FieldError ssnError = new FieldError("person", "ssn",
					messageSource.getMessage("non.unique.ssn",
							new String[] { person.getSsn() },
							Locale.getDefault()));
			result.addError(ssnError);
			return "/PE/Person_registration";
		}

		service.updatePerson(person);

		model.addAttribute("Person_registrationSuccess_message", "Person "
				+ person.getFirstName() + " " + person.getMiddleInitial() + " "
				+ person.getLastName() + " updated successfully");
		return "/PE/Person_registrationSuccess";
	}

	/*
	 * This method will delete an person by it's SSN value.
	 */
	@RequestMapping(value = { "/deletePerson-{ssn}" }, method = RequestMethod.GET)
	public String deletePerson(@PathVariable String ssn) {
		service.deletePersonBySsn(ssn);
		return "redirect:/personList";
	}

}