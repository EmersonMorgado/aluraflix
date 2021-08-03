package br.com.emersonmorgado.aluraflix.aluraflix.controller.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;

class VideoDtoTest {

	@Test
	void TestaPreenchimentoCorretoVideoDto() {
		
		Categoria categoria = new Categoria(4L,"LIVRE", "BRANCA", null);
		Video video = new Video(1L, "Titulo do Video", "Descrição do Video", "http://urldovideo.com.br", categoria);
		VideoDto videoDto = new VideoDto(video);
		
		assertEquals(videoDto.getCategoriaId(), "4");
		assertEquals(videoDto.getDescricao(), video.getDescricao());
		assertEquals(videoDto.getId(), video.getIdVideo());
		assertEquals(videoDto.getTitulo(), video.getTitulo());
		assertEquals(videoDto.getUrl(), video.getUrl());
		
	}

}
