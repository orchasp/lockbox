package com.orchasp.app.induslockbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orchasp.app.induslockbox.entity.GST;

@Repository
public interface GSTRepository extends JpaRepository<GST, Long> {

}
