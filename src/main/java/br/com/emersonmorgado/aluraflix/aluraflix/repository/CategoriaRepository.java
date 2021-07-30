package br.com.emersonmorgado.aluraflix.aluraflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
