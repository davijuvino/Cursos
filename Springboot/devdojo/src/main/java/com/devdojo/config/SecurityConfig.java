package com.devdojo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        // Criando um token com http false, para não perder a sessão do tokem no front
        //csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
        .authorizeHttpRequests((authz) -> authz
            .anyRequest()
            .authenticated())
            .httpBasic();
        return http.build();
    }
    
    
    @Bean
    public UserDetailsService userDetailsService5() {
      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
      manager.createUser(
          User.withUsername("admin")
              .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
              .password("admin")
              .roles("USER","ADMIN")
              .build());
      manager.createUser(
          User.withUsername("user")
              .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
              .password("user")
              .roles("USER")
              .build());
      return manager;
    }

}

