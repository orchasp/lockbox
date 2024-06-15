package com.orchasp.app.induslockbox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.IncomeTax;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.IncomeTaxRepository;

@Service
public class IncomeTaxService {

    @Autowired
    private IncomeTaxRepository IncomeTaxRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public List<IncomeTax> findAll() {
        return IncomeTaxRepository.findAll();
    }

    public Optional<IncomeTax> findById(Long id) {
        return IncomeTaxRepository.findById(id);
    }
    
    public IncomeTax updateIncomeTax(Long id, IncomeTax updatedIncomeTax) {
        Optional<IncomeTax> existingIncomeTaxOpt = IncomeTaxRepository.findById(id);
        if (existingIncomeTaxOpt.isPresent()) {
            IncomeTax existingIncomeTax = existingIncomeTaxOpt.get();

            // Update basic fields
            existingIncomeTax.setPanNumber(updatedIncomeTax.getPanNumber());
            existingIncomeTax.setName(updatedIncomeTax.getName());
            existingIncomeTax.setIssuedDate(updatedIncomeTax.getIssuedDate());
            existingIncomeTax.setDateOfBirth(updatedIncomeTax.getDateOfBirth());

            // Update or save company
            Company updatedCompany = updatedIncomeTax.getCompany();
            if (updatedCompany != null) {
                Company existingCompany = existingIncomeTax.getCompany();
                if (existingCompany != null) {
                    existingCompany.setCompanycode(updatedCompany.getCompanycode());
                    existingCompany.setCompanyname(updatedCompany.getCompanyname());
                    existingCompany.setInceptionDate(updatedCompany.getInceptionDate());
                    existingCompany.setRegisterNumber(updatedCompany.getRegisterNumber());
                    existingCompany.setPhoneNumber(updatedCompany.getPhoneNumber());
                    existingCompany.setEmail(updatedCompany.getEmail());
                    existingCompany.setFlatNo(updatedCompany.getFlatNo());
                    existingCompany.setWebsite(updatedCompany.getWebsite());
                    existingCompany.setCity(updatedCompany.getCity());
                    existingCompany.setState(updatedCompany.getState());
                    existingCompany.setPincode(updatedCompany.getPincode());
                    companyRepository.save(existingCompany);
                } else {
                    companyRepository.save(updatedCompany);
                    existingIncomeTax.setCompany(updatedCompany);
                }
            }

            return IncomeTaxRepository.save(existingIncomeTax);
        } else {
            throw new RuntimeException("IncomeTax not found with id " + id);
        }
    }

    public IncomeTax save(IncomeTax IncomeTax) {
        return IncomeTaxRepository.save(IncomeTax);
    }

    public void deleteById(Long id) {
    	IncomeTaxRepository.deleteById(id);
    }
}