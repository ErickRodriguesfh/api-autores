package br.ebr.autores.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ebr.autores.dto.PaisDTO;
import br.ebr.autores.services.PaisService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pais")
@RequiredArgsConstructor
public class PaisController {
	
	
		private final PaisService paisService;
		
		
		@GetMapping
		public ResponseEntity<List<PaisDTO>> listarPaises(){
		
			return ResponseEntity.ok().body(paisService.listarPaises());
			
		}
		
		@GetMapping("/{sigla}")
		public ResponseEntity<PaisDTO> buscarPorSigla(@PathVariable String sigla ){
			
			return ResponseEntity.ok().body(paisService.buscarPaisPorSigla(sigla));
		}
		
	

}
