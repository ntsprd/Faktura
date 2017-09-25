package pl.connectis.cschool.jcourse.restservice.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Faktura {
	private Long id;
	
	private String numerFaktury;
	private String nabywca;
	private Date dataFaktury;
	private List<FakturaPozycja> pozycje;
	
	public Faktura() {
		
	}
	
	public Faktura(String numerFaktury, String nabywca, Date dataFaktury) {
		this.numerFaktury = numerFaktury;
		this.nabywca = nabywca;
		this.dataFaktury = dataFaktury;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumerFaktury() {
		return numerFaktury;
	}

	public void setNumerFaktury(String numerFaktury) {
		this.numerFaktury = numerFaktury;
	}

	public String getNabywca() {
		return nabywca;
	}

	public void setNabywca(String nabywca) {
		this.nabywca = nabywca;
	}

	public Date getDataFaktury() {
		return dataFaktury;
	}

	public void setDataFaktury(Date dataFaktury) {
		this.dataFaktury = dataFaktury;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<FakturaPozycja> getPozycje() {
		return pozycje;
	}

	public void setPozycje(List<FakturaPozycja> pozycje) {
		this.pozycje = pozycje;
	}
	
}
