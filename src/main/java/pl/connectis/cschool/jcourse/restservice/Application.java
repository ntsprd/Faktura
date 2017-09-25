package pl.connectis.cschool.jcourse.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pl.connectis.cschool.jcourse.restservice.domain.Book;
import pl.connectis.cschool.jcourse.restservice.domain.Dog;
import pl.connectis.cschool.jcourse.restservice.domain.Person;
import pl.connectis.cschool.jcourse.restservice.repository.BookRepository;
import pl.connectis.cschool.jcourse.restservice.repository.DogRepository;
import pl.connectis.cschool.jcourse.restservice.repository.PersonRepository;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
    @Bean
    CommandLineRunner init(final DogRepository dr, final PersonRepository pr, final BookRepository br){
    		return new CommandLineRunner() {
				
				@Override
				public void run(String... arg0) throws Exception {
					
					dr.save(new Dog("Burek", 2015));
					dr.save(new Dog("Reksio", 1978));
					dr.save(new Dog("Szarik", 1965));
					
					pr.save(new Person("Ziutek", 1987));
					pr.save(new Person("Henio", 2025));				
					pr.save(new Person("Zenek", 1967));

					List<Dog> dogs = new ArrayList<Dog>();				
					dogs.add(new Dog("As", 2011));
					dogs.add(new Dog("Bis", 2015));
					dogs.add(new Dog("Cis", 2009));
					
					Person p = new Person("Henryk", 1956);
					p.setDogs(dogs);
					
					pr.save(p);
					
					Book book = new Book("Ogniem i Mieciem");			
					book.setAuthor(p);
					
					br.save(book);					
				}
			};
    }

}