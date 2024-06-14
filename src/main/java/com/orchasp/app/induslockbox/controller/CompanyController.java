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
import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.service.CompanyService;



@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/getall")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Optional<Company> obj = companyService.getCompanyById(id);
        if (obj.isPresent()) {
            return ResponseEntity.ok(obj.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{companyname}")
    public ResponseEntity<Company> getCompanyByName(@PathVariable String companyname) {
        Optional<Company> obj = companyService.getCompanyByName(companyname);
        if (obj.isPresent()) {
            return ResponseEntity.ok(obj.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
        Company updatedCompany = companyService.updateCompany(id, companyDetails);
        if (updatedCompany != null) {
            return ResponseEntity.ok(updatedCompany);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
    	companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
    
   //getting bank records
    @GetMapping("/banks/{companyid}")
    public ResponseEntity<Optional<Bank>> getBanksByCompanyId(@PathVariable Long companyid) {
        Optional<Bank> banks = companyService.getBanksByCompanyId(companyid);
        if (banks.isPresent()) {
            return ResponseEntity.ok(banks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  //getting gst records
    @GetMapping("/gst/{companyid}")
    public ResponseEntity<Optional<GST>> getGSTByCompanyName(@PathVariable Long companyid) {
        Optional<GST> gst = companyService.getGSTByCompanyId(companyid);
        if (gst != null) {
            return ResponseEntity.ok(gst);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
  //getting incometax records
    @GetMapping("/incometax/{companyid}")
    public ResponseEntity<Optional<IncomeTax>> getIncomeTaxByCompanyName(@PathVariable Long companyid) {
        Optional<IncomeTax> incomeTax = companyService.getIncomeTaxByCompanyId(companyid);
        if (incomeTax != null) {
            return ResponseEntity.ok(incomeTax);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  //getting epf records
    @GetMapping("/epf/{companyid}")
    public ResponseEntity<Optional<EPF>> getEPFByCompanyName(@PathVariable Long companyid) {
        Optional<EPF> epf = companyService.getEPFByCompanyId(companyid);
        if (epf != null) {
            return ResponseEntity.ok(epf);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


