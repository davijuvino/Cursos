package com.devdojo.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devdojo.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return Optional.ofNullable(userRepository.findByEmail(username))
				.orElseThrow(() -> new UsernameNotFoundException("Email user not found"));
	}

}


//https://gaemi606.tistory.com/entry/Spring-Boot-Spring-Security-%ED%95%9C-%EC%9C%A0%EC%A0%80%EC%97%90%EA%B2%8C-%EC%97%AC%EB%9F%AC-AuthorityROLE-%EB%B6%80%EC%97%AC%ED%95%98%EA%B8%B0-UserDetails