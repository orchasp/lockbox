package com.orchasp.app.induslockbox.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
import lombok.AllArgsConstructor;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@Table(name = "admin",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "name"),
				@UniqueConstraint(columnNames = "email")
		})
public class Admin implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 50)
	private String userName;

	@NotBlank
	@Size(min = 8)
	@Email
	private String email;

	@NotBlank
	@Size(min = 8)
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Admin(@NotBlank @Size(max = 50) String userName, @NotBlank @Size(min = 8) @Email String email,
			@NotBlank @Size(min = 8) String password, Role role) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

}
