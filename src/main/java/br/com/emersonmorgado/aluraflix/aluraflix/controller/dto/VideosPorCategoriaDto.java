package br.com.emersonmorgado.aluraflix.aluraflix.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;

public class VideosPorCategoriaDto {
	
	private Long id;
	private String titulo;
	private String cor;
	private List<VideoSemCategoriaDto> videos;
	
	public VideosPorCategoriaDto(Categoria categoria) {
		this.id = categoria.getIdCategoria();
		this.titulo = categoria.getTitulo();
		this.cor = categoria.getCor();
		this.videos = ListaVideos(categoria.getVideos());
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

	public List<VideoSemCategoriaDto> getVideos() {
		return videos;
	}

	private List<VideoSemCategoriaDto> ListaVideos(List<Video> videos){
		ArrayList<VideoSemCategoriaDto> ListaVideoSemCategoriaDto = new ArrayList<VideoSemCategoriaDto>();
		videos.forEach(video ->{
			ListaVideoSemCategoriaDto.add(new VideoSemCategoriaDto(video));
		});
		return ListaVideoSemCategoriaDto;
	}
}
