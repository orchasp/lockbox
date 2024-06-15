package com.orchasp.app.induslockbox.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@GetMapping("/user/home")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> userTest() {
		return ResponseEntity.ok("user home");
	}

	@GetMapping("/admin/home")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> adminTest() {
		return ResponseEntity.ok("admin home");
	}
}
