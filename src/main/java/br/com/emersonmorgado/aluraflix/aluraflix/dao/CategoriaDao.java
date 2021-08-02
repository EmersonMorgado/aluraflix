package br.com.emersonmorgado.aluraflix.aluraflix.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.repository.CategoriaRepository;

@Repository
public class CategoriaDao{
	
	private CategoriaRepository categoriaRepository;

	@Autowired
	public CategoriaDao(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Optional<Categoria> findById(Long categoriaId) {
		return categoriaRepository.findById(categoriaId);
	}

	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public void delete(Categoria categoria) {
		categoriaRepository.delete(categoria);
	}
	
	
}
