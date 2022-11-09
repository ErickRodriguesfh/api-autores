package br.ebr.autores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ebr.autores.model.Obra;

public interface ObraRepositorio extends JpaRepository<Obra, Long> {

}
