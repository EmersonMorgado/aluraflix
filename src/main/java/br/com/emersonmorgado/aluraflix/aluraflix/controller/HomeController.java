package br.com.emersonmorgado.aluraflix.aluraflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public ResponseEntity<Object> autenticador(){
		
		String page = "<html><body>" +
				"<h1>AluraFlix</h1>" +
				"<p>API Rest desenvolvida em Java com Spring Framework. </br> Documentção disponível em; </br> "+
				"Doc: <a href=\"https://documenter.getpostman.com/view/6125281/TzsZrTiX\">AluraFlix API Documentação</a></br>"+
				"Git: <a href=\"https://github.com/EmersonMorgado/aluraflix\">AluraFlix Source</a></p>"+ 
				"</body></html>";
		return ResponseEntity.ok(page);
		}
}