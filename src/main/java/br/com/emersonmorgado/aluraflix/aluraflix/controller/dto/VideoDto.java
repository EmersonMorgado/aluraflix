package br.com.emersonmorgado.aluraflix.aluraflix.controller.dto;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;

public class VideoDto {
	
	private Long id;
	private String categoriaId;
	private String titulo;
	private String descricao;
	private String url;
	
	public VideoDto(Video video) {
			id = video.getIdVideo();
			titulo = video.getTitulo();
			descricao = video.getDescricao();
			url = video.getUrl();
			categoriaId= video.getCategoria().getIdCategoria().toString();
	}

	public Long getId() {
		return id;
	}

	public String getCategoriaId() {
		return categoriaId;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getUrl() {
		return url;
	}
}
