package com.orchasp.app.induslockbox.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.service.CompanyService;

@RestController
@RequestMapping("/api/organisations")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/fetchall")
    public List<Company> getAllOrganisations() {
        return companyService.findAll();
    }

    @GetMapping("/fetchbyid/{id}")
    public ResponseEntity<Company> getOrganisationById(@PathVariable Long id) {
        Optional<Company> organisation = companyService.findById(id);
        return organisation.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")//http://localhost:8080/api/organisations/save
    public Company createOrganisation(@RequestBody Company organisation,@RequestParam String createdBy) {
        return companyService.save(organisation,createdBy);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Company> updateOrganisation(@PathVariable Long id, @RequestBody Company organisationDetails,@RequestParam String updatedBy) {
        try {
            Company updatedOrganisation = companyService.updateCompany(id, organisationDetails,updatedBy);
            return ResponseEntity.ok(updatedOrganisation);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrganisation(@PathVariable Long id) {
    	companyService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/activate/{id}")
    public void activateCompany(@PathVariable Long id) {
        companyService.activateById(id);
    }
}