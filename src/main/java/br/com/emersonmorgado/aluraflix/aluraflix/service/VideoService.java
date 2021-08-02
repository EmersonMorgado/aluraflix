package br.com.emersonmorgado.aluraflix.aluraflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.VideoDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AtualizaVideoForm;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.VideoForm;
import br.com.emersonmorgado.aluraflix.aluraflix.dao.VideoDao;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;

@Service
public class VideoService {

	@Autowired
	private VideoDao videoDao;
		
	public List<VideoDto> getVideos() {
		return ConverteVideosDto(videoDao.findAll());
	}

	public Optional<Video> findById(Long id) {
		return videoDao.findById(id);
	}

	public VideoDto cadastrar(VideoForm form, Categoria categoria) {
		Video video = form.getVideo(categoria);
		VideoDto videoDto = new VideoDto(videoDao.save(video));
		return videoDto;
	}

	public void remover(Video video) {
		videoDao.delete(video);		
	}

	public VideoDto atualizar(Video video, AtualizaVideoForm form) {
		Video videoAtualizado = form.atualiza(video);
		VideoDto videoDto =new VideoDto(videoDao.save(videoAtualizado));
		return videoDto;
	}

	public Categoria findByCategoria(Categoria categoria) {
		List<Video> videos = videoDao.findByCategoria(categoria);
		categoria.setVideos(videos);
		return categoria;
	}

	public List<VideoDto> buscaPorTitulo(String titulo) {
		return ConverteVideosDto(videoDao.buscaPorTitulo(titulo));
	}
	private ArrayList<VideoDto> ConverteVideosDto(List<Video> videos) {
		ArrayList<VideoDto> listaVideosDto = new ArrayList<VideoDto>();
		videos.forEach(video->{
			VideoDto videoDto = new VideoDto(video);
			listaVideosDto.add(videoDto);
		});
		return listaVideosDto;
	}
}
