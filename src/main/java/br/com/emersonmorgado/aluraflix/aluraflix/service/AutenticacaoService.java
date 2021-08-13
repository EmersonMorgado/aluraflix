package br.com.emersonmorgado.aluraflix.aluraflix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.TokenDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AuthForm;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Usuario;
import br.com.emersonmorgado.aluraflix.aluraflix.repository.UsuarioRepository;

@Service
@Profile({"prod", "dev"})
public class AutenticacaoService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = usuarioRepository.findByEmail(nome);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("Usuáio e senha inválidos");
	}
	
	public TokenDto autenticar(AuthForm authForm) throws Exception{
		UsernamePasswordAuthenticationToken dataAuth = authForm.converter();
		Authentication authenticate = authenticationManager.authenticate(dataAuth);
		String token = tokenService.getToken(authenticate);
		return new TokenDto(token);
	}

}
