package com.orchasp.app.induslockbox.entity;

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

public class Director {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
<<<<<<< HEAD
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

=======
	private String email;
	private Long dinNo;
	
	 @OneToOne
	    @JoinColumn(name="company_id")
	    private Company company;

	public Director(Long id, String name, String email, Long dinNo, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dinNo = dinNo;
		this.company = company;
	}

	public Director() {
		super();
	}

>>>>>>> 2bab7318d52299c06ca93ea5080e89e923054a3d
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
<<<<<<< HEAD
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
=======

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getDinNo() {
		return dinNo;
	}

	public void setDinNo(Long dinNo) {
		this.dinNo = dinNo;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
>>>>>>> 2bab7318d52299c06ca93ea5080e89e923054a3d
