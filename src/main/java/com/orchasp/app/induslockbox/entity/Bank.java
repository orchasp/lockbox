package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
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
		this.IFCcode = ifccode;
		this.bankName = bankName;
		this.branch = branch;
		this.IRCcode = irccode;
		this.MRCcode = mrccode;
		this.IRCcode = rbicode;
		this.transactionCode = transactionCode;
		this.accountType = accountType;
		this.password = password;
		this.company = company;
	}

	public Bank() {
		super();
	}

	@Size(max=50)
    @Column(length = 50)
	private String accountHolderName;


    @Column(length = 20)
    private String bankAccountNumber;

    @Column(length = 11)
    private String IFCcode;

    @Column(length = 50)
    private String bankName;

    @Column(length = 50)
    private String branch;

    @Column(length = 20)
    private Long IRCcode;

    @Column(length = 20)
    private Long MRCcode;

    @Column(length = 20)
    private Long transactionCode;

    @Column(length = 10)
    private String accountType;

    @Column(length = 255)
    private String password;


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
		return IFCcode;
	}

	public void setIfccode(String ifccode) {
		this.IFCcode = ifccode;
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
		return IRCcode;
	}

	public void setIrccode(long irccode) {
		this.IRCcode = irccode;
	}

	public long getMrccode() {
		return MRCcode;
	}

	public void setMrccode(long mrccode) {
		this.MRCcode = mrccode;
	}

	public long getRbicode() {
		return getRbicode();
	}

	public void setRbicode(long rbicode) {
		this.IRCcode = rbicode;
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
