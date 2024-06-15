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

import com.orchasp.app.induslockbox.entity.Bank;
import com.orchasp.app.induslockbox.service.BankService;

@RestController
@RequestMapping("/api/banks")//http://localhost:8080/api/banks
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/fetchall")
    public List<Bank> getAllBanks() {
        return bankService.findAll();
    }

    @GetMapping("/fetchbyid/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable Long id) {
        Optional<Bank> bank = bankService.findById(id);
        return bank.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/company/{company_id}")//http://localhost:8080/api/banks/company/1
    public ResponseEntity<List<Bank>> getBankByCompanyId(@PathVariable Long company_id) {
        List<Bank> bankDetails = bankService.findByCompany_id(company_id);
        return ResponseEntity.ok(bankDetails);
    }

    @PostMapping("/save")
    public Bank createBank(@RequestBody Bank bank,@RequestParam String  createdBy) {
        return bankService.save(bank,createdBy);
    }

    @PutMapping("/update/{id}")
    public Bank updateBank(@PathVariable Long id, @RequestBody Bank updatedBank,@RequestParam String updatedBy) {
        return bankService.updateBank(id, updatedBank,updatedBy);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
        bankService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @PatchMapping("/activate/{id}")
    public void activateBank(@PathVariable Long id) {
        bankService.activateById(id);
    }
}