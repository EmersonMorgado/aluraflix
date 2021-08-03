package br.com.emersonmorgado.aluraflix.aluraflix.controller.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;

class VideosPorCategoriaDtoTest {

	@Test
	void TestaPreenchimentoCorretoVideoSemCategoriaDto() {

		Video video1 = new Video(1L, "Titulo do Video1", "Descrição do Video1", "http://urldovideo1.com.br", null);
		Video video2 = new Video(1L, "Titulo do Video2", "Descrição do Video2", "http://urldovideo2.com.br", null);
		Video video3 = new Video(1L, "Titulo do Video3", "Descrição do Video3", "http://urldovideo3.com.br", null);

		ArrayList<Video> videos = new ArrayList<Video>();
		videos.add(video1);
		videos.add(video2);
		videos.add(video3);
		Categoria categoria = new Categoria(4L,"LIVRE", "BRANCA", videos);
		
		VideosPorCategoriaDto videoPorCategoriaDto = new VideosPorCategoriaDto(categoria);
		
		assertEquals(videoPorCategoriaDto.getVideos().size(), 3);
		assertEquals(videoPorCategoriaDto.getCor(), categoria.getCor());
		assertEquals(videoPorCategoriaDto.getId(), categoria.getIdCategoria());
		assertEquals(videoPorCategoriaDto.getTitulo(), categoria.getTitulo());
		assertEquals(videoPorCategoriaDto.getVideos().get(0).getTitulo(), video1.getTitulo());		
	}

}
