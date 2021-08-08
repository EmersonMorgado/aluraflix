package br.com.emersonmorgado.aluraflix.aluraflix.security.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Usuario;
import br.com.emersonmorgado.aluraflix.aluraflix.repository.UsuarioRepository;
import br.com.emersonmorgado.aluraflix.aluraflix.service.TokenService;

public class AuthenticationFilter extends OncePerRequestFilter{
	
	private TokenService tokenService;
	private UsuarioRepository usuarioRepository;
	
	public AuthenticationFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = getToken(request);
		boolean valid = tokenService.tokenEhValido(token);
		if(valid) {
			authenticationClient(token);
		}
		filterChain.doFilter(request, response);
	}

	private void authenticationClient(String token) {
		Long idUser = tokenService.getIdUsuario(token);
		Usuario usuario = usuarioRepository.findById(idUser).get();
		UsernamePasswordAuthenticationToken authentication =  new UsernamePasswordAuthenticationToken(usuario, null, null);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String getToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7, token.length());
	}
}
