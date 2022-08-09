package com.devdojo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Obtenha o JWT do cabeçalho.
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
        // Certifique-se de que é um token válido.
        if (token != null && jwtTokenProvider.validateToken(token)) {
            // Se o token for válido, as informações do usuário serão obtidas do token.
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            // Armazene o objeto Authentication em um SecurityContext .
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}