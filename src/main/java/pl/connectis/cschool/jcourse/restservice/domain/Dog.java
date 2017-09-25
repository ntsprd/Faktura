package pl.connectis.cschool.jcourse.restservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {
	
	private Long id;
	private String name;
	private int yob;
	
	public Dog(String name, int yob) {
		super();
		this.name = name;
		this.yob = yob;
	}
		
	public Dog() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", yob=" + yob + "]";
	}
}
