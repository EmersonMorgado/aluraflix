package br.com.emersonmorgado.aluraflix.aluraflix.controller.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;

class CategoriaDtoTest {

	@Test
	void TestaPreenchimentoCorretoDoObjetoCategoriaDto() {
		
		Categoria categoria = new Categoria(1L, "LIVRE", "BRANCA", null);
		CategoriaDto categoriaDto = new CategoriaDto(categoria);
		
		assertEquals(categoriaDto.getId(),categoria.getIdCategoria());
		assertEquals(categoriaDto.getCor(),categoria.getCor());
		assertEquals(categoriaDto.getTitulo(),categoria.getTitulo());
		

		CategoriaDto categoriaDto1 = new CategoriaDto(1L,"LIVRE","BRANCA");
		
		assertEquals(categoriaDto1.getId(),1L);
		assertEquals(categoriaDto1.getTitulo(),"LIVRE");
		assertEquals(categoriaDto1.getCor(),"BRANCA");
	}
}