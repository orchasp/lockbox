package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max=50)
	private String accountHolderName;
	@Size(max=12)
	private String bankAccountNumber;

	private String IFCcode;

	private String bankName;

	private String branch;

	private Long IRCcode;

	private Long MRCcode;
	
	private Long RBIcode;

	private Long transactionCode;

	private String accountType;

	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Long getIRCcode() {
		return IRCcode;
	}

	public void setIRCcode(Long iRCcode) {
		IRCcode = iRCcode;
	}

	public Long getMRCcode() {
		return MRCcode;
	}

	public void setMRCcode(Long mRCcode) {
		MRCcode = mRCcode;
	}

	public Long getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(Long transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getIFCcode() {
		return IFCcode;
	}

	public void setIFCcode(String iFCcode) {
		IFCcode = iFCcode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRBIcode() {
		return RBIcode;
	}

	public void setRBIcode(Long rBIcode) {
		RBIcode = rBIcode;
	}
	
	

}
