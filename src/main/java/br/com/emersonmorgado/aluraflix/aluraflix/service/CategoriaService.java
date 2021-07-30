package br.com.emersonmorgado.aluraflix.aluraflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.CategoriaDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AtualizaCategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.CategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<CategoriaDto> getCategoriasDto() {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		ArrayList<CategoriaDto> listaCategoriaDto = new ArrayList<CategoriaDto>();
		listaCategorias.forEach(categoria->{
			CategoriaDto categoriaDtoo = new CategoriaDto(categoria);
			listaCategoriaDto.add(categoriaDtoo);
		});
		return listaCategoriaDto;
	}

	public Optional<Categoria> findById(Long categoria) {
		return categoriaRepository.findById(categoria);
	}

	public CategoriaDto cadastrar(CategoriaForm form) {
		Categoria categoria = form.getCategoria();
		CategoriaDto categoriaDto = new CategoriaDto(categoriaRepository.save(categoria));
		return categoriaDto;
	}

	public void remove(Categoria categoria) {
		categoriaRepository.delete(categoria);
	}

	public CategoriaDto atualizar(Categoria categoria, AtualizaCategoriaForm form) {
		Categoria categoriaAtualizada = form.atualizar(categoria);
		CategoriaDto categoriaDto =new CategoriaDto(categoriaRepository.save(categoriaAtualizada));
		return categoriaDto;	
	}
	
}
