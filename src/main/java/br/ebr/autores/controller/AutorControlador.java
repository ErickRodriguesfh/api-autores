package br.ebr.autores.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ebr.autores.dto.AutorDTO;
import br.ebr.autores.services.AutorServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/autor")
@RequiredArgsConstructor
public class AutorControlador {

	
	private final AutorServico autorServico;
	
	@PostMapping
	public ResponseEntity<AutorDTO> cadastrarAutor(@RequestBody AutorDTO autorDTO){
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(autorServico.cadastrarAutor(autorDTO)).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	
	
	
	
	
	
}
