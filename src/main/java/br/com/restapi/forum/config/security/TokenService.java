package br.com.restapi.forum.config.security;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.restapi.forum.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private Long expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authenticate) {
		
		Usuario userLogado = (Usuario) authenticate.getPrincipal();
		Date date = new Date();     
        Date expirationDate = new Date(date.getTime() + expiration);
		
		return Jwts.builder()
				.setIssuer("API Forum")
				.setSubject(userLogado.getId().toString())
				.setIssuedAt(date)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

}
