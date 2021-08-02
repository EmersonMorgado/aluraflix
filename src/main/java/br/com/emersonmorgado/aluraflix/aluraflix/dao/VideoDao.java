package br.com.emersonmorgado.aluraflix.aluraflix.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;
import br.com.emersonmorgado.aluraflix.aluraflix.repository.VideoRepository;

@Repository
public class VideoDao {
	
	private VideoRepository videoRepository;

	@Autowired
	public VideoDao(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	public List<Video> findAll() {
		return videoRepository.findAll();
	}

	public Optional<Video> findById(Long id) {
		return videoRepository.findById(id);
	}

	public Video save(Video video) {
		return videoRepository.save(video);
	}

	public void delete(Video video) {
		videoRepository.delete(video);		
	}

	public List<Video> findByCategoria(Categoria categoria) {
		return videoRepository.findByCategoria(categoria);
	}

	public List<Video> buscaPorTitulo(String titulo) {
		return videoRepository.buscaPorTitulo(titulo);
	}
	
}
