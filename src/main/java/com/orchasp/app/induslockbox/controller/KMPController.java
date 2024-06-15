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

import com.orchasp.app.induslockbox.entity.KMP;
import com.orchasp.app.induslockbox.service.KMPService;

@RestController
@RequestMapping("/api/KMPs")//http://localhost:8080/api/KMPs
public class KMPController {

    @Autowired
    private KMPService KMPService;

    @GetMapping("/fetchall")
    public List<KMP> getAllKMPs() {
        return KMPService.findAll();
    }

    @GetMapping("/fetchbyid/{id}")
    public ResponseEntity<KMP> getKMPById(@PathVariable Long id) {
        Optional<KMP> KMP = KMPService.findById(id);
        return KMP.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/company/{company_id}")//http://localhost:8080/api/KMPs/company/1
    public ResponseEntity<List<KMP>> getKMPByCompanyId(@PathVariable Long company_id) {
        List<KMP> KMPDetails = KMPService.findByCompany_id(company_id);
        return ResponseEntity.ok(KMPDetails);
    }

    @PostMapping("/save")
    public KMP createKMP(@RequestBody KMP KMP,@RequestParam String  user) {
        return KMPService.save(KMP,user);
    }

    @PutMapping("/update/{id}")
    public KMP updateKMP(@PathVariable Long id, @RequestBody KMP updatedKMP,@RequestParam String updatedBy) {
        return KMPService.updateKMP(id, updatedKMP,updatedBy);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKMP(@PathVariable Long id) {
        KMPService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @PatchMapping("/activate/{id}")
    public void activateKMP(@PathVariable Long id) {
        KMPService.activateById(id);
    }
}