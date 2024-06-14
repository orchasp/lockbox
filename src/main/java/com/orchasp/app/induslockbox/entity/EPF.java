package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
=======
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
>>>>>>> 2bab7318d52299c06ca93ea5080e89e923054a3d

@Entity
public class EPF {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
<<<<<<< Updated upstream
=======
	
	@Column(length = 20)
>>>>>>> Stashed changes
	private String epfNumber;
<<<<<<< HEAD
	@ManyToOne
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
=======
	
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
>>>>>>> 2bab7318d52299c06ca93ea5080e89e923054a3d

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
