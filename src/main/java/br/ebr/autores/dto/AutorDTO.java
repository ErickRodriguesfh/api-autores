package br.ebr.autores.dto;

import java.time.LocalDate;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ebr.autores.entidade.Obra;
import br.ebr.autores.entidade.Pais;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AutorDTO {

	
	private Long id;
	
	@NotNull
	private String nomeCompleto;
	
	@NotNull
	private String sexo;
	
	@Email
	private String email;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataNascimento;
	
	
	private String sigla;
	
	private List<Obra> obras ;

	@NotNull
	private String cpf;
	
	
	
}
