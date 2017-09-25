package pl.connectis.cschool.jcourse.restservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.connectis.cschool.jcourse.restservice.domain.Person;
import pl.connectis.cschool.jcourse.restservice.repository.BookRepository;
import pl.connectis.cschool.jcourse.restservice.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{personId}")
	Person findPerson(@PathVariable Long personId){
		logger.info("Szukam osoby o id " + personId);	
		return personRepository.findOne(personId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	List<Person> allPerson(){	
		return (List<Person>) personRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Person> addPerson(@RequestBody Person person) {	
		Person savedPerson = personRepository.save(person);
		return new ResponseEntity<Person>(savedPerson, HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{personId}")
	ResponseEntity<Person> deletePerson(@PathVariable Long personId) {
		personRepository.delete(personId);
		return new ResponseEntity<Person>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/search/{firstName}")
	Person findPersonByFirstName(@PathVariable String firstName){
		logger.info("Szukam osoby o firstName " + firstName);	
		return personRepository.findByFirstName(firstName);
	}
		
}
