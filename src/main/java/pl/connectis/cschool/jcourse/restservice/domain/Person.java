package pl.connectis.cschool.jcourse.restservice.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	private Long id;
	
	private String firstName;
	private int yob;
	private List<Dog> dogs;
	
	public Person() {
	}
	public Person(String firstname, int yob) {
		super();
		this.firstName = firstname;
		this.yob = yob;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Dog> getDogs() {
		return dogs;
	}
	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

}
