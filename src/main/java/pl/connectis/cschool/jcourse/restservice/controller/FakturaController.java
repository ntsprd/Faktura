package pl.connectis.cschool.jcourse.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.connectis.cschool.jcourse.restservice.domain.Faktura;
import pl.connectis.cschool.jcourse.restservice.domain.FakturaPozycja;
import pl.connectis.cschool.jcourse.restservice.domain.Produkt;
import pl.connectis.cschool.jcourse.restservice.repository.FakturaRepository;
import pl.connectis.cschool.jcourse.restservice.repository.ProduktRepository;
import java.util.Optional;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/faktury")
public class FakturaController {

	@Autowired
	FakturaRepository fr;
	
	@Autowired
	ProduktRepository pr;
	

	@RequestMapping(method = POST)
	ResponseEntity<Faktura> addFaktura(@RequestBody Faktura faktura) throws PozycjaNotFoundException {
		int stanProduktuWMagazynie = 0;
		for(FakturaPozycja fakPos : faktura.getPozycje()){
			stanProduktuWMagazynie = sprawdzStanyMagazyn(fakPos);
			// TODO: tu sprawdz czy produkt istnieje w magazynie
			// TODO: tu sprawdz czy nie przekraczasz stanow
			// TODO: oddaj wyjątek jeżeli przekraczasz
		}
		Faktura saved = fr.save(faktura);
		return new ResponseEntity<Faktura>(saved, HttpStatus.OK);
	}

	@RequestMapping(method = DELETE, value = "/{id}")
	Faktura deleteById(@PathVariable long id) throws ResourceNotFoundException {
		return fr.deleteById(id);
	}

	@RequestMapping(method = GET)
	List<Faktura> getAll() {
		return (List<Faktura>) fr.findAll();
	}

	@RequestMapping(method = GET, value = "/id")
	Faktura getFaktura(@PathVariable long id) throws ResourceNotFoundException {
		return fr.findOne(id);
	}

	private int sprawdzStanyMagazyn(FakturaPozycja fakPos) throws PozycjaNotFoundException {
		Produkt product;
		int result = 0;
		product = pr.findByNazwa(fakPos.getNazwaProduktu())
						.orElse(new Produkt("Brak", -1, -1, -1, -1));
		result = product.getStan();
		return result;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private class PozycjaNotFoundException extends Exception {
		public PozycjaNotFoundException(long id) {
		}
	}
}
