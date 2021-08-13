package br.com.emersonmorgado.aluraflix.aluraflix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.CategoriaDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.CategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.repository.CategoriaRepository;

class CategoriaServiceTest {
	
	private CategoriaService categoriaService;
	
	@Mock
	private CategoriaRepository categoriaRepository;
	
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.openMocks(this);
		this.categoriaService = new CategoriaService(categoriaRepository);
	}
	
	@Test
	void testFindById() {
		Long categoriaId = 4L;
		categoriaService.findById(categoriaId);
		Mockito.verify(categoriaRepository).findById(categoriaId);
	}
	
	@Test
	void testCategoriaDto() {
		CategoriaForm form =  new CategoriaForm("Humor","azul");
		Categoria categoria = form.getCategoria();
		CategoriaDto categoria2 = new CategoriaDto(categoria);
		assertEquals(categoria2.getCor(), form.getCor());
		
	}
}
