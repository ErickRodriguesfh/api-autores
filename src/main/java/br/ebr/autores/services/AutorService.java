package br.ebr.autores.services;

import br.ebr.autores.dto.AutorDTO;
import br.ebr.autores.entidade.Autor;
import br.ebr.autores.entidade.Obra;
import br.ebr.autores.exceptions.ObjectNotFoundException;
import br.ebr.autores.exceptions.RegraNegocioException;
import br.ebr.autores.repositories.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutorService {

	private final AutorRepository autorRepository;

	private final ModelMapper mapper;

	private final PaisService paisService;

	public Autor cadastrarAutor(AutorDTO autorDTO) {
		Autor autor = new Autor();

		verificarCpfExistente(autorDTO);
		verficarEmailExistente(autorDTO);
		verificarPais(autorDTO);
		BeanUtils.copyProperties(autorDTO, autor);
		
		autor.setPais(paisService.validarPais(autor.getPais().getSigla()));

		return autorRepository.save(autor);
	}

	public List<AutorDTO> listarAutores() {

		return autorRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeCompleto")).stream()
				.map(x -> mapper.map(x, AutorDTO.class)).collect(Collectors.toList());
	}

	public Autor buscarPeloId(Long id) {
		return autorRepository.findById(id).get();
	}

	public void excluirAutor(Long id) {

		if (autorRepository.existsById(id)) {
			Autor autor = autorRepository.findById(id).get();

			verificarObrasAutor(autor);
			autorRepository.deleteById(autor.getId());
		} else {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}

	public Autor atualizarAutor(AutorDTO autorDTO) {
		return autorRepository.saveAndFlush(mapper.map(autorDTO, Autor.class));
		
	}


	public void verificarCpfExistente(AutorDTO autorDTO) {

		Optional<Autor> autor = autorRepository.findByCpf(autorDTO.getCpf());

		if (autor.isPresent() && !autor.get().getId().equals(autorDTO.getId())) {
			throw new RegraNegocioException("CPF Já cadastrado no sistema");
		}

	}

	public void verficarEmailExistente(AutorDTO autorDTO) {

		Optional<Autor> autor = autorRepository.findByEmail(autorDTO.getEmail());

		if (autor.isPresent() && !autor.get().getId().equals(autorDTO.getId())) {
			throw new RegraNegocioException("Email já cadastrado no sistema");
		}
	}

	public boolean verificarObrasAutor(Autor autor) {

		List<Obra> obras = autor.getObras();

		if (obras.isEmpty())
			return true;
		throw new RegraNegocioException("Não foi possível excluir o autor pois o mesmo possuí obras");
	}

	public void verificarPais(AutorDTO autorDTO) {
		if (autorDTO.getPais().getSigla() != "BR" && autorDTO.getCpf() != null) {
			throw new RegraNegocioException("O Campo CPF não é nescessário pois o autor não é brasileiro");
		}
	}

}