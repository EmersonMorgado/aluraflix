package br.com.emersonmorgado.aluraflix.aluraflix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.VideoDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.VideoSemCategoriaDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AtualizaVideoForm;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.VideoForm;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;
import br.com.emersonmorgado.aluraflix.aluraflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;
		
	public Page<VideoDto> getVideos(Pageable paginacao) {
		return VideoDto.converter(videoRepository.findAll(paginacao));
	}

	public Optional<Video> findById(Long id) {
		return videoRepository.findById(id);
	}

	public VideoDto cadastrar(VideoForm form, Categoria categoria) {
		Video video = form.getVideo(categoria);
		VideoDto videoDto = new VideoDto(videoRepository.save(video));
		return videoDto;
	}

	public void remover(Video video) {
		videoRepository.delete(video);		
	}

	public VideoDto atualizar(Video video, AtualizaVideoForm form) {
		Video videoAtualizado = form.atualiza(video);
		VideoDto videoDto =new VideoDto(videoRepository.save(videoAtualizado));
		return videoDto;
	}

	public Page<VideoSemCategoriaDto> findByCategoria(Categoria categoria, Pageable paginacao) {
		Page<Video> videos = videoRepository.findByCategoria(categoria, paginacao);
		return VideoSemCategoriaDto.converter(videos);
	}

	public Page<VideoDto> buscaPorTitulo(String titulo, Pageable paginacao) {
		return VideoDto.converter(videoRepository.buscaPorTitulo(titulo, paginacao));
	}
}
