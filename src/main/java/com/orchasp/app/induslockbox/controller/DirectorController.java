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

import com.orchasp.app.induslockbox.entity.Director;
import com.orchasp.app.induslockbox.service.DirectorService;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping
    public List<Director> getAllBanks() {
        return directorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        Optional<Director> Director = directorService.findById(id);
        return Director.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Director createBank(@RequestBody Director director) {
        return directorService.save(director);
    }

    @PutMapping("/update/{id}")
    public Director updateDirector(@PathVariable Long id, @RequestBody Director directorDetails) {
//        try {
//            Director updatedDirector = directorService.updateDirector(id, directorDetails);
//            return ResponseEntity.ok(updatedDirector);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
    	return directorService.updateDirector(id, directorDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
    	directorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}