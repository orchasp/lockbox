package com.orchasp.app.induslockbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orchasp.app.induslockbox.entity.IncomeTax;

@Repository
public interface IncomeTaxRepository extends JpaRepository<IncomeTax, Long> {
	//List<IncomeTax> findByCompany_Id(Long companyId);
}
