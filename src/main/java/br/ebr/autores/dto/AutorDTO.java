package br.ebr.autores.dto;

import java.time.LocalDate;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

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
	
	@NotBlank(message = "O campo nome não pode ser vazio")
	private String nomeCompleto;
	
	@NotBlank(message = "O campo sexo não pode ser vazio")
	private String sexo;
	
	@Email
	private String email;
	
	@NotNull(message = "O campo data de nascimento não pode ser vazio")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataNascimento;
	
	
	private Pais pais;
	
	private List<Obra> obras ;

	@CPF
	private String cpf;
	
	
	
}
