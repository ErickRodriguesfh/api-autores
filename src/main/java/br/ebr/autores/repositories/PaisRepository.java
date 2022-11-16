package br.ebr.autores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ebr.autores.entidade.Pais;


public interface PaisRepository extends JpaRepository<Pais, Long> {

	Pais findBySigla(String sigla);
			
}
