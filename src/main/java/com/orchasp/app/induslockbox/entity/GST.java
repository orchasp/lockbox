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
public class GST {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
<<<<<<< Updated upstream
	private String gstNumber;
	private String userid;
	private String password;
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

	public GST(Long id, String gstNumber, String userid, String password, Company company) {
		super();
		this.id = id;
		this.gstNumber = gstNumber;
		this.userid = userid;
		this.password = password;
		this.company = company;
	}

	public GST() {
		super();
	}
>>>>>>> 2bab7318d52299c06ca93ea5080e89e923054a3d
=======
	
	 @Column(length = 50)
	  private String GStname;
>>>>>>> Stashed changes

	    @Column(length = 20)
	    private String gstNumber;
	    
	    @Column(length = 30)
	    private String userid;
	    
	    @Column(length = 255)
	    private String password;
	    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	

}
