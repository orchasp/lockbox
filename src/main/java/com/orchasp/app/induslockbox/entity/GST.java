package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GST {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @Column(length = 50)
	  private String GStname;

	    @Column(length = 20)
	    private String gstNumber;
	    
	    @Column(length = 30)
	    private String userid;
	    
	    @Column(length = 255)
	    private String password;
	    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	
	public String getGStname() {
		return GStname;
	}

	
	public void setGStname(String gStname) {
		GStname = gStname;
	}

	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}
	


}
