package com.orchasp.app.induslockbox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.EPF;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.EPFRepository;

@Service
public class EPFService {

    @Autowired
    private EPFRepository EPFRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public List<EPF> findAll() {
        return EPFRepository.findAll();
    }

    public Optional<EPF> findById(Long id) {
        return EPFRepository.findById(id);
    }
    public EPF updateEPF(Long id, EPF updatedEPF) {
        Optional<EPF> existingEPFOpt = EPFRepository.findById(id);
        if (existingEPFOpt.isPresent()) {
            EPF existingEPF = existingEPFOpt.get();

            // Update basic fields
            existingEPF.setEpfNumber(updatedEPF.getEpfNumber());

            // Update or save company
            Company updatedCompany = updatedEPF.getCompany();
            if (updatedCompany != null) {
                Company existingCompany = existingEPF.getCompany();
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
                    existingEPF.setCompany(updatedCompany);
                }
            }

            return EPFRepository.save(existingEPF);
        } else {
            throw new RuntimeException("EPF not found with id " + id);
        }
    }

    public EPF save(EPF EPF) {
        return EPFRepository.save(EPF);
    }

    public void deleteById(Long id) {
        EPFRepository.deleteById(id);
    }
}