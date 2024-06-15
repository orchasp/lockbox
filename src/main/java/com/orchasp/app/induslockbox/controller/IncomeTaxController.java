
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

import com.orchasp.app.induslockbox.entity.IncomeTax;
import com.orchasp.app.induslockbox.service.IncomeTaxService;

@RestController
@RequestMapping("/api/incometax")
public class IncomeTaxController {

    @Autowired
    private IncomeTaxService IncomeTaxService;

    @GetMapping("/fetchall")
    public List<IncomeTax> getAllBanks() {
        return IncomeTaxService.findAll();
    }

    @GetMapping("/fetchbyid/{id}")
    public ResponseEntity<IncomeTax> getIncomeTaxById(@PathVariable Long id) {
        Optional<IncomeTax> IncomeTax = IncomeTaxService.findById(id);
        return IncomeTax.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public IncomeTax createBank(@RequestBody IncomeTax IncomeTax,@RequestParam String createdBy) {
        return IncomeTaxService.save(IncomeTax,createdBy);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<IncomeTax> updateIncomeTax(@PathVariable Long id, @RequestBody IncomeTax incomeTaxDetails,@RequestParam String updatedBy) {
        try {
            IncomeTax updatedIncomeTax = IncomeTaxService.updateIncomeTax(id, incomeTaxDetails,updatedBy);
            return ResponseEntity.ok(updatedIncomeTax);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
    	IncomeTaxService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/activate/{id}")
    public void activateIncomeTax(@PathVariable Long id) {
    	IncomeTaxService.activateById(id);
    }
    
    @GetMapping("/company/{company_id}")//http://localhost:8080/api/incometax/company/1
    public ResponseEntity<List<IncomeTax>> getIncomeTaxByCompanyId(@PathVariable Long company_id) {
        List<IncomeTax> bankDetails = IncomeTaxService.findByCompany_id(company_id);
        return ResponseEntity.ok(bankDetails);
    }

}