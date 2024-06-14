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
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String accountHolderName;
	private String bankAccountNumber;
	private String ifccode;
	private String bankName;
	private String branch;
	private long irccode;
	private long mrccode;
	private long rbicode;
	private long transactionCode;
	private String accountType;
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

	public Bank(Long id, String accountHolderName, String bankAccountNumber, String ifccode, String bankName,
			String branch, long irccode, long mrccode, long rbicode, long transactionCode, String accountType,
			String password, Company company) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.bankAccountNumber = bankAccountNumber;
		this.ifccode = ifccode;
		this.bankName = bankName;
		this.branch = branch;
		this.irccode = irccode;
		this.mrccode = mrccode;
		this.rbicode = rbicode;
		this.transactionCode = transactionCode;
		this.accountType = accountType;
		this.password = password;
		this.company = company;
	}

	public Bank() {
		super();
	}
>>>>>>> 2bab7318d52299c06ca93ea5080e89e923054a3d

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getIfccode() {
		return ifccode;
	}

	public void setIfccode(String ifccode) {
		this.ifccode = ifccode;
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

	public long getIrccode() {
		return irccode;
	}

	public void setIrccode(long irccode) {
		this.irccode = irccode;
	}

	public long getMrccode() {
		return mrccode;
	}

	public void setMrccode(long mrccode) {
		this.mrccode = mrccode;
	}

	public long getRbicode() {
		return rbicode;
	}

	public void setRbicode(long rbicode) {
		this.rbicode = rbicode;
	}

	public long getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(long transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
