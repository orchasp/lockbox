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

import com.orchasp.app.induslockbox.entity.Director;
import com.orchasp.app.induslockbox.service.DirectorService;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/fetchall")
    public List<Director> getAllBanks() {
        return directorService.findAll();
    }

    @GetMapping("/fetchbyid/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        Optional<Director> Director = directorService.findById(id);
        return Director.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/company/{company_id}")//http://localhost:8080/api/banks/company/1
    public ResponseEntity<List<Director>> getDirectorByCompanyId(@PathVariable Long company_id) {
        List<Director> DirectorDetails = directorService.findByCompany_id(company_id);
        return ResponseEntity.ok(DirectorDetails);
    }

    @PostMapping("/save")
    public Director createBank(@RequestBody Director director,@RequestParam String createdBy) {
        return directorService.save(director,createdBy);
    }

    @PutMapping("/update/{id}")
    public Director updateDirector(@PathVariable Long id, @RequestBody Director directorDetails,@RequestParam String updatedBy) {
    	return directorService.updateDirector(id, directorDetails,updatedBy);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
    	directorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/activate/{id}")
    public void activateDirector(@PathVariable Long id) {
    	directorService.activateById(id);
    }
}