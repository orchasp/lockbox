
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

import com.orchasp.app.induslockbox.entity.IncomeTax;
import com.orchasp.app.induslockbox.service.IncomeTaxService;

@RestController
@RequestMapping("/api/incometax")
public class IncomeTaxController {

    @Autowired
    private IncomeTaxService IncomeTaxService;

    @GetMapping
    public List<IncomeTax> getAllBanks() {
        return IncomeTaxService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeTax> getIncomeTaxById(@PathVariable Long id) {
        Optional<IncomeTax> IncomeTax = IncomeTaxService.findById(id);
        return IncomeTax.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public IncomeTax createBank(@RequestBody IncomeTax IncomeTax) {
        return IncomeTaxService.save(IncomeTax);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncomeTax> updateIncomeTax(@PathVariable Long id, @RequestBody IncomeTax incomeTaxDetails) {
        try {
            IncomeTax updatedIncomeTax = IncomeTaxService.updateIncomeTax(id, incomeTaxDetails);
            return ResponseEntity.ok(updatedIncomeTax);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
    	IncomeTaxService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}