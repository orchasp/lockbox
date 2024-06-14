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
	private String companyname;
	@NotBlank
	private String director;
	@NotBlank
	private String companycode;
	@NotBlank
	private String address;
	@NotBlank
	private String phoneNumber;
	@NotBlank
	private String email;
	@NotBlank
	private String website;
	@NotBlank
	private String registerNumber;
	@NotBlank
	private String inceptionDate;
	@NotBlank
	private String pincode;
	@NotBlank
	private String doorNo;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private String owner;

	//one-to-one mapping with GST entity class
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gst_id", referencedColumnName = "id")
	private GST gst;

	//one-to-one mapping with Bank entity class
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id", referencedColumnName = "id")
	private Bank bank;

	//one-to-one mapping with IncomeTax entity class
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "incomeTax_id", referencedColumnName = "id")
	private IncomeTax incomeTax;


	//one-to-one mapping with EPF entity class
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "epf_id", referencedColumnName = "id")
	private EPF epf;

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

	public String getCompanyname() {
		return companyname;
	}
	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getInceptionDate() {
		return inceptionDate;
	}

	public void setInceptionDate(String inceptionDate) {
		this.inceptionDate = inceptionDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
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
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
