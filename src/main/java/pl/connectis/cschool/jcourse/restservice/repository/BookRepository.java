package pl.connectis.cschool.jcourse.restservice.repository;

import org.springframework.data.repository.CrudRepository;

import pl.connectis.cschool.jcourse.restservice.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
