package pl.connectis.cschool.jcourse.restservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;

	
@Entity
public class Produkt {
	private Long id;
	private String nazwa;
	private int stan;
	private int idPolki;
	private int idPozycjiNaPolce;
	private double cena;
	
	public Produkt() {
		
	}
	
	public Produkt(String nazwa, int stan, int idPolki, int idPozycjiNaPolce, double cena) {
		this.nazwa = nazwa;
		this.stan = stan;
		this.idPolki = idPolki;
		this.idPozycjiNaPolce = idPozycjiNaPolce;
		this.cena = cena;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getStan() {
		return stan;
	}

	public void setStan(int stan) {
		this.stan = stan;
	}

	public int getIdPolki() {
		return idPolki;
	}

	public void setIdPolki(int idPolki) {
		this.idPolki = idPolki;
	}

	public int getIdPozycjiNaPolce() {
		return idPozycjiNaPolce;
	}

	public void setIdPozycjiNaPolce(int idPozycjiNaPolce) {
		this.idPozycjiNaPolce = idPozycjiNaPolce;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
}
