package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.Director;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.DirectorRepository;
@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    public Optional<Director> findById(Long id) {
        return directorRepository.findById(id);
    }
    public Director updateDirector(Long id, Director updatedDirector,String updatedBy) {
        Optional<Director> existingDirectorOpt = directorRepository.findById(id);
        if (existingDirectorOpt.isPresent()) {
            Director existingDirector = existingDirectorOpt.get();

            // Update basic fields
            existingDirector.setName(updatedDirector.getName());
            existingDirector.setEmail(updatedDirector.getEmail());
            existingDirector.setDinNo(updatedDirector.getDinNo());
            existingDirector.setActive(updatedDirector.isActive());
            existingDirector.setCreatedBy(updatedDirector.getCreatedBy());
            existingDirector.setCreatedDate(updatedDirector.getCreatedDate());
            existingDirector.setUpdatedBy(updatedBy);
            existingDirector.setUpdatedDate(LocalDateTime.now());
            
            // Update or save company
            Company updatedCompany = updatedDirector.getCompany();
            if (updatedCompany != null) {
                Company existingCompany = existingDirector.getCompany();
                if (existingCompany != null) {
                    // Update existing company fields
                    existingCompany.setOrganizationCode(updatedCompany.getOrganizationCode());
                    existingCompany.setCompanyname(updatedCompany.getCompanyname());
                    existingCompany.setInceptionDate(updatedCompany.getInceptionDate());
                    existingCompany.setRegisterNo(updatedCompany.getRegisterNo());
                    existingCompany.setPhoneNo(updatedCompany.getPhoneNo());
                    existingCompany.setEmail(updatedCompany.getEmail());
                    existingCompany.setFlatNo(updatedCompany.getFlatNo());
                    existingCompany.setWebsite(updatedCompany.getWebsite());
                    existingCompany.setCity(updatedCompany.getCity());
                    existingCompany.setState(updatedCompany.getState());
                    existingCompany.setPincode(updatedCompany.getPincode());
                    existingCompany.setActive(updatedCompany.isActive());
                    existingCompany.setCreatedBy(updatedCompany.getCreatedBy());
                    existingCompany.setCreatedDate(updatedCompany.getCreatedDate());
                    existingCompany.setUpdatedBy(updatedBy);
                    existingCompany.setUpdatedDate(LocalDateTime.now());
                    
                    // Save the updated existing company
                    companyRepository.save(existingCompany);
                } else {
                    // Save the new company from updatedDirector
                    companyRepository.save(updatedCompany);
                    existingDirector.setCompany(updatedCompany);
                }
            }

            // Save and return the updated director
            return directorRepository.save(existingDirector);
        } else {
            throw new RuntimeException("Director not found with id " + id);
        }
    }


    public Director save(Director Director,String createdBy) {
    	
    	Long companyId = Director.getCompany().getCompanyid();
        Optional<Director> dop= directorRepository.findById(companyId);
        Director d=dop.get();
        Director.setCompany(d.getCompany());
        
    	Director.setCreatedBy(createdBy);
    	Director.setUpdatedBy(createdBy);
    	Director.setActive(true);
    	Director.setCreatedDate(LocalDateTime.now());
    	Director.setUpdatedDate(LocalDateTime.now());
        return directorRepository.save(Director);
    }
    
    public List<Director> findByCompany_id(Long company_id) {
		return directorRepository.findByCompany_id(company_id);
	}

    public void deleteById(Long id) {
    	Optional<Director> d =directorRepository.findById(id);
    	if(d.isPresent()) {
    		Director director=d.get();
    		director.setActive(false);
    		directorRepository.save(director);
    	}
    	//directorRepository.deleteById(id);
    }
    
    public void activateById(Long id) {
		Optional<Director> DirectorOpt =directorRepository.findById(id);
		if (DirectorOpt.isPresent()) {
			Director director = DirectorOpt.get();
			director.setActive(true);
			directorRepository.save(director);
		}
	}
}