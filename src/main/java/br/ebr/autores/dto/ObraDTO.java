package br.ebr.autores.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ebr.autores.entidade.Autor;
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


	@NotBlank(message = "O  Campo descrição não pode ser nulo")
	@Size(max = 240)
	private String descricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataPublicacao;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataExposicao;

	private  List<AutorDTO> autores;
	
	
	
	

}
