package br.com.emersonmorgado.aluraflix.aluraflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;


public interface VideoRepository extends JpaRepository<Video, Long> {

}
