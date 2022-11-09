package br.ebr.autores.dto;

import java.time.LocalDate;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import br.ebr.autores.model.Obra;
import br.ebr.autores.model.Pais;
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
	private LocalDate dataNascimento;
	
	@NotNull
	private Pais pais;
	
	
	private List<Obra> obras ;

	@NotNull
	private String cpf;
	
	
	
}
