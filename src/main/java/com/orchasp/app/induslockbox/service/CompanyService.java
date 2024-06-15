package com.orchasp.app.induslockbox.service;

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
    
    public Company updateCompany(Long id, Company updatedCompany) {
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

            return CompanyRepository.save(existingCompany);
        } else {
            throw new RuntimeException("Company not found with id " + id);
        }
    }

    public  Company save( Company organisation) {
        return CompanyRepository.save(organisation);
    }

    public void deleteById(Long id) {
    	CompanyRepository.deleteById(id);
    }
}