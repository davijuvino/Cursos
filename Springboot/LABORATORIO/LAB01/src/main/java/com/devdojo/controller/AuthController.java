package com.devdojo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdojo.model.entity.User;
import com.devdojo.repository.UserRepository;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth/users")
@RequiredArgsConstructor
public class AuthController {

	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok(userRepository.findAll());
	}
	
	
	@PostMapping(path = "/registrar")
	public ResponseEntity<User> salve(@RequestBody User user){
		user.setPassword(encoder.encode(user.getPassword()));
		return ResponseEntity.ok(userRepository.save(user));
		
	}
}
