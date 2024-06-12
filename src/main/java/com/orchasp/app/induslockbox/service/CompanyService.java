package com.orchasp.app.induslockbox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Bank;
import com.orchasp.app.induslockbox.entity.EPF;
import com.orchasp.app.induslockbox.entity.GST;
import com.orchasp.app.induslockbox.entity.IncomeTax;
import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.repository.BankRepository;
import com.orchasp.app.induslockbox.repository.EPFRepository;
import com.orchasp.app.induslockbox.repository.GSTRepository;
import com.orchasp.app.induslockbox.repository.IncomeTaxRepository;
import com.orchasp.app.induslockbox.repository.CompanyRepository;

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

	public List<Company> getAllOrganisations() {
		return organisationRepository.findAll();
	}

	public Optional<Company> getOrganisationById(Long id) {
		return organisationRepository.findById(id);
	}

	public Optional<Company> getOrganisationByName(String companyname) {
		return organisationRepository.findByCompanyname(companyname);
	}

	public Company createOrganisation(Company organisation) {
		return organisationRepository.save(organisation);
	}

	public Company updateOrganisation(Long id, Company organisationDetails) {
		Optional<Company> optionalOrganisation = organisationRepository.findById(id);
		if (optionalOrganisation.isPresent()) {
			Company existingOrganisation = optionalOrganisation.get();

			// organisation
			existingOrganisation.setCompanyname(organisationDetails.getCompanyname());

			// GST
			if (existingOrganisation.getGst() != null && organisationDetails.getGst() != null) {
				existingOrganisation.getGst().setGstNumber(organisationDetails.getGst().getGstNumber());
			} else {
				existingOrganisation.setGst(organisationDetails.getGst());
			}

			// Bank
			if (existingOrganisation.getBank() != null && organisationDetails.getBank() != null) {
				existingOrganisation.getBank()
						.setBankAccountNumber(organisationDetails.getBank().getBankAccountNumber());
			} else {
				existingOrganisation.setBank(organisationDetails.getBank());
			}

			// IncomeTax
			if (existingOrganisation.getIncomeTax() != null && organisationDetails.getIncomeTax() != null) {
				existingOrganisation.getIncomeTax().setPanNumber(organisationDetails.getIncomeTax().getPanNumber());
			} else {
				existingOrganisation.setIncomeTax(organisationDetails.getIncomeTax());
			}

			// EPF
			if (existingOrganisation.getEpf() != null && organisationDetails.getEpf() != null) {
				existingOrganisation.getEpf().setEpfNumber(organisationDetails.getEpf().getEpfNumber());
			} else {
				existingOrganisation.setEpf(organisationDetails.getEpf());
			}

			return organisationRepository.save(existingOrganisation);
		} else {
			return null;
		}
	}

	public void deleteOrganisation(Long id) {
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
