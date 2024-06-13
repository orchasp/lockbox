package com.orchasp.app.induslockbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orchasp.app.induslockbox.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

}
