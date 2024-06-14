package com.orchasp.app.induslockbox.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.service.CompanyService;

@RestController
@RequestMapping("/api/organisations")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAllOrganisations() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getOrganisationById(@PathVariable Long id) {
        Optional<Company> organisation = companyService.findById(id);
        return organisation.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping//http://localhost:8080/api/organisations
    public Company createOrganisation(@RequestBody Company organisation) {
        return companyService.save(organisation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateOrganisation(@PathVariable Long id, @RequestBody Company organisationDetails) {
        try {
            Company updatedOrganisation = companyService.updateCompany(id, organisationDetails);
            return ResponseEntity.ok(updatedOrganisation);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganisation(@PathVariable Long id) {
    	companyService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}