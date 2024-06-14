package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Organisation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyid;
	
	  @Column(length = 100)
	private String companyname;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gst_id", referencedColumnName = "id")
	private GST gst;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id", referencedColumnName = "id")
	private Bank bank;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "incomeTax_id", referencedColumnName = "id")
	private IncomeTax incomeTax;

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

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
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
