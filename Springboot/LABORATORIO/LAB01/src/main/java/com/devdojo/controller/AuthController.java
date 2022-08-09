package com.devdojo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdojo.config.JwtTokenProvider;
import com.devdojo.model.entity.User;
import com.devdojo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth/users")
@RequiredArgsConstructor
public class AuthController {

	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	private final JwtTokenProvider jwtTokenProvider;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
//		List<User> list = new ArrayList<User>();
//		userRepository.findAll().forEach(list::add);
//		return new ResponseEntity<List<User>>(list ,HttpStatus.OK);
		return ResponseEntity.ok(userRepository.findAll());
	}

	@PostMapping(path = "/registrar")
	public ResponseEntity<User> salve(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return ResponseEntity.ok(userRepository.save(user));

	}

	@PostMapping(path = "/login")
	public String login(@RequestBody User user) {
		 User login = Optional.ofNullable(
				 userRepository.findByEmail(user.getEmail())
				 ).orElseThrow(() -> new IllegalArgumentException("Email invalido."));
		
		
		if (!encoder.matches(user.getPassword(), login.getPassword())) {
			throw new IllegalArgumentException("Senha inválida.");
		}
		return jwtTokenProvider.createToken(login.getUsername(), login.getAuthorities());
	}
}
