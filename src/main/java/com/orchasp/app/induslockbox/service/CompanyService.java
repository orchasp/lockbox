package com.orchasp.app.induslockbox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.Director;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.IncomeTaxRepository;
import com.orchasp.app.induslockbox.repository.EPFRepository;
import com.orchasp.app.induslockbox.repository.DirectorRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private IncomeTaxRepository incomeTaxRepository;

    @Autowired
    private EPFRepository epfRepository;
    
    @Autowired
    private DirectorRepository directorRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    public Optional<Company> getCompanyByName(String companyname) {
        return companyRepository.findByCompanyname(companyname);
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Long id, Company companyDetails) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company existingCompany = optionalCompany.get();

            if (companyDetails.getCompanyname() != null) {
                existingCompany.setCompanyname(companyDetails.getCompanyname());
            }
            if (companyDetails.getDirector() != null) {
                existingCompany.setDirector(companyDetails.getDirector());
            }
            if (companyDetails.getInceptionDate() != null) {
                existingCompany.setInceptionDate(companyDetails.getInceptionDate());
            }
            if (companyDetails.getRegisterNumber() != null) {
                existingCompany.setRegisterNumber(companyDetails.getRegisterNumber());
            }
            if (companyDetails.getPhoneNumber() != null) {
                existingCompany.setPhoneNumber(companyDetails.getPhoneNumber());
            }
            if (companyDetails.getEmail() != null) {
                existingCompany.setEmail(companyDetails.getEmail());
            }
            if (companyDetails.getWebsite() != null) {
                existingCompany.setWebsite(companyDetails.getWebsite());
            }
            if (companyDetails.getDoorNo() != null) {
                existingCompany.setDoorNo(companyDetails.getDoorNo());
            }
            if (companyDetails.getCity() != null) {
                existingCompany.setCity(companyDetails.getCity());
            }
            if (companyDetails.getState() != null) {
                existingCompany.setState(companyDetails.getState());
            }
            if (companyDetails.getPincode() != null) {
                existingCompany.setPincode(companyDetails.getPincode());
            }
            if (companyDetails.getCompanycode() != null) {
                existingCompany.setCompanycode(companyDetails.getCompanycode());
            }

            // Update GST
            if (companyDetails.getGst() != null) {
                if (existingCompany.getGst() != null) {
                    existingCompany.getGst().setGstNumber(companyDetails.getGst().getGstNumber());
                } else {
                    existingCompany.setGst(companyDetails.getGst());
                }
            }

            // Update Bank
            if (companyDetails.getBank() != null) {
                if (existingCompany.getBank() != null) {
                    existingCompany.getBank().setBankAccountNumber(companyDetails.getBank().getBankAccountNumber());
                } else {
                    existingCompany.setBank(companyDetails.getBank());
                }
            }

            // Update IncomeTax
            if (companyDetails.getIncomeTax() != null) {
                if (existingCompany.getIncomeTax() != null) {
                    existingCompany.getIncomeTax().setPanNumber(companyDetails.getIncomeTax().getPanNumber());
                } else {
                    existingCompany.setIncomeTax(companyDetails.getIncomeTax());
                }
            }

            // Update EPF
            if (companyDetails.getEpf() != null) {
                if (existingCompany.getEpf() != null) {
                    existingCompany.getEpf().setEpfNumber(companyDetails.getEpf().getEpfNumber());
                } else {
                    existingCompany.setEpf(companyDetails.getEpf());
                }
            }

            // Update Director
            if (companyDetails.getDirector() != null) {
                if (existingCompany.getDirector() != null) {
                    existingCompany.getDirector().setName(companyDetails.getDirector().getName());
                    existingCompany.getDirector().setAddress(companyDetails.getDirector().getAddress());
                    existingCompany.getDirector().setDinNo(companyDetails.getDirector().getDinNo());
                } else {
                    existingCompany.setDirector(companyDetails.getDirector());
                }
            }

            return companyRepository.save(existingCompany);
        } else {
            throw new RuntimeException("Company not found with id " + id);
        }
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Optional<Director> getDirectorByCompanyId(Long companyId) {
        return directorRepository.findById(companyId);
    }

	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
