package br.com.emersonmorgado.aluraflix.aluraflix.controller.dto;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;

public class CategoriaDto {
	
	private Long id;
	private String titulo;
	private String cor;
	
	public CategoriaDto() {
	}

	public CategoriaDto(Categoria categoria) {
		id = categoria.getId();
		titulo = categoria.getTitulo();
		cor = categoria.getCor();
	}

	public CategoriaDto(long id, String titulo, String cor) {
		this.id = id;
		this.titulo = titulo;
		this.cor = cor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
