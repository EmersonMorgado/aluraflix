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

import br.com.emersonmorgado.aluraflix.aluraflix.controller.dto.CategoriaDto;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.AtualizaCategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.controller.form.CategoriaForm;
import br.com.emersonmorgado.aluraflix.aluraflix.model.Categoria;
import br.com.emersonmorgado.aluraflix.aluraflix.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaDto>> listarTodas() {
		List<CategoriaDto> categoriasDto = categoriaService.getCategoriasDto();
		return ResponseEntity.ok().body(categoriasDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> buscarPorId(@PathVariable Long id){
		Optional<Categoria> categoria = categoriaService.findById(Long.valueOf(id));
		if(categoria.isPresent()) {
			return ResponseEntity.ok(new CategoriaDto(categoria.get()));
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
		Optional<Categoria> categoria = categoriaService.findById(Long.valueOf(id));
		if(categoria.isPresent()) {
			categoriaService.remove(categoria.get());
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CategoriaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaCategoriaForm form){
		Optional<Categoria> categoria = categoriaService.findById(id);
		if(categoria.isPresent()) {
			CategoriaDto categoriaDto = categoriaService.atualizar(categoria.get(), form);
			return ResponseEntity.ok(categoriaDto);
		}		
		return ResponseEntity.notFound().build();
	}
}
