package pl.connectis.cschool.jcourse.restservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FakturaPozycja {
	private Long id;
	
	private String nazwaProduktu;
	private int liczbaSztuk;
	private double marza;
	
	public FakturaPozycja(){
		
	}
	
	public FakturaPozycja(String nazwaProduktu, int liczbaSztuk, double marza) {
		this.nazwaProduktu = nazwaProduktu;
		this.liczbaSztuk = liczbaSztuk;
		this.marza = marza;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwaProduktu() {
		return nazwaProduktu;
	}

	public void setNazwaProduktu(String nazwaProduktu) {
		this.nazwaProduktu = nazwaProduktu;
	}

	public int getLiczbaSztuk() {
		return liczbaSztuk;
	}

	public void setLiczbaSztuk(int liczbaSztuk) {
		this.liczbaSztuk = liczbaSztuk;
	}

	public double getMarza() {
		return marza;
	}

	public void setMarza(double marza) {
		this.marza = marza;
	}
	
	
}
