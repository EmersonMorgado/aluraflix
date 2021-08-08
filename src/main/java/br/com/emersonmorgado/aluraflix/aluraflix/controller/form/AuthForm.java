package br.com.emersonmorgado.aluraflix.aluraflix.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthForm {
	
	private final String emailMsg = "Não é um formato válido.";
	private final String notNullMsg = "Campo obrigatório, não deve estar em branco.";
	private final String senhaMsg = "Campo obrigatório, não deve estar em branco.";
	
	@NotNull(message = notNullMsg)
	@Email(message = emailMsg)
	private String email;
	
	@NotBlank(message = notNullMsg)
	@NotNull(message = senhaMsg)
	private String senha;
	
	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}
}
