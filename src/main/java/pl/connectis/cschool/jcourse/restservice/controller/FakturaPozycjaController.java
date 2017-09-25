package pl.connectis.cschool.jcourse.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.connectis.cschool.jcourse.restservice.domain.FakturaPozycja;
import pl.connectis.cschool.jcourse.restservice.repository.PozycjaRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/pozycje")
public class FakturaPozycjaController {

    @Autowired
    PozycjaRepository pozycjaRepository;

    @RequestMapping(method = POST)
    ResponseEntity<FakturaPozycja> addPozycja(@RequestBody FakturaPozycja pozycja){
    	FakturaPozycja saved = pozycjaRepository.save(pozycja);
    return new ResponseEntity<FakturaPozycja>(saved, HttpStatus.OK);
    }
    @RequestMapping(method = GET)
    List<FakturaPozycja> getAll(){
        return (List<FakturaPozycja>) pozycjaRepository.findAll();
    }

    @RequestMapping(method = GET, value = "/{id}")
    Optional<FakturaPozycja> getPozycja(@PathVariable long id) throws ResourceNotFoundException {
        return Optional.ofNullable(pozycjaRepository.findOne(id));
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    FakturaPozycja deletePozycja(@PathVariable long id) throws ResourceNotFoundException {
       return pozycjaRepository.deleteById(id);
    }


}
