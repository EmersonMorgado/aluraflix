package br.com.emersonmorgado.aluraflix.aluraflix.controller.dto;

public class TokenDto {
	
	private String token;
	private String type = "Bearer";
	
	public TokenDto(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public String getType() {
		return type;
	}
}
