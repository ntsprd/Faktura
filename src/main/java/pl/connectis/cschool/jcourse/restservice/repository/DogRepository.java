package pl.connectis.cschool.jcourse.restservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.connectis.cschool.jcourse.restservice.domain.Dog;

@RepositoryRestResource
public interface DogRepository extends CrudRepository<Dog, Long>{

}
