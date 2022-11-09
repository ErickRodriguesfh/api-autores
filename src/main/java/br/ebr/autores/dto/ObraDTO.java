package br.ebr.autores.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ebr.autores.model.Autor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ObraDTO {
	
	
	private Long id;
	
	@NotNull
	private String nome;

	@NotNull
	@Size(max = 240)
	private String descricao;
	
	
	private LocalDate dataPublicacao;
	
	private LocalDate dataExposicao;


	private  List<Autor> autores;
	
	
	
	

}
