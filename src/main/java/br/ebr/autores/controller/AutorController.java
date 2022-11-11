package br.ebr.autores.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping
	public ResponseEntity<AutorDTO> cadastrarAutor(@RequestBody AutorDTO autorDTO){
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(autorService.cadastrarAutor(autorDTO).getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<AutorDTO>> listarAutores(){
		return ResponseEntity.ok().body(autorService.listarAutores());
	}
	
	
	
	
	
	
	
	
}
