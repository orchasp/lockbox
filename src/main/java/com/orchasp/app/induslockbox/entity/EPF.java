package com.orchasp.app.induslockbox.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class EPF {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String estid;
	@NotNull
	private Long lin;
	@NotNull
	private String panno;
	@NotNull
	private String niccode;
	@NotNull
	private String pfoffice;
	@NotNull
	private String signatory;
	
	private String createdBy;
	private String updatedBy;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	 private boolean active = true;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="company_id")
	    private Company company;

	public EPF() {
		super();
	}

	public EPF(Long id, String estid, Long lin, String panno, String niccode, String pfoffice, String signatory,
			String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate, boolean active,
			Company company) {
		super();
		this.id = id;
		this.estid = estid;
		this.lin = lin;
		this.panno = panno;
		this.niccode = niccode;
		this.pfoffice = pfoffice;
		this.signatory = signatory;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.active = active;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstid() {
		return estid;
	}

	public void setEstid(String estid) {
		this.estid = estid;
	}

	public Long getLin() {
		return lin;
	}

	public void setLin(Long lin) {
		this.lin = lin;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getNiccode() {
		return niccode;
	}

	public void setNiccode(String niccode) {
		this.niccode = niccode;
	}

	public String getPfoffice() {
		return pfoffice;
	}

	public void setPfoffice(String pfoffice) {
		this.pfoffice = pfoffice;
	}

	public String getSignatory() {
		return signatory;
	}

	public void setSignatory(String signatory) {
		this.signatory = signatory;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
