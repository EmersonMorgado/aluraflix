package br.com.emersonmorgado.aluraflix.aluraflix.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;


public interface VideoRepository extends JpaRepository<Video, Long> {
	
	Page<Video> findByCategoria(Categoria categoria, Pageable paginacao);
	
	@Query("select v from Video v where v.titulo like %:titulo%")
	Page<Video> buscaPorTitulo(String titulo, Pageable paginacao);
}
