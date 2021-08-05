package br.com.emersonmorgado.aluraflix.aluraflix.controller.dto;

import org.springframework.data.domain.Page;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;

public class CategoriaDto {
	
	private Long id;
	private String titulo;
	private String cor;
	
	public CategoriaDto() {
	}

	public CategoriaDto(Categoria categoria) {
		id = categoria.getIdCategoria();
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

	public String getTitulo() {
		return titulo;
	}

	public String getCor() {
		return cor;
	}

	public static Page<CategoriaDto> converter(Page<Categoria> categoria) {
		return categoria.map(CategoriaDto:: new);
		
	}

}
