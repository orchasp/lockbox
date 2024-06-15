package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.GST;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.GSTRepository;

@Service
public class GSTService {

    @Autowired
    private GSTRepository GSTRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public List<GST> findAll() {
        return GSTRepository.findAll();
    }

    public Optional<GST> findById(Long id) {
        return GSTRepository.findById(id);
    }
    
    public GST updateGST(Long id, GST updatedGST,String updatedBy) {
        Optional<GST> existingGSTOpt = GSTRepository.findById(id);
        if (existingGSTOpt.isPresent()) {
            GST existingGST = existingGSTOpt.get();

            // Update basic fields
         
            existingGST.setGstNumber(updatedGST.getGstNumber());
            existingGST.setUserid(updatedGST.getUserid());
            existingGST.setPassword(updatedGST.getPassword());
            
            existingGST.setActive(updatedGST.isActive());
            existingGST.setCreatedBy(updatedGST.getCreatedBy());
            existingGST.setCreatedDate(updatedGST.getCreatedDate());
            existingGST.setUpdatedBy(updatedBy);
            existingGST.setUpdatedDate(LocalDateTime.now());

            // Update or save company
            Company updatedCompany = updatedGST.getCompany();
            if (updatedCompany != null) {
                Company existingCompany = existingGST.getCompany();
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
                    existingGST.setCompany(updatedCompany);
                }
            }

            return GSTRepository.save(existingGST);
        } else {
            throw new RuntimeException("GST not found with id " + id);
        }
    }

    public GST save(GST GST,String createdBy) {
    	
    	Long companyId = GST.getCompany().getCompanyid();
        Optional<GST> gstop= GSTRepository.findById(companyId);
        GST g=gstop.get();
        GST.setCompany(g.getCompany());
    	
    	GST.setActive(true);
    	GST.setCreatedBy(createdBy);
    	GST.setCreatedDate(LocalDateTime.now());
    	GST.setUpdatedBy(createdBy);
    	GST.setUpdatedDate(LocalDateTime.now());
        return GSTRepository.save(GST);
    }

    public void deleteById(Long id) {
    	Optional<GST> gstop=GSTRepository.findById(id);
    	if(gstop.isPresent()) {
    		GST gst=gstop.get();
    		gst.setActive(false);
    		GSTRepository.save(gst);
    	}
    	//GSTRepository.deleteById(id);
    }
    
    public void activateById(Long id) {
		Optional<GST>GSTOpt = GSTRepository.findById(id);
		if (GSTOpt.isPresent()) {
			GST gst = GSTOpt.get();
			gst.setActive(true);
			GSTRepository.save(gst);
		}
	}
    public List<GST> findByCompany_id(Long company_id) {
		return GSTRepository.findByCompany_id(company_id);
	}

}