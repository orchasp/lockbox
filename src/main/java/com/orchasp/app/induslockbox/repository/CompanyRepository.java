package com.orchasp.app.induslockbox.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orchasp.app.induslockbox.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	Optional<Company> findByCompanyname(String companyname);
}
