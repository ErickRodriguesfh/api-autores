package br.ebr.autores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ebr.autores.entidade.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

		Autor findByCpf(String cpf);
	
}
