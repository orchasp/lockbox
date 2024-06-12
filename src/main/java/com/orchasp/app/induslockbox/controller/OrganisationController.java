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

import com.orchasp.app.induslockbox.entity.Bank;
import com.orchasp.app.induslockbox.entity.EPF;
import com.orchasp.app.induslockbox.entity.GST;
import com.orchasp.app.induslockbox.entity.IncomeTax;
import com.orchasp.app.induslockbox.entity.Organisation;
import com.orchasp.app.induslockbox.service.OrganisationService;



@RestController
@RequestMapping("/organisations")
public class OrganisationController {
    @Autowired
    private OrganisationService organisationService;

    @GetMapping
    public List<Organisation> getAllOrganisations() {
        return organisationService.getAllOrganisations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organisation> getOrganisationById(@PathVariable Long id) {
        Optional<Organisation> organisation = organisationService.getOrganisationById(id);
        if (organisation.isPresent()) {
            return ResponseEntity.ok(organisation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{companyname}")
    public ResponseEntity<Organisation> getOrganisationByName(@PathVariable String companyname) {
        Optional<Organisation> organisation = organisationService.getOrganisationByName(companyname);
        if (organisation.isPresent()) {
            return ResponseEntity.ok(organisation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public Organisation createOrganisation(@RequestBody Organisation organisation) {
        return organisationService.createOrganisation(organisation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organisation> updateOrganisation(@PathVariable Long id, @RequestBody Organisation organisationDetails) {
        Organisation updatedOrganisation = organisationService.updateOrganisation(id, organisationDetails);
        if (updatedOrganisation != null) {
            return ResponseEntity.ok(updatedOrganisation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganisation(@PathVariable Long id) {
        organisationService.deleteOrganisation(id);
        return ResponseEntity.noContent().build();
    }
    
    //////////////////////
    

    @GetMapping("/banks/{companyid}")
    public ResponseEntity<Optional<Bank>> getBanksByOrganisationId(@PathVariable Long companyid) {
        Optional<Bank> banks = organisationService.getBanksByCompanyId(companyid);
        if (banks.isPresent()) {
            return ResponseEntity.ok(banks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/gst/{companyid}")
    public ResponseEntity<Optional<GST>> getGSTByOrganisationName(@PathVariable Long companyid) {
        Optional<GST> gst = organisationService.getGSTByCompanyId(companyid);
        if (gst != null) {
            return ResponseEntity.ok(gst);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/incometax/{companyid}")
    public ResponseEntity<Optional<IncomeTax>> getIncomeTaxByOrganisationName(@PathVariable Long companyid) {
        Optional<IncomeTax> incomeTax = organisationService.getIncomeTaxByCompanyId(companyid);
        if (incomeTax != null) {
            return ResponseEntity.ok(incomeTax);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/epf/{companyid}")
    public ResponseEntity<Optional<EPF>> getEPFByOrganisationName(@PathVariable Long companyid) {
        Optional<EPF> epf = organisationService.getEPFByCompanyId(companyid);
        if (epf != null) {
            return ResponseEntity.ok(epf);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


