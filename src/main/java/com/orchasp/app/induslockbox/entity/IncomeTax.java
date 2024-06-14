package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
=======
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
>>>>>>> 2bab7318d52299c06ca93ea5080e89e923054a3d

@Entity
public class IncomeTax {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String panNumber;
	private String name;
	private String issuedDate;
	private String dateOfBirth;

	@OneToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public IncomeTax(Long id, String panNumber, String name, String issuedDate, String dateOfBirth, Company company) {
		super();
		this.id = id;
		this.panNumber = panNumber;
		this.name = name;
		this.issuedDate = issuedDate;
		this.dateOfBirth = dateOfBirth;
		this.company = company;
	}

<<<<<<< HEAD
	  @NotBlank
	    @Column(length = 10)
    private String dateOfBirth;
	  @ManyToOne
		private Company company;

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}
=======
	public IncomeTax() {
		super();
	}
>>>>>>> 2bab7318d52299c06ca93ea5080e89e923054a3d

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
<<<<<<< HEAD
=======

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
>>>>>>> 2bab7318d52299c06ca93ea5080e89e923054a3d
}
