package com.devdojo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.devdojo.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	
	private final JwtTokenProvider jwtTokenProvider;
	private final PasswordEncoder bCrypt;
	private final UserServiceImpl service;
	
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        // Criando um token com http false, para não perder a sessão do tokem no front
        //csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeHttpRequests((authz) -> authz
        	.anyRequest()
            .permitAll()
            .and()
            .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                    UsernamePasswordAuthenticationFilter.class))
            .httpBasic();
        return http.build();
    }
    
    
    @Autowired
	public void init(AuthenticationManagerBuilder auth)
			throws Exception {
    		auth.inMemoryAuthentication().withUser("admin").password(bCrypt.encode("admin")).roles("ADMIN");
    		auth.inMemoryAuthentication().withUser("user").password(bCrypt.encode("user")).roles("USER");
        
    		auth.userDetailsService(service).passwordEncoder(bCrypt);
	}
    
    

    
    
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) 
//      throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//        		.userDetailsService(service)
//        		.passwordEncoder(bCrypt)
//        		.and()
//        		.build();
//          
//    }
    
    
}

