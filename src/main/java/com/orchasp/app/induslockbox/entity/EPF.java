package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EPF {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String epfNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEpfNumber() {
		return epfNumber;
	}

	public void setEpfNumber(String epfNumber) {
		this.epfNumber = epfNumber;
	}

}
