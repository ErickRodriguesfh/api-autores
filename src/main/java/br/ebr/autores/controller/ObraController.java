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

import br.ebr.autores.dto.ObraDTO;
import br.ebr.autores.services.ObraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/obra")
@RequiredArgsConstructor
public class ObraController {

		private final ObraService obraService;
	
		@PostMapping
		public ResponseEntity<ObraDTO> cadastrarObra(@RequestBody ObraDTO obraDTO){
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
					.buildAndExpand(obraService.cadastrarObra(obraDTO).getId()).toUri();
			
			return ResponseEntity.created(uri).build();
			
		}
		
		@GetMapping
		public ResponseEntity<List<ObraDTO>> listarObras(){
			return ResponseEntity.ok().body(obraService.listarObras());
		}
	
	
	
}
