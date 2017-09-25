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

import pl.connectis.cschool.jcourse.restservice.domain.Produkt;
import pl.connectis.cschool.jcourse.restservice.repository.ProduktRepository;

@RestController
@RequestMapping("/products")
public class ProduktController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProduktController.class);
	
	@Autowired
	ProduktRepository produktRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{produktId}")
	Produkt findProduct(@PathVariable Long produktId){
		return produktRepository.findOne(produktId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	List<Produkt> allProdukt(){	
		return (List<Produkt>) produktRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Produkt> addProduct(@RequestBody Produkt produkt) {	
		Produkt savedProduct = produktRepository.save(produkt);
		return new ResponseEntity<Produkt>(savedProduct, HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{produktId}")
	ResponseEntity<Produkt> deleteProduct(@PathVariable Long produktId) {
		produktRepository.delete(produktId);
		return new ResponseEntity<Produkt>(HttpStatus.OK);
	}	
}
