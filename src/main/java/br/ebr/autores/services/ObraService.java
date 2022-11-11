package br.ebr.autores.services;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import br.ebr.autores.dto.ObraDTO;
import br.ebr.autores.entidade.Autor;
import br.ebr.autores.entidade.Obra;
import br.ebr.autores.exceptions.PSQLException;
import br.ebr.autores.repositories.ObraRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObraService {

	private final ObraRepository obraRepository;
	
	private final AutorService autorService;

	private final ModelMapper mapper;

	public Obra cadastrarObra(ObraDTO obraDTO) {
		Obra obra = new Obra();	
		List<Autor> autores = obraDTO.getAutores().stream()
				.map(x -> autorService.buscarPeloId(x.getId())).collect(Collectors.toList());
		
		BeanUtils.copyProperties(obraDTO, obra);
		obra.setAutores(autores);
	
		validarDatas(obraDTO);
		return obraRepository.save(obra);
		
	}
	
	public List<ObraDTO> listarObras(){
		
		return obraRepository.findAll().stream().map(x -> mapper.map(x, ObraDTO.class)).collect(Collectors.toList());
		
	}
	
	
	public void validarDatas(ObraDTO obraDTO) {
		
		if (obraDTO.getDataExposicao() == null && obraDTO.getDataPublicacao() == null) {
			throw new PSQLException("Data de publicação e exposição não podem ser nulas");
		}
	}
	
	

	
	
	
	

}
