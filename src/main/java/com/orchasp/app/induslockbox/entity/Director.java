package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity

public class Director {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String address;
    @NotBlank
	private Long dinNo;
	
	@ManyToOne
	private Company company;
	public Director() {
		
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

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
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getDinNo() {
		return dinNo;
	}

	public void setDinNo(Long dinNo) {
		this.dinNo = dinNo;
	}
	
	

}