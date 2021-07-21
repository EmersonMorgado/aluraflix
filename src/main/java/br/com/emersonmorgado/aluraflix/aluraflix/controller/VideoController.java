package br.com.emersonmorgado.aluraflix.aluraflix.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.VideoDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AtualizaVideoForm;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.VideoForm;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;
import br.com.emersonmorgado.aluraflix.aluraflix.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {
	
	@Autowired
	private VideoService videoService;

	@GetMapping
	public ResponseEntity<List<VideoDto>> listarTodos() {
		List<VideoDto> videos = videoService.getVideos();
		return ResponseEntity.ok().body(videos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VideoDto> buscarPorId(@PathVariable Long id){
		Optional<Video> video = videoService.findById(Long.valueOf(id));
		if(video.isPresent()) {
			return ResponseEntity.ok(new VideoDto(video.get()));
		}		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<VideoDto> cadatrar(@RequestBody @Valid VideoForm form, UriComponentsBuilder uriBuilder){
		VideoDto videoDto = videoService.cadastrar(form);
		URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(videoDto.getId()).toUri();
		return ResponseEntity.created(uri).body(videoDto);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<VideoDto> remover(@PathVariable Long id){
		Optional<Video> video = videoService.findById(id);
		if(video.isPresent()) {
			videoService.remove(video.get());
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VideoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaVideoForm form){
		Optional<Video> video = videoService.findById(id);
		if(video.isPresent()) {
			VideoDto videoDto = videoService.atualiza(video.get(), form);
			return ResponseEntity.ok(videoDto);
		}		
		return ResponseEntity.notFound().build();
	}
}
