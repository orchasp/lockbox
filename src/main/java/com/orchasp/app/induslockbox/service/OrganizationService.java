package com.orchasp.app.induslockbox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Organization;
import com.orchasp.app.induslockbox.repository.OrganizationRepository;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepository repo;
	
	public Organization saveOrganization(Organization organization) {
		return repo.save(organization);
	}
	public List<Organization> getAllOrganizations(){
		return repo.findAll();
	}
	public Organization getOrganizationById(Long id) {
		Optional<Organization>k=repo.findById(id);
		if(k.isPresent())
			return k.get();
		else
			return null;
	}
	public Organization updateOrganization(Long id, Organization organization)
	{
		Optional<Organization>k=repo.findById(organization.getId());
		Organization o=k.get();
		if(k.isPresent()) {
			if(o.getOrganizationCode()==null)
				organization.setOrganizationCode(o.getOrganizationCode());
		if(o.getOrganizationName()==null)
			organization.setOrganizationName(o.getOrganizationName());
		if(o.getAddress()==null)
			organization.setAddress(o.getAddress());
		if(o.getCeCode()==null)
			organization.setCeCode(o.getCeCode());
			if(o.getCerNo()==null)
				organization.setCerNo(o.getCerNo());
			if(o.getGstNumber()==null)
				organization.setGstNumber(o.getGstNumber());
			if(o.getGstRate()==null)
				organization.setGstRate(o.getGstRate());
			if(o.getDrclNo()==null)
				organization.setDrclNo(o.getDrclNo());
			if(o.geteMail()==null)
				organization.seteMail(o.geteMail());
			if(o.getFax()==null)
				organization.setFax(o.getFax());
			if(o.getEximCode()==null)
				organization.setEximCode(o.getEximCode());
		if(o.getTeleex()==null)
			organization.setTeleex(o.getTeleex());
		if(o.getTdsAccount()==null)
			organization.setTdsAccount(o.getTdsAccount());
		if(o.getRegisterNo()==null)
			organization.setRegisterNo(o.getRegisterNo());
		if(o.getPlace()==null)
			organization.setPlace(o.getPlace());
		if(o.getPincode()==null)
			organization.setPincode(o.getPincode());
		if(o.getPhoneNo()==null)
			organization.setPhoneNo(o.getPhoneNo());
		if(o.getEximCode()==null)
			organization.setEximCode(o.getEximCode());
		return repo.save(organization);
		}
		else return null;
	}
	public Organization deleteOrganization(Long id) {
		Optional<Organization>k=repo.findById(id);
		if(k.isPresent()) {
			repo.deleteById(id);
		return  k.get();
		}
		else {
			return null;
		}
		
	}
}

	
	


