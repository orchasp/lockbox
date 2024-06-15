package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
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
    
    public IncomeTax updateIncomeTax(Long id, IncomeTax updatedIncomeTax,String updatedBy) {
        Optional<IncomeTax> existingIncomeTaxOpt = IncomeTaxRepository.findById(id);
        if (existingIncomeTaxOpt.isPresent()) {
            IncomeTax existingIncomeTax = existingIncomeTaxOpt.get();

            // Update basic fields
            existingIncomeTax.setPanNumber(updatedIncomeTax.getPanNumber());
            existingIncomeTax.setName(updatedIncomeTax.getName());
            existingIncomeTax.setIssuedDate(updatedIncomeTax.getIssuedDate());
            existingIncomeTax.setDateOfBirth(updatedIncomeTax.getDateOfBirth());
            
            existingIncomeTax.setActive(updatedIncomeTax.isActive());
            existingIncomeTax.setCreatedBy(updatedIncomeTax.getCreatedBy());
            existingIncomeTax.setCreatedDate(updatedIncomeTax.getCreatedDate());
            existingIncomeTax.setUpdatedBy(updatedBy);
            existingIncomeTax.setUpdatedDate(LocalDateTime.now());

            // Update or save company
            Company updatedCompany = updatedIncomeTax.getCompany();
            if (updatedCompany != null) {
                Company existingCompany = existingIncomeTax.getCompany();
                if (existingCompany != null) {
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

    public IncomeTax save(IncomeTax IncomeTax, String createdBy) {
    	Long companyId = IncomeTax.getCompany().getCompanyid();
        Optional<IncomeTax> itop= IncomeTaxRepository.findById(companyId);
        IncomeTax g=itop.get();
        IncomeTax.setCompany(g.getCompany());
        IncomeTax.setActive(true);
        IncomeTax.setCreatedBy(createdBy);
        IncomeTax.setCreatedDate(LocalDateTime.now());
        IncomeTax.setUpdatedBy(createdBy);
        IncomeTax.setUpdatedDate(LocalDateTime.now());
        return IncomeTaxRepository.save(IncomeTax);
    }

    public void deleteById(Long id) {
    	Optional<IncomeTax> itop=IncomeTaxRepository.findById(id);
    	if(itop.isPresent()) {
    	IncomeTax it=itop.get();
    	it.setActive(false);
    	}
    	//IncomeTaxRepository.deleteById(id);
    }
    
    public void activateById(Long id) {
		Optional<IncomeTax> IncomeTaxOpt = IncomeTaxRepository.findById(id);
		if (IncomeTaxOpt.isPresent()) {
			IncomeTax it =IncomeTaxOpt.get();
			it.setActive(true);
			IncomeTaxRepository.save(it);
		}
	}
    public List<IncomeTax> findByCompany_id(Long company_id) {
		return IncomeTaxRepository.findByCompany_id(company_id);
	}

}