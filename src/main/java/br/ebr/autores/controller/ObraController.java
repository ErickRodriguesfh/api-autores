package br.ebr.autores.controller;


import br.ebr.autores.dto.ObraDTO;
import br.ebr.autores.services.ObraService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/obra")
@RequiredArgsConstructor
public class ObraController {

	private final ObraService obraService;
	
	private final ModelMapper mapper;

	@PostMapping
	public ResponseEntity<ObraDTO> cadastrarObra(@RequestBody @Valid ObraDTO obraDTO) {

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(obraService.cadastrarObra(obraDTO).getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@GetMapping
	public ResponseEntity<List<ObraDTO>> listarObras() {
		return ResponseEntity.ok().body(obraService.listarObras());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirObra(@PathVariable Long id) {
		obraService.excluirObra(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<ObraDTO> atualizarAutor(@RequestBody ObraDTO obraDTO) {
		return ResponseEntity.ok().body(mapper.map(obraService.atualizarObra(obraDTO), ObraDTO.class));
	}

}
