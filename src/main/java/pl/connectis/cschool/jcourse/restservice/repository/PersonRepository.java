package pl.connectis.cschool.jcourse.restservice.repository;

import org.springframework.data.repository.CrudRepository;

import pl.connectis.cschool.jcourse.restservice.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
	
	Person findByFirstName(String firstName);

}
