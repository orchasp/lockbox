package com.orchasp.app.induslockbox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Bank;
import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.EPF;
import com.orchasp.app.induslockbox.entity.GST;
import com.orchasp.app.induslockbox.entity.IncomeTax;
import com.orchasp.app.induslockbox.repository.BankRepository;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.EPFRepository;
import com.orchasp.app.induslockbox.repository.GSTRepository;
import com.orchasp.app.induslockbox.repository.IncomeTaxRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private GSTRepository gstRepository;

    @Autowired
    private IncomeTaxRepository incomeTaxRepository;

    @Autowired
    private EPFRepository epfRepository;
    

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    public Optional<Company> getCompanyByName(String companyName) {
        return companyRepository.findByCompanyname(companyName);
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Long id, Company companyDetails) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company existingCompany = optionalCompany.get();

            // Update company fields
            if (companyDetails.getCompanyname() != null) {
                existingCompany.setCompanyname(companyDetails.getCompanyname());
            }

            // Update GST
            if (existingCompany.getGst() != null && companyDetails.getGst() != null) {
                existingCompany.getGst().setGstNumber(companyDetails.getGst().getGstNumber());
            } else if (companyDetails.getGst() != null) {
                existingCompany.setGst(companyDetails.getGst());
            }

            // Update Bank
            if (existingCompany.getBank() != null && companyDetails.getBank() != null) {
                existingCompany.getBank().setBankAccountNumber(companyDetails.getBank().getBankAccountNumber());
            } else if (companyDetails.getBank() != null) {
                existingCompany.setBank(companyDetails.getBank());
            }

            // Update IncomeTax
            if (existingCompany.getIncomeTax() != null && companyDetails.getIncomeTax() != null) {
                existingCompany.getIncomeTax().setPanNumber(companyDetails.getIncomeTax().getPanNumber());
            } else if (companyDetails.getIncomeTax() != null) {
                existingCompany.setIncomeTax(companyDetails.getIncomeTax());
            }

            // Update EPF
            if (existingCompany.getEpf() != null && companyDetails.getEpf() != null) {
                existingCompany.getEpf().setEpfNumber(companyDetails.getEpf().getEpfNumber());
            } else if (companyDetails.getEpf() != null) {
                existingCompany.setEpf(companyDetails.getEpf());
            }

            return companyRepository.save(existingCompany);
        } else {
            return null;
        }
    }

    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Bank> getBanksByCompanyId(Long companyId) {
        return bankRepository.findById(companyId);
    }

    public Optional<GST> getGSTByCompanyId(Long companyId) {
        return gstRepository.findById(companyId);
    }

    public Optional<IncomeTax> getIncomeTaxByCompanyId(Long companyId) {
        return incomeTaxRepository.findById(companyId);
    }

    public Optional<EPF> getEPFByCompanyId(Long companyId) {
        return epfRepository.findById(companyId);
    }
   
}
