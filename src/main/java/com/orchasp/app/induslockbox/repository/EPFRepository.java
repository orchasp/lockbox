package com.orchasp.app.induslockbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orchasp.app.induslockbox.entity.EPF;

@Repository
public interface EPFRepository extends JpaRepository<EPF, Long> {
	// List<EPF> findByCompany_Id(Long companyId);
}
