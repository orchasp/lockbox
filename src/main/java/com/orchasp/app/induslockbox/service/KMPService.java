package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
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
	private KMPRepository KMPRepository;

	@Autowired
	private CompanyRepository companyRepository;

	public List<KMP> findAll() {
		return KMPRepository.findAll();
	}

	public List<KMP> findByCompany_id(Long company_id) {
		return KMPRepository.findByCompany_id(company_id);
	}

	public Optional<KMP> findById(Long id) {
		return KMPRepository.findById(id);
	}

	public KMP updateKMP(Long id, KMP updatedKMP, String updatedBy) {
		Optional<KMP> existingKMPOpt = KMPRepository.findById(id);
		if (existingKMPOpt.isPresent()) {
			KMP existingKMP = existingKMPOpt.get();

			// Update basic fields
			existingKMP.setEmail(updatedKMP.getEmail());
			existingKMP.setName(updatedKMP.getName());
			existingKMP.setUserid(updatedKMP.getUserid());
			existingKMP.setPassword(updatedKMP.getPassword());

			existingKMP.setCreatedBy(updatedKMP.getCreatedBy());
			existingKMP.setCreatedDate(updatedKMP.getCreatedDate());
			existingKMP.setUpdatedBy(updatedBy);
			existingKMP.setUpdatedDate(LocalDateTime.now());
			existingKMP.setActive(updatedKMP.isActive());
			// Update or save company
			Company updatedCompany = updatedKMP.getCompany();
			if (updatedCompany != null) {
				Company existingCompany = existingKMP.getCompany();
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
					existingKMP.setCompany(updatedCompany);
				}
			}

			return KMPRepository.save(existingKMP);
		} else {
			throw new RuntimeException("KMP not found with id " + id);
		}
	}

	public KMP save(KMP KMP, String user) {
		
		Long companyId = KMP.getCompany().getCompanyid();
        Optional<KMP> kmpop= KMPRepository.findById(companyId);
        KMP k=kmpop.get();
        KMP.setCompany(k.getCompany());

		KMP.setCreatedBy(user);
		KMP.setCreatedDate(LocalDateTime.now());
		KMP.setUpdatedBy(user);
		KMP.setUpdatedDate(LocalDateTime.now());
		return KMPRepository.save(KMP);
	}

	public void deleteById(Long id) {
		Optional<KMP> KMPOpt = KMPRepository.findById(id);
		if (KMPOpt.isPresent()) {
			KMP b = KMPOpt.get();
			b.setActive(false);
			KMPRepository.save(b);
		}
//        KMPRepository.deleteById(id);
	}

	public void activateById(Long id) {
		Optional<KMP> KMPOpt = KMPRepository.findById(id);
		if (KMPOpt.isPresent()) {
			KMP KMP = KMPOpt.get();
			KMP.setActive(true);
			KMPRepository.save(KMP);
		}
	}
}