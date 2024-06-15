package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class EPF {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String epfNumber;
	
	 @OneToOne
	    @JoinColumn(name="company_id")
	    private Company company;

	public EPF(Long id, String epfNumber, Company company) {
		super();
		this.id = id;
		this.epfNumber = epfNumber;
		this.company = company;
	}

	public EPF() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEpfNumber() {
		return epfNumber;
	}

	public void setEpfNumber(String epfNumber) {
		this.epfNumber = epfNumber;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
