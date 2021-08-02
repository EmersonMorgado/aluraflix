package br.com.emersonmorgado.aluraflix.aluraflix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.CategoriaDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.CategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.dao.CategoriaDao;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;

class CategoriaServiceTest {
	
	private CategoriaService categoriaService;
	
	@Mock
	private CategoriaDao categoriaDao;
	
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.openMocks(this);
		this.categoriaService = new CategoriaService(categoriaDao);
	}
	
	@Test
	void testGetCategoriasDto() {
		List<Categoria> listaCategorias = categorias();
		Mockito.when(categoriaDao.findAll()).thenReturn(listaCategorias);
		
		List<CategoriaDto> categoriasDto = categoriaService.getCategoriasDto();

		assertEquals(categoriasDto.size(), listaCategorias.size());
		for(int i = 0 ; i == listaCategorias.size(); i++) {
			assertEquals(categoriasDto.get(i).getId(), listaCategorias.get(i).getIdCategoria());
			assertEquals(categoriasDto.get(i).getTitulo(), listaCategorias.get(i).getTitulo());
			assertEquals(categoriasDto.get(i).getCor(), listaCategorias.get(i).getCor());
		}
	}
	
	@Test
	void testFindById() {
		Long categoriaId = 4L;
		categoriaService.findById(categoriaId);
		Mockito.verify(categoriaDao).findById(categoriaId);
	}
	
	@Test
	void testCadastrar() {
		CategoriaForm form =  new CategoriaForm("Humor","azul");
		Categoria categoria = form.getCategoria();
		Categoria categoria2 = new Categoria(1L,"Humor", "Azul",null);
		when(categoriaDao.save(categoria)).thenReturn(categoria2);
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
