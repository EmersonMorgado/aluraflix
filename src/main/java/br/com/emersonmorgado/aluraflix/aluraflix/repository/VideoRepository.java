package br.com.emersonmorgado.aluraflix.aluraflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;


public interface VideoRepository extends JpaRepository<Video, Long> {
	
	List<Video> findByCategoria(Categoria categoria);
	
	@Query("select v from Video v where v.titulo like %:titulo%")
	List<Video> buscaPorTitulo(String titulo);
}
