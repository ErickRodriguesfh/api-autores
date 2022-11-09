package br.ebr.autores.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tabela_obra")

public class Obra {
	

		private String nome;

		private String descricao;
		private LocalDate dataPublicacao;
		private LocalDate dataExposicao;
	
	
	

}
