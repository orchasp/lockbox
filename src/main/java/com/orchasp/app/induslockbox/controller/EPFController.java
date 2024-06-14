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

import com.orchasp.app.induslockbox.entity.EPF;
import com.orchasp.app.induslockbox.service.EPFService;

@RestController
@RequestMapping("/api/epf")
public class EPFController {

    @Autowired
    private EPFService EPFService;

    @GetMapping
    public List<EPF> getAllEPFs() {
        return EPFService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EPF> getEPFById(@PathVariable Long id) {
        Optional<EPF> EPF = EPFService.findById(id);
        return EPF.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EPF createEPF(@RequestBody EPF EPF) {
        return EPFService.save(EPF);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EPF> updateEPF(@PathVariable Long id, @RequestBody EPF epfDetails) {
        try {
            EPF updatedEPF = EPFService.updateEPF(id, epfDetails);
            return ResponseEntity.ok(updatedEPF);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEPF(@PathVariable Long id) {
        EPFService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}