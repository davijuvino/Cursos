package com.devdojo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import java.util.Base64;
import java.util.Collection;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private String secretKey = "webfirewood";

    // Tempo de validade do token 30 minutos
    private long tokenValidTime = 30 * 60 * 1000L;
    
    private final UserDetailsService userDetailsService;

    // Inicializa o objeto, codifica a secretKey como Base64.
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    //Cria o token JWT
    public String createToken(String userPk, Collection<? extends GrantedAuthority> authorities) {
        Claims claims = Jwts.claims().setSubject(userPk); // Armazena informação payload JWT
        claims.put("authorities", authorities); // As informações são armazenadas como chave/valor.
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims) // Salva as informações
                .setIssuedAt(now) // Informações tempo de criação do token
                .setExpiration(new Date(now.getTime() + tokenValidTime)) // set Expire Time
                .signWith(SignatureAlgorithm.HS256, secretKey)  // Algoritmo de criptografia e configuração do valor secret na signature 
                .compact();
    }

    // JWT Recupera as informações do token
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // Extrair informações do corpo do token
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // Obtenha o valor do token do cabeçalho da solicitação. "X-AUTH-TOKEN": "valor TOKEN"
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

    // Verifique a validade do token + data de validade
    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

}
