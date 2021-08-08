package br.com.emersonmorgado.aluraflix.aluraflix.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.VideoDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AtualizaVideoForm;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.VideoForm;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Video;
import br.com.emersonmorgado.aluraflix.aluraflix.service.CategoriaService;
import br.com.emersonmorgado.aluraflix.aluraflix.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {
	
	@Autowired
	private VideoService videoService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<Page<VideoDto>> listarTodos(@RequestParam(required = false) String titulo,
									  @PageableDefault(sort = "idVideo", direction = Direction.ASC, page = 0, size = 5) Pageable paginacao) {
		if(titulo != null) {
			Page<VideoDto> videos = videoService.buscaPorTitulo(titulo, paginacao);
			return ResponseEntity.ok().body(videos);
		}
		return ResponseEntity.ok().body(videoService.getVideos(paginacao));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable Long id){
		Optional<Video> video = videoService.findById(Long.valueOf(id));
		if(video.isPresent()) {
			return ResponseEntity.ok(new VideoDto(video.get()));
		}		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Mensagem.VIDEO_NAO_ENCONTRADO.getDescricao());
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid VideoForm form, UriComponentsBuilder uriBuilder){
		Optional<Categoria> categoria = categoriaService.findById(Long.valueOf(form.getCategoriaId()));
		if(categoria.isPresent()) {
			VideoDto videoDto = videoService.cadastrar(form, categoria.get());
			URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(videoDto.getId()).toUri();
			return ResponseEntity.created(uri).body(videoDto);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Mensagem.CATEGORIA_NAO_ENCONTRADA.getDescricao());
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> remover(@PathVariable Long id){
		Optional<Video> video = videoService.findById(id);
		if(video.isPresent()) {
			videoService.remover(video.get());
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Mensagem.VIDEO_NAO_ENCONTRADO.getDescricao());
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaVideoForm form){
		Optional<Categoria> categoria = categoriaService.findById(Long.valueOf(form.getCategoriaId()));
		if(!categoria.isPresent()) { 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Mensagem.CATEGORIA_NAO_ENCONTRADA.getDescricao());
		}
		Optional<Video> videoObj = videoService.findById(id);
		if(videoObj.isPresent()) {
			Video video = videoObj.get();
			video.setCategoria(categoria.get());
			return ResponseEntity.ok(videoService.atualizar(video, form));
		}		
		return ResponseEntity.notFound().build();
	}
	@GetMapping("/free")
	public ResponseEntity<Page<VideoDto>> listarVideosFree() {
		
		PageRequest pageRequest = PageRequest.of(1, 2, Direction.ASC, "idVideo");
		return ResponseEntity.ok().body(videoService.getVideos(pageRequest));
	}
}
