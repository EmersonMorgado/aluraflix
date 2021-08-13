package br.com.emersonmorgado.aluraflix.aluraflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AutenticacaoController {
	
	@GetMapping
	public ResponseEntity<Object> autenticador(){
		
		String page = "<html><body>" +
				"<h1>AluraFlix</h1>" +
				"<p>API Rest desenvolvida em Java com Spring Framework. </br> Documentção disponível em "+
				"<a href=\"https://documenter.getpostman.com/view/6125281/TzsZrTiX\">aluraFlix_API</a></p>"+
				"<p>git: https://github.com/EmersonMorgado/aluraflix</p>"+ 
				"</body></html>";
		
		return ResponseEntity.ok(page);
		}
}
