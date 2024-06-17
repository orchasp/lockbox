package com.orchasp.app.induslockbox.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.orchasp.app.induslockbox.entity.Admin;
import com.orchasp.app.induslockbox.repository.AdminRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDetailsImp implements UserDetails,UserDetailsService{
	
	@Autowired
	private  AdminRepository repository;
	
	private Admin admin;
	
	public UserDetailsImp(Admin admin) {
		this.admin=admin;
	}
	
	private Collection<? extends GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		return admin.getEmail();
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//	    log.info("Looking up user by email: " + username);
	    Admin admin = repository.findByEmail(email)
	            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
	    return new UserDetailsImp(admin);
	}

	public AdminRepository getRepository() {
		return repository;
	}

	public void setRepository(AdminRepository repository) {
		this.repository = repository;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public UserDetailsImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetailsImp(AdminRepository repository, Admin admin, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.repository = repository;
		this.admin = admin;
		this.authorities = authorities;
	}

	

}
