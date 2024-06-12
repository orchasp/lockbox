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
	private CompanyRepository organisationRepository;
	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private GSTRepository gstRepository;

	@Autowired
	private IncomeTaxRepository incomeTaxRepository;

	@Autowired
	private EPFRepository epfRepository;
	

	public List<Company> getAllCompanies() {
		return organisationRepository.findAll();
	}

	public Optional<Company> getCompanyById(Long id) {
		return organisationRepository.findById(id);
	}

	public Optional<Company> getCompanyByName(String companyname) {
		return organisationRepository.findByCompanyname(companyname);
	}

	public Company createCompany(Company organisation) {
		return organisationRepository.save(organisation);
	}

	public Company updateCompany(Long id, Company companyDetails) {
		Optional<Company> optionalOrganisation = organisationRepository.findById(id);
		Company existingCompany = optionalOrganisation.get();
		if (optionalOrganisation.isPresent()) {

			// organisation
			//existingCompany.setCompanyname(companyDetails.getCompanyname());
			if(companyDetails.getCompanyname()==null) {
				companyDetails.setCompanyname(existingCompany.getCompanyname());
			}
			if(companyDetails.getDirector()==null) {
				companyDetails.setDirector(existingCompany.getDirector());
			}
			if (companyDetails.getInceptionDate() == null) {
	            companyDetails.setInceptionDate(existingCompany.getInceptionDate());
	        }
	        if (companyDetails.getRegisterNo() == null) {
	            companyDetails.setRegisterNo(existingCompany.getRegisterNo());
	        }
	        if (companyDetails.getPhoneNo() == null) {
	            companyDetails.setPhoneNo(existingCompany.getPhoneNo());
	        }
	        if (companyDetails.getEmail() == null) {
	            companyDetails.setEmail(existingCompany.getEmail());
	        }
	        if (companyDetails.getWebsite() == null) {
	            companyDetails.setWebsite(existingCompany.getWebsite());
	        }
	        if (companyDetails.getDoorNo() == null) {
	            companyDetails.setDoorNo(existingCompany.getDoorNo());
	        }
	        if (companyDetails.getCity() == null) {
	            companyDetails.setCity(existingCompany.getCity());
	        }
	        if (companyDetails.getState() == null) {
	            companyDetails.setState(existingCompany.getState());
	        }
	        if (companyDetails.getPincode() == null) {
	            companyDetails.setPincode(existingCompany.getPincode());
	        }
	        if (companyDetails.getOrganizationCode() == null) {
	            companyDetails.setOrganizationCode(existingCompany.getOrganizationCode());
	        }
			
			// GST
			if (existingCompany.getGst() != null && companyDetails.getGst() != null) {
				existingCompany.getGst().setGstNumber(companyDetails.getGst().getGstNumber());
			} else {
				existingCompany.setGst(companyDetails.getGst());
			}

			// Bank
			if (existingCompany.getBank() != null && companyDetails.getBank() != null) {
				existingCompany.getBank()
						.setBankAccountNumber(companyDetails.getBank().getBankAccountNumber());
			} else {
				existingCompany.setBank(companyDetails.getBank());
			}

			// IncomeTax
			if (existingCompany.getIncomeTax() != null && companyDetails.getIncomeTax() != null) {
				existingCompany.getIncomeTax().setPanNumber(companyDetails.getIncomeTax().getPanNumber());
			} else {
				existingCompany.setIncomeTax(companyDetails.getIncomeTax());
			}

			// EPF
			if (existingCompany.getEpf() != null && companyDetails.getEpf() != null) {
				existingCompany.getEpf().setEpfNumber(companyDetails.getEpf().getEpfNumber());
			} else {
				existingCompany.setEpf(companyDetails.getEpf());
			}

			return organisationRepository.save(existingCompany);
		} else {
			return null;
		}
	}

	public void deleteCompany(Long id) {
		organisationRepository.deleteById(id);
	}

	public Optional<Bank> getBanksByCompanyId(Long companyid) {
        return bankRepository.findById(companyid);
    }

    public Optional<GST> getGSTByCompanyId(Long companyid) {
        return gstRepository.findById(companyid);
    }

    public Optional<IncomeTax> getIncomeTaxByCompanyId(Long companyid) {
        return incomeTaxRepository.findById(companyid);
    }

    public Optional<EPF> getEPFByCompanyId(Long companyid) {
        return epfRepository.findById(companyid);
    }
    
   
}
