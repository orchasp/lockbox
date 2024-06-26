package com.orchasp.app.induslockbox.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String accountHolderName;
	@NotNull
	private String bankAccountNumber;
	@NotNull
	private String ifccode;
	@NotNull
	private String bankName;
	@NotNull
	private String branch;
	@NotNull
	private long irccode;
	@NotNull
	private long mrccode;
	@NotNull
	private long rbicode;
	@NotNull
	private long transactionCode;
	@NotNull
	private String accountType;
	@NotNull
	private String password;

	private String createdBy;
	private String updatedBy;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	 private boolean active = true;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public Bank() {
		super();
	}

	public Bank(Long id, String accountHolderName, String bankAccountNumber, String ifccode, String bankName,
			String branch, long irccode, long mrccode, long rbicode, long transactionCode, String accountType,
			String password, String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate,
			Company company) {
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
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.company = company;
	}

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
