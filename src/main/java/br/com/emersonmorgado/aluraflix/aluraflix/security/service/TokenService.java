package br.com.emersonmorgado.aluraflix.aluraflix.security.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.emersonmorgado.aluraflix.aluraflix.security.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${jwt.expiration}")
	private String expiracao;
	
	@Value("${jwt.secret}")
	private String palavraChave;
	
	public String getToken(Authentication authentication) {
		
		Usuario usuario = (Usuario) authentication.getPrincipal();
		
		Date hoje = new Date();
		Date dataExpiracao =  new Date(hoje.getTime() + Long.parseLong(expiracao));
		
		return Jwts.builder()
				.setIssuer("API WebService")
				.setSubject(usuario.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, palavraChave)
				.compact();
	}

	public boolean tokenEhValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.palavraChave).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
		return false;
		}
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.palavraChave).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}
