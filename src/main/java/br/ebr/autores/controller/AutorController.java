package br.ebr.autores.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ebr.autores.dto.AutorDTO;
import br.ebr.autores.services.AutorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/autor")
@RequiredArgsConstructor
public class AutorController {

	private final AutorService autorService;
	
	private final ModelMapper mapper;

	@PostMapping
	public ResponseEntity<AutorDTO> cadastrarAutor(@RequestBody @Valid AutorDTO autorDTO) {

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(autorService.cadastrarAutor(autorDTO).getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<AutorDTO>> listarAutores() {
		return ResponseEntity.ok().body(autorService.listarAutores());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirAutor(@PathVariable Long id) {
		autorService.excluirAutor(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<AutorDTO> atualizarAutor(@RequestBody AutorDTO autorDTO){
		return ResponseEntity.ok().body(mapper.map(autorService.atualizarAutor(autorDTO), AutorDTO.class));
	}
	
	

}
