package br.com.emersonmorgado.aluraflix.aluraflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AuthForm;
import br.com.emersonmorgado.aluraflix.aluraflix.service.AutenticacaoService;

@Controller
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@PostMapping
	public ResponseEntity<Object> autenticador(@RequestBody @Validated AuthForm authForm){
		try {
			return ResponseEntity.ok(autenticacaoService.autenticar(authForm));
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuário e senha inválido");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Erro interno no servidor.");
		}
	}
}
