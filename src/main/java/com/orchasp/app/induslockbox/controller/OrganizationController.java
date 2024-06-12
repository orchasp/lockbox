package com.orchasp.app.induslockbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orchasp.app.induslockbox.entity.Organization;


@RestController
public class OrganizationController {
	@Autowired
	  private OrganizationService organizationService;
	  
	  @PostMapping("/save") 
		 public Organization saveOrganization(@RequestBody Organization organization) {
			 return organizationService.saveOrganization(organization);
		 }
	  @GetMapping("/{id}")
		 public Organization getOrganizationdById(@PathVariable long id) {
			 return organizationService.getOrganizationById(id);
		 }
	  @GetMapping("/fetchall")
	    public List<Organization> getOrganization() {
	        return organizationService.getAllOrganization();
	    }
	  @DeleteMapping("/{id}")
	    public Organization deleteOrganization(@PathVariable Long id) {
		 	return organizationService.deleteOrganization(id);
	       
	    }
	  @PutMapping("/update/{id}")
		public Organization updateOrganization(@PathVariable Long id, @RequestBody Organization organization) {
			return organizationService.updateOrganization(id,  organization);
		}
}


}