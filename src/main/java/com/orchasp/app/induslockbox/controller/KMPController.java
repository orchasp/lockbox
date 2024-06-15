
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

import com.orchasp.app.induslockbox.entity.KMP;
import com.orchasp.app.induslockbox.service.KMPService;

@RestController
@RequestMapping("/api/KMP")
public class KMPController {

    @Autowired
    private KMPService KMPService;

    @GetMapping
    public List<KMP> getAllBanks() {
        return KMPService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KMP> getKMPById(@PathVariable Long id) {
        Optional<KMP> KMP = KMPService.findById(id);
        return KMP.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public KMP createBank(@RequestBody KMP KMP) {
        return KMPService.save(KMP);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KMP> updateKMP(@PathVariable Long id, @RequestBody KMP KMPDetails) {
        try {
            KMP updatedKMP = KMPService.updateKMP(id, KMPDetails);
            return ResponseEntity.ok(updatedKMP);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
    	KMPService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}