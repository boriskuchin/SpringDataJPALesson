package ru.bvkuchin.springdatajpa_homework.SpringDataJPA.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public record JwtService() {
    private static final long EXPIRATION_TIME = 1000 * 60 * 10;
    private static final String SECRET = "akjsidba&inI#0wfjodscsdcnsldcjnsld";

    public String generateToken(UserDetails userDetails) {
        String username = userDetails.getUsername();
        List<String> authorities = userDetails.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority()).toList();

        Map<String, Object> claims = new HashMap<>(Map.of("authorities", authorities));

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();

    }

    public String getUserName(String tokenValue) {
        return parse(tokenValue).getSubject();
    }

    public List<? extends GrantedAuthority> getAuthorities(String tokenValue) {
        List<String> authorities = (List<String>) parse(tokenValue).get("authorities");
        return authorities.stream().map(s -> new SimpleGrantedAuthority(s)).toList();
    }

    private Claims parse(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

    }
}
