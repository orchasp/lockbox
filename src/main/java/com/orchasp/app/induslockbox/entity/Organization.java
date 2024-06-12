package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long organizationCode;
	private String address;
	private String place;
	private Long phoneNo;
	private String fax;
	private String eMail;
	private String gstNumber;
	private Long ceCode;
	private Long drclNo;
	private Long eximCode;
	private Long gstRate;
	private String organizationName;
	private Long pincode;
	private Long teleex;
	private String registerNo;
	private String cerNo;
	private String tdsAccount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(Long organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public Long getCeCode() {
		return ceCode;
	}

	public void setCeCode(Long ceCode) {
		this.ceCode = ceCode;
	}

	public Long getDrclNo() {
		return drclNo;
	}

	public void setDrclNo(Long drclNo) {
		this.drclNo = drclNo;
	}

	public Long getEximCode() {
		return eximCode;
	}

	public void setEximCode(Long eximCode) {
		this.eximCode = eximCode;
	}

	public Long getGstRate() {
		return gstRate;
	}

	public void setGstRate(Long gstRate) {
		this.gstRate = gstRate;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Long getTeleex() {
		return teleex;
	}

	public void setTeleex(Long teleex) {
		this.teleex = teleex;
	}

	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public String getCerNo() {
		return cerNo;
	}

	public void setCerNo(String cerNo) {
		this.cerNo = cerNo;
	}

	public String getTdsAccount() {
		return tdsAccount;
	}

	public void setTdsAccount(String tdsAccount) {
		this.tdsAccount = tdsAccount;
	}

}
