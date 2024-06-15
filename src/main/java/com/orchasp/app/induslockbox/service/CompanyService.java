package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private  CompanyRepository  CompanyRepository;

    public List< Company> findAll() {
        return CompanyRepository.findAll();
    }

    public Optional< Company> findById(Long id) {
        return CompanyRepository.findById(id);
    }
    
    public Company updateCompany(Long id, Company updatedCompany,String updatedBy) {
        Optional<Company> existingCompanyOpt = CompanyRepository.findById(id);
        if (existingCompanyOpt.isPresent()) {
            Company existingCompany = existingCompanyOpt.get();

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
            
            existingCompany.setCreatedBy(updatedCompany.getCreatedBy());
            existingCompany.setCreatedDate(updatedCompany.getCreatedDate());
            existingCompany.setUpdatedBy(updatedBy);
            existingCompany.setUpdatedDate(LocalDateTime.now());
            existingCompany.setActive(updatedCompany.isActive());

            return CompanyRepository.save(existingCompany);
        } else {
            throw new RuntimeException("Company not found with id " + id);
        }
    }

    public  Company save( Company organisation,String createdBy) {
    	organisation.setCreatedBy(createdBy);
    	organisation.setActive(true);
    	organisation.setUpdatedBy(createdBy);
    	organisation.setCreatedDate(LocalDateTime.now());
    	organisation.setUpdatedDate(LocalDateTime.now());
        return CompanyRepository.save(organisation);
    }

    public void deleteById(Long id) {
    	Optional<Company> company=CompanyRepository.findById(id);
    	if(company.isPresent()) {
    		Company c=company.get();
    		c.setActive(false);
    		CompanyRepository.save(c);
    	}
    	//CompanyRepository.deleteById(id);
    }
    
    public void activateById(Long id) {
		Optional<Company> companyOpt = CompanyRepository.findById(id);
		if (companyOpt.isPresent()) {
			Company company = companyOpt.get();
			company.setActive(true);
			CompanyRepository.save(company);
		}
	}
}