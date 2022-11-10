package br.ebr.autores.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ebr.autores.entidade.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

		Optional<Autor> findByCpf(String cpf);
		Optional<Autor> findByEmail(String email);
	
}
