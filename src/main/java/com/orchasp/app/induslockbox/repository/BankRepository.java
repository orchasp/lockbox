package com.orchasp.app.induslockbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orchasp.app.induslockbox.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}
