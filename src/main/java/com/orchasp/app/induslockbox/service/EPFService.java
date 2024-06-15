package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
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

	public EPF updateEPF(Long id, EPF updatedEPF, String updatedBy) {
		Optional<EPF> existingEPFOpt = EPFRepository.findById(id);
		if (existingEPFOpt.isPresent()) {
			EPF existingEPF = existingEPFOpt.get();
//			String changes = updatedChanges(existingEPF, updatedEPF);
			// Update basic fields
			existingEPF.setEstid(updatedEPF.getEstid());
			existingEPF.setLin(updatedEPF.getLin());
			existingEPF.setNiccode(updatedEPF.getNiccode());
			existingEPF.setPanno(updatedEPF.getPanno());
			existingEPF.setPfoffice(updatedEPF.getPfoffice());
			existingEPF.setSignatory(updatedEPF.getSignatory());
			existingEPF.setActive(updatedEPF.isActive());
			existingEPF.setCreatedBy(updatedEPF.getCreatedBy());
			existingEPF.setCreatedDate(updatedEPF.getCreatedDate());
			existingEPF.setUpdatedBy(updatedBy);
			existingEPF.setUpdatedDate(LocalDateTime.now());

			// Update or save company
			Company updatedCompany = updatedEPF.getCompany();
			if (updatedCompany != null) {
				Company existingCompany = existingEPF.getCompany();
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

					existingCompany.setCreatedBy(updatedCompany.getCreatedBy());
					existingCompany.setCreatedDate(updatedCompany.getCreatedDate());
					existingCompany.setUpdatedBy(updatedBy);
					existingCompany.setUpdatedDate(LocalDateTime.now());
					existingCompany.setActive(updatedCompany.isActive());
					companyRepository.save(existingCompany);
				} else {
					companyRepository.save(updatedCompany);
					existingEPF.setCompany(updatedCompany);
				}
			}
			EPF epf = EPFRepository.save(existingEPF);

			// llogging
//			epfUpdateAuditService.log(epf.getId(), "UPDATE", updatedBy, changes);
			return epf;
		} else {
			throw new RuntimeException("EPF not found with id " + id);
		}
	}

	public EPF save(EPF EPF, String createdBy) {
		
		Long companyId = EPF.getCompany().getCompanyid();
        Optional<EPF> epfop= EPFRepository.findById(companyId);
        EPF e=epfop.get();
        EPF.setCompany(e.getCompany());
		EPF.setActive(true);
		EPF.setCreatedBy(createdBy);
		EPF.setCreatedDate(LocalDateTime.now());
		EPF.setUpdatedBy(createdBy);
		EPF.setUpdatedDate(LocalDateTime.now());
		EPF epf = EPFRepository.save(EPF);
//		epfCreateAuditService.createdlog(epf.getId(), "CREATE", createdBy);
		return epf;
	}

	public void deleteById(Long id) {
		Optional<EPF> epfop=EPFRepository.findById(id);
		if(epfop.isPresent()) {
			EPF epf=epfop.get();
			epf.setActive(false);
			EPFRepository.save(epf);
		}
		//EPFRepository.deleteById(id);
	}
	
	 public List<EPF> findByCompany_id(Long company_id) {
			return EPFRepository.findByCompany_id(company_id);
		}

	
	public void activateById(Long id) {
		Optional<EPF> EPFOpt = EPFRepository.findById(id);
		if (EPFOpt.isPresent()) {
			EPF epf = EPFOpt.get();
			epf.setActive(true);
			EPFRepository.save(epf);
		}
	}

	// recording the changes log
//	public String updatedChanges(EPF e, EPF u) {
//		StringBuilder changes = new StringBuilder();
//		if (!e.getEstid().equals(u.getEstid())) {
//			changes.append("EPF number is changed from ").append(e.getEstid()).append(" to ")
//					.append(u.getEstid()).append(".");
//		}
//		return changes.toString();
//	}
}