package br.com.emersonmorgado.aluraflix.aluraflix.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
	void testCadastrar() {
		CategoriaForm form =  new CategoriaForm("Humor","azul");
		Categoria categoria = form.getCategoria();
		Categoria categoria2 = new Categoria(1L,"Humor", "Azul",null);
		when(categoriaRepository.save(categoria)).thenReturn(categoria2);
		//CategoriaDto categoriaDto = categoriaService.cadastrar(form);
		//assertEquals(categoriaDto.getId(), categoria.getId());
		
	}

	private List<Categoria> categorias(){
		Categoria categoria1 = new Categoria(1L, "Humor", "Azul", null);
		Categoria categoria2 = new Categoria(2L, "Ação", "Verde", null);
		Categoria categoria3 = new Categoria(2L, "Aventura", "Laranja", null);
		return Arrays.asList(categoria1,categoria2, categoria3);	
	}
	
}
