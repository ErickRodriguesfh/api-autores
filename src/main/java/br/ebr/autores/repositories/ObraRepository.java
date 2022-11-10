package br.ebr.autores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ebr.autores.entidade.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long> {

}
