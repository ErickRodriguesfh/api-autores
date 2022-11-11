package br.ebr.autores.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.ebr.autores.dto.PaisDTO;
import br.ebr.autores.entidade.Pais;
import br.ebr.autores.exceptions.ObjectNotFoundException;
import br.ebr.autores.repositories.PaisRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaisService {
	
	
		private final PaisRepository paisRepositorio;
		
		private final ModelMapper mapper;
		
		
		public PaisDTO buscarPaisPorSigla(String sigla){
			
		return	mapper.map(paisRepositorio.findBySigla(sigla), PaisDTO.class);
			
	    }
		
		public List<PaisDTO> listarPaises(){
			
			return paisRepositorio.findAll(Sort.by(Sort.Direction.ASC, "nome")).stream().map(x -> mapper.map(x, PaisDTO.class))
					.collect(Collectors.toList());
		}
	
		
		public Pais validarPais(String sigla) {
			
			Pais pais = paisRepositorio.findBySigla(sigla);
			
			if(pais == null) {
				throw new ObjectNotFoundException("Pais Inexistente");
			}
			
			return pais;

		}
		

}
