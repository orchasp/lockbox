package com.orchasp.app.induslockbox.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name = "admin", uniqueConstraints = { 
		@UniqueConstraint(columnNames = "userName"),
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "mobile")})
public class Admin{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 50)
	private String userName;
	
	@NotBlank
	@Size(max = 12)
	private String mobile;

	@NotBlank
	@Size(min = 8)
	@Email
	private String email;

	@NotBlank
	@Size(min = 8)
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

}
