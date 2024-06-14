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

<<<<<<< HEAD
	@Autowired
	private IncomeTaxRepository incomeTaxRepository;

	@Autowired
	private EPFRepository epfRepository;
	
	@Autowired
	private DirectorRepository directorRepository;

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
	        if (companyDetails.getRegisterNumber() == null) {
	            companyDetails.setRegisterNumber(existingCompany.getRegisterNumber());
	        }
	        if (companyDetails.getPhoneNumber() == null) {
	            companyDetails.setPhoneNumber(existingCompany.getPhoneNumber());
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
	        if (companyDetails.getCompanycode() == null) {
	            companyDetails.setCompanycode(existingCompany.getCompanycode());
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
	
	     // Director
		    if (existingCompany.getDirector() != null && companyDetails.getDirector() != null) {
                existingCompany.getDirector().setName(companyDetails.getDirector().getName());
                existingCompany.getDirector().setAddress(companyDetails.getDirector().getAddress());
                existingCompany.getDirector().setDinNo(companyDetails.getDirector().getDinNo());
            } else if
            (companyDetails.getDirector()!=null) {
                existingCompany.setDirector(companyDetails.getDirector());
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
=======
    public List< Company> findAll() {
        return CompanyRepository.findAll();
>>>>>>> 2bab7318d52299c06ca93ea5080e89e923054a3d
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
<<<<<<< HEAD
    public Optional<Director> getDirectorByCompanyId(Long companyid){
    	return directorRepository.findById(companyid);
    }
   
=======
>>>>>>> 2bab7318d52299c06ca93ea5080e89e923054a3d
}