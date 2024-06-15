package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.ESI;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.ESIRepository;

@Service
public class ESIService {

	@Autowired
	private ESIRepository ESIRepository;

	@Autowired
	private CompanyRepository companyRepository;

	public List<ESI> findAll() {
		return ESIRepository.findAll();
	}

	public List<ESI> findByCompany_id(Long company_id) {
		return ESIRepository.findByCompany_id(company_id);
	}

	public Optional<ESI> findById(Long id) {
		return ESIRepository.findById(id);
	}

	public ESI updateESI(Long id, ESI updatedESI, String updatedBy) {
		Optional<ESI> existingESIOpt = ESIRepository.findById(id);
		if (existingESIOpt.isPresent()) {
			ESI existingESI = existingESIOpt.get();

			// Update basic fields
			existingESI.setEmployeeCode(updatedESI.getEmployeeCode());
			existingESI.setEmployeeName(updatedESI.getEmployeeName());
			existingESI.setRo(updatedESI.getRo());
			existingESI.setLin(updatedESI.getLin());
	
			existingESI.setCreatedBy(updatedESI.getCreatedBy());
			existingESI.setCreatedDate(updatedESI.getCreatedDate());
			existingESI.setUpdatedBy(updatedBy);
			existingESI.setUpdatedDate(LocalDateTime.now());
			existingESI.setActive(updatedESI.isActive());
			// Update or save company
			Company updatedCompany = updatedESI.getCompany();
			if (updatedCompany != null) {
				Company existingCompany = existingESI.getCompany();
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
					existingCompany.setActive(updatedCompany.isActive());
					existingCompany.setCreatedBy(updatedCompany.getCreatedBy());
					existingCompany.setCreatedDate(updatedCompany.getCreatedDate());
					existingCompany.setUpdatedBy(updatedBy);
					existingCompany.setUpdatedDate(LocalDateTime.now());
					companyRepository.save(existingCompany);
				} else {
					companyRepository.save(updatedCompany);
					existingESI.setCompany(updatedCompany);
				}
			}

			return ESIRepository.save(existingESI);
		} else {
			throw new RuntimeException("ESI not found with id " + id);
		}
	}

	public ESI save(ESI ESI, String createdBy) {
		Long companyId = ESI.getCompany().getCompanyid();
        Optional<ESI> esiop= ESIRepository.findById(companyId);
        ESI e=esiop.get();
        ESI.setCompany(e.getCompany());
		
		ESI.setCreatedBy(createdBy);
		ESI.setCreatedDate(LocalDateTime.now());
		ESI.setUpdatedBy(createdBy);
		ESI.setUpdatedDate(LocalDateTime.now());
		return ESIRepository.save(ESI);
	}

	public void deleteById(Long id) {
		Optional<ESI> ESIOpt = ESIRepository.findById(id);
		if (ESIOpt.isPresent()) {
			ESI b = ESIOpt.get();
			b.setActive(false);
			ESIRepository.save(b);
		}
//        ESIRepository.deleteById(id);
	}

	public void activateById(Long id) {
		Optional<ESI> ESIOpt = ESIRepository.findById(id);
		if (ESIOpt.isPresent()) {
			ESI ESI = ESIOpt.get();
			ESI.setActive(true);
			ESIRepository.save(ESI);
		}
	}
}