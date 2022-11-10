package br.ebr.autores.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.ebr.autores.dto.AutorDTO;
import br.ebr.autores.entidade.Autor;

import br.ebr.autores.exceptions.PSQLException;
import br.ebr.autores.repositories.AutorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorService {

	private final AutorRepository autorRepository;

	private final ModelMapper mapper;
	
	private final PaisService paisService;

	public Autor cadastrarAutor(AutorDTO autorDTO) {

		Autor autor = new Autor();
		BeanUtils.copyProperties(autorDTO, autor);
		autor.setPais(paisService.validarPais(autorDTO.getSigla()));
		return autorRepository.save(autor);
		
	}

	public String verificarCpfExistente(String cpf) {

		Autor autor = autorRepository.findByCpf(cpf);

		if (autor.getCpf() == null) {
			return autor.getCpf();
		}

		throw new PSQLException("CPF Já cadastrado no sistema");
	}

		
	
	
	
	
	
}
