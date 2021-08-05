package br.com.emersonmorgado.aluraflix.aluraflix.controller.dto;

import org.springframework.data.domain.Page;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;

public class VideoSemCategoriaDto {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String url;
	
	public VideoSemCategoriaDto(Video video) {
			id = video.getIdVideo();
			titulo = video.getTitulo();
			descricao = video.getDescricao();
			url = video.getUrl();
	}

	public Long getId() {
		return id;
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

	public static Page<VideoSemCategoriaDto> converter(Page<Video> videos) {
		return videos.map(VideoSemCategoriaDto::new);
	}

}
