package com.orchasp.app.induslockbox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.KMP;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.KMPRepository;

@Service
public class KMPService {

    @Autowired
    private KMPRepository kmpRepository; // Changed to lowercase 'k'

    @Autowired
    private CompanyRepository companyRepository;

    public List<KMP> findAll() {
        return kmpRepository.findAll();
    }

    public Optional<KMP> findById(Long id) {
        return kmpRepository.findById(id);
    }

    public KMP updateKMP(Long id, KMP updatedKMP) {
        Optional<KMP> existingKMPOpt = kmpRepository.findById(id);
        if (existingKMPOpt.isPresent()) {
            KMP existingKmp = existingKMPOpt.get();

            // Update basic fields
            existingKmp.setUserid(updatedKMP.getUserid());
            existingKmp.setName(updatedKMP.getName());
            existingKmp.setPassword(updatedKMP.getPassword());

            // Update or save company
            Company updatedCompany = updatedKMP.getCompany();
            if (updatedCompany != null) {
                Company existingCompany = existingKmp.getCompany();
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
                    existingKmp.setCompany(companyRepository.save(updatedCompany));
                }
            }

            return kmpRepository.save(existingKmp);
        } else {
            throw new RuntimeException("KMP not found with id " + id); // More specific message
        }
    }

    public KMP save(KMP kmp) {
        return kmpRepository.save(kmp);
    }

    public void deleteById(Long id) {
        kmpRepository.deleteById(id);
    }
}
