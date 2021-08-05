package br.com.emersonmorgado.aluraflix.aluraflix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.CategoriaDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AtualizaCategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.CategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.repository.CategoriaRepository;

@Service
public class CategoriaService {

	
	private CategoriaRepository categoriaRepository;

	@Autowired
	public CategoriaService(CategoriaRepository categoriaDao) {
		this.categoriaRepository = categoriaDao;
	}

	public Page<CategoriaDto> getCategoriasDto(Pageable paginacao) {
		Page<Categoria> Categorias = categoriaRepository.findAll(paginacao);
		return CategoriaDto.converter(Categorias);
	}

	public Optional<Categoria> findById(Long categoriaId) {
		return categoriaRepository.findById(categoriaId);
	}

	public CategoriaDto cadastrar(CategoriaForm form) {
		Categoria categoria = form.getCategoria();
		Categoria save = categoriaRepository.save(categoria);
		CategoriaDto categoriaDto = new CategoriaDto(save);
		return categoriaDto;
	}

	public void remove(Categoria categoria) {
		categoriaRepository.delete(categoria);
	}

	public CategoriaDto atualizar(Categoria categoria, AtualizaCategoriaForm form) {
		Categoria categoriaAtualizada = form.atualizar(categoria);
		CategoriaDto categoriaDto = new CategoriaDto(categoriaRepository.save(categoriaAtualizada));
		return categoriaDto;	
	}
}
