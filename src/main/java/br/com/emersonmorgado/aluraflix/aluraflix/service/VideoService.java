package br.com.emersonmorgado.aluraflix.aluraflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.VideoDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AtualizaVideoForm;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.VideoForm;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;
import br.com.emersonmorgado.aluraflix.aluraflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;
	
	public List<VideoDto> getVideos() {
		List<Video> videos = videoRepository.findAll();
		ArrayList<VideoDto> listaVideosDto = new ArrayList<VideoDto>();
		videos.forEach(video->{
			VideoDto videoDto = new VideoDto(video);
			listaVideosDto.add(videoDto);
		});
		return listaVideosDto;
	}

	public Optional<Video> findById(Long id) {
		return videoRepository.findById(id);
	}

	public VideoDto cadastrar(VideoForm form) {
		Video video = form.getVideo();
		VideoDto videoDto = new VideoDto(videoRepository.save(video));
		return videoDto;
	}

	public void remove(Video video) {
		videoRepository.delete(video);		
	}

	public VideoDto atualiza(Video video, AtualizaVideoForm form) {
		Video videoAtualizado = form.atualiza(video);
		VideoDto videoDto =new VideoDto(videoRepository.save(videoAtualizado));
		return videoDto;
		
	}

}
