package br.com.emersonmorgado.aluraflix.aluraflix.controller.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;

class VideoSemCategoriaDtoTest {

	@Test
	void TestaPreenchimentoCorretoVideoSemCategoriaDto() {
		
		Categoria categoria = new Categoria(4L,"LIVRE", "BRANCA", null);
		Video video = new Video(1L, "Titulo do Video", "Descrição do Video", "http://urldovideo.com.br", categoria);
		VideoSemCategoriaDto videoSemCategoriaDto = new VideoSemCategoriaDto(video);
		
		assertEquals(videoSemCategoriaDto.getDescricao(), video.getDescricao());
		assertEquals(videoSemCategoriaDto.getId(), video.getIdVideo());
		assertEquals(videoSemCategoriaDto.getTitulo(), video.getTitulo());
		assertEquals(videoSemCategoriaDto.getUrl(), video.getUrl());
	}

}
