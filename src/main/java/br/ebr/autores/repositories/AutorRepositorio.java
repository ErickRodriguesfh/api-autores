package br.ebr.autores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ebr.autores.model.Autor;

public interface AutorRepositorio extends JpaRepository<Autor, Long>{
	

}
