package br.com.emersonmorgado.aluraflix.aluraflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.CategoriaDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AtualizaCategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.CategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.dao.CategoriaDao;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;

@Service
public class CategoriaService {

	
	private CategoriaDao categoriaDao;

	@Autowired
	public CategoriaService(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	public List<CategoriaDto> getCategoriasDto() {
		List<Categoria> listaCategorias = categoriaDao.findAll();
		ArrayList<CategoriaDto> listaCategoriaDto = new ArrayList<CategoriaDto>();
		listaCategorias.forEach(categoria->{
			CategoriaDto categoriaDtoo = new CategoriaDto(categoria);
			listaCategoriaDto.add(categoriaDtoo);
		});
		return listaCategoriaDto;
	}

	public Optional<Categoria> findById(Long categoriaId) {
		return categoriaDao.findById(categoriaId);
	}

	public CategoriaDto cadastrar(CategoriaForm form) {
		Categoria categoria = form.getCategoria();
		Categoria save = categoriaDao.save(categoria);
		CategoriaDto categoriaDto = new CategoriaDto(save);
		return categoriaDto;
	}

	public void remove(Categoria categoria) {
		categoriaDao.delete(categoria);
	}

	public CategoriaDto atualizar(Categoria categoria, AtualizaCategoriaForm form) {
		Categoria categoriaAtualizada = form.atualizar(categoria);
		CategoriaDto categoriaDto = new CategoriaDto(categoriaDao.save(categoriaAtualizada));
		return categoriaDto;	
	}
}
