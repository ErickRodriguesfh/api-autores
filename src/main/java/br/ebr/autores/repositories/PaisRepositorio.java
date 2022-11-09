package br.ebr.autores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ebr.autores.model.Pais;

public interface PaisRepositorio extends JpaRepository<Pais, Long> {

}
