package br.ebr.autores.entidade;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "obra")
public class Obra {
	

		@Id
		@GeneratedValue(generator = "sq_obra")
		private Long id;
	

		private String nome;

		
		private String descricao;
		
		@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
		private LocalDate dataPublicacao;
		
		@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
		private LocalDate dataExposicao;

		@JsonIgnore
		@ManyToMany
		private  List<Autor> autores;
	

}
