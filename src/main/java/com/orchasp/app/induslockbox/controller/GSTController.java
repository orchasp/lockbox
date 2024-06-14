
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

import com.orchasp.app.induslockbox.entity.GST;
import com.orchasp.app.induslockbox.service.GSTService;

@RestController
@RequestMapping("/api/gst")
public class GSTController {

    @Autowired
    private GSTService GSTService;

    @GetMapping
    public List<GST> getAllBanks() {
        return GSTService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GST> getGSTById(@PathVariable Long id) {
        Optional<GST> GST = GSTService.findById(id);
        return GST.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping//http://localhost:8080/api/GSTs
    public GST createBank(@RequestBody GST GST) {
        return GSTService.save(GST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GST> updateGST(@PathVariable Long id, @RequestBody GST gstDetails) {
        try {
            GST updatedGST = GSTService.updateGST(id, gstDetails);
            return ResponseEntity.ok(updatedGST);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
    	GSTService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}