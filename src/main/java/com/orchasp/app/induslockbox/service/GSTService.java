package com.orchasp.app.induslockbox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.GST;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.GSTRepository;

@Service
public class GSTService {

    @Autowired
    private GSTRepository GSTRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public List<GST> findAll() {
        return GSTRepository.findAll();
    }

    public Optional<GST> findById(Long id) {
        return GSTRepository.findById(id);
    }
    
    public GST updateGST(Long id, GST updatedGST) {
        Optional<GST> existingGSTOpt = GSTRepository.findById(id);
        if (existingGSTOpt.isPresent()) {
            GST existingGST = existingGSTOpt.get();

            // Update basic fields
         
            existingGST.setGstNumber(updatedGST.getGstNumber());
            existingGST.setUserid(updatedGST.getUserid());
            existingGST.setPassword(updatedGST.getPassword());

            // Update or save company
            Company updatedCompany = updatedGST.getCompany();
            if (updatedCompany != null) {
                Company existingCompany = existingGST.getCompany();
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
                    existingGST.setCompany(updatedCompany);
                }
            }

            return GSTRepository.save(existingGST);
        } else {
            throw new RuntimeException("GST not found with id " + id);
        }
    }

    public GST save(GST GST) {
        return GSTRepository.save(GST);
    }

    public void deleteById(Long id) {
    	GSTRepository.deleteById(id);
    }
}