package br.ebr.autores.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import br.ebr.autores.dto.AutorDTO;
import br.ebr.autores.model.Autor;
import br.ebr.autores.repositories.AutorRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorServico {

	private final AutorRepositorio autorRepositorio;
	
	private final ModelMapper mapper;
	
	
	public Autor cadastrarAutor(AutorDTO autorDTO) {
		return  autorRepositorio.save(mapper.map(autorDTO, Autor.class));
	}
	
	
	
	
}
