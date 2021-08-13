package br.com.emersonmorgado.aluraflix.aluraflix.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.CategoriaDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.VideoSemCategoriaDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AtualizaCategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.CategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.service.CategoriaService;
import br.com.emersonmorgado.aluraflix.aluraflix.service.VideoService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private VideoService videoService;
	
	@GetMapping
	public ResponseEntity<Page<CategoriaDto>> listarTodas(@PageableDefault(sort = "idCategoria", direction = Direction.ASC, page = 0, size = 5) Pageable paginacao) {
		Page<CategoriaDto> categoriasDto = categoriaService.getCategoriasDto(paginacao);
		return ResponseEntity.ok().body(categoriasDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> buscarPorId(@PathVariable Long id, @RequestParam(required = false) String video){
		Optional<Categoria> categoria = categoriaService.findById(Long.valueOf(id));
		if(categoria.isPresent()) {
			return ResponseEntity.ok(new CategoriaDto(categoria.get()));
		}		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}/videos")
	public ResponseEntity<Page<VideoSemCategoriaDto>> buscarVideosPorCategoria(@PathVariable Long id,
			@PageableDefault(sort = "idVideo", direction = Direction.ASC, page = 0, size = 5) Pageable paginacao){
		Optional<Categoria> categoria = categoriaService.findById(Long.valueOf(id));
		if(categoria.isPresent()) {
			Page<VideoSemCategoriaDto> videos = videoService.findByCategoria(categoria.get(), paginacao);
			return ResponseEntity.ok(videos);
		}		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriBuilder){
		CategoriaDto categoriaDto = categoriaService.cadastrar(form);
		URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoriaDto.getId()).toUri();
		return ResponseEntity.created(uri).body(categoriaDto);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> remover(@PathVariable Long id){
		if ( id < 3) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sem permissão para remover este registro");
		}
		Optional<Categoria> categoria = categoriaService.findById(Long.valueOf(id));
		if(categoria.isPresent()) {
			categoriaService.remove(categoria.get());
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaCategoriaForm form){
		if ( id < 5) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sem permissão para atualizar este registro");
		}
		Optional<Categoria> categoria = categoriaService.findById(id);
		if(categoria.isPresent()) {
			CategoriaDto categoriaDto = categoriaService.atualizar(categoria.get(), form);
			return ResponseEntity.ok(categoriaDto);
		}		
		return ResponseEntity.notFound().build();
	}
}
