package com.bankservice.CustomerMicroservice.jwt;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.bankservice.CustomerMicroservice.security.CustomerDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class CustomerUtils implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6409160644869833764L;

	private final String secret="NcRfUjXn2r5u8x!A%D*G-KaPdSgVkYp3s6v9y$B?E(H+MbQeThWmZq4t7w!z%C*F";
	
	public String generatetoken(CustomerDetails detail) {
        Map<String, Object> claims = new HashMap<>();
        
        return Jwts.builder().setClaims(claims)
        		.setSubject(detail.getUsername())
        		.setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 60*60*5*1000))
        		.signWith(SignatureAlgorithm.HS512, secret)
        		.compact();
	}
	
	public Claims getclaim(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	public String getUsername(String token) {
		return getclaim(token).getSubject();
	}
	
}
