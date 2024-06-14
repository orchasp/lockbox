package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyid;
	@NotNull
	private String organizationCode;
	@NotNull
	private String companyname;
	
	@NotNull
	private String inceptionDate;
	@NotNull
	private String registerNo;
	@NotNull
	private Long phoneNo;
	@NotNull
	private String email;
	@NotNull
	private String flatNo;
	@NotNull
	private String website;
	@NotNull
	private String city;
		@NotNull
	private String state;
	@NotNull
	private Long pincode;

// @OneToOne mapping with GST entity class
	 @OneToOne(mappedBy = "company")
	private GST gst;
	 
// @OneToOne mapping with Bank entity class
	 @OneToOne(mappedBy = "company")
	private Bank bank;
	 
	 //@OneToOne mapping with IncomeTax entity class
	 @OneToOne(mappedBy = "company")
	private IncomeTax incomeTax;

	 // @OneToOne mapping with EPF entity class
	 @OneToOne(mappedBy = "company")
	private EPF epf;

	 // @OneToOne mapping with Director entity class
	 @OneToOne(mappedBy = "company")
		private Director director;

	public Company(Long companyid, @NotNull String organizationCode, @NotNull String companyname,
			@NotNull String inceptionDate, @NotNull String registerNo, @NotNull Long phoneNo, @NotNull String email,
			@NotNull String flatNo, @NotNull String website, @NotNull String city, @NotNull String state,
			@NotNull Long pincode, GST gst, Bank bank, IncomeTax incomeTax, EPF epf, Director director) {
		super();
		this.companyid = companyid;
		this.organizationCode = organizationCode;
		this.companyname = companyname;
		this.inceptionDate = inceptionDate;
		this.registerNo = registerNo;
		this.phoneNo = phoneNo;
		this.email = email;
		this.flatNo = flatNo;
		this.website = website;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.gst = gst;
		this.bank = bank;
		this.incomeTax = incomeTax;
		this.epf = epf;
		this.director = director;
	}

	public Company() {
		super();
	}

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getInceptionDate() {
		return inceptionDate;
	}

	public void setInceptionDate(String inceptionDate) {
		this.inceptionDate = inceptionDate;
	}

	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public GST getGst() {
		return gst;
	}

	public void setGst(GST gst) {
		this.gst = gst;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public IncomeTax getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(IncomeTax incomeTax) {
		this.incomeTax = incomeTax;
	}

	public EPF getEpf() {
		return epf;
	}

	public void setEpf(EPF epf) {
		this.epf = epf;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	
}
