package com.orchasp.app.induslockbox.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orchasp.app.induslockbox.entity.Organisation;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
	
	Optional<Organisation> findByCompanyname(String companyname);
}
