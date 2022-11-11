package br.ebr.autores.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
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

		verificarCpfExistente(autorDTO);
		verficaEmailExistente(autorDTO);

		BeanUtils.copyProperties(autorDTO, autor);
		autor.setPais(paisService.validarPais(autor.getPais().getSigla()));

		return autorRepository.save(autor);

	}

	
	public List<AutorDTO> listarAutores(){
		
		return autorRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeCompleto")).stream().
				map(x -> mapper.map(x, AutorDTO.class)).collect(Collectors.toList());
		
	}
	
	public Autor buscarPeloId(Long id) {
		return autorRepository.findById(id).get();
	}
	
	
	public void verificarCpfExistente(AutorDTO autorDTO) {

		Optional<Autor> autor = autorRepository.findByCpf(autorDTO.getCpf());

		if (autor.isPresent() && !autor.get().getId().equals(autorDTO.getId())) {
			throw new PSQLException("CPF Já cadastrado no sistema");
		}

	}

	public void verficaEmailExistente(AutorDTO autorDTO) {

		Optional<Autor> autor = autorRepository.findByEmail(autorDTO.getEmail());

		if (autor.isPresent() && !autor.get().getId().equals(autorDTO.getId())) {
			throw new PSQLException("Email já cadastrado no sistema");
		}
	}

}
