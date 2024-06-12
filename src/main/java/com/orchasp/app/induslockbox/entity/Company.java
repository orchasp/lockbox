package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyid;
	@NotBlank
	private String organizationCode;
	@NotBlank
	private String companyname;
	@NotBlank
	private String director;
	@NotBlank
	private String inceptionDate;
	@NotBlank
	private String registerNo;
	@NotBlank
	private Long phoneNo;
	@NotBlank
	private String email;
	@NotBlank
	private String website;
	@NotBlank
	private String doorNo;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private Long pincode;

	// one-to-one mapping with GST entity class
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gst_id", referencedColumnName = "id")
	private GST gst;

	// one-to-one mapping with Bank entity class
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id", referencedColumnName = "id")
	private Bank bank;

	// one-to-one mapping with IncomeTax entity class
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "incomeTax_id", referencedColumnName = "id")
	private IncomeTax incomeTax;

	// one-to-one mapping with EPF entity class
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "epf_id", referencedColumnName = "id")
	private EPF epf;

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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
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

}
