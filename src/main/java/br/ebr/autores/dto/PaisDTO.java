package br.ebr.autores.dto;


import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaisDTO {

	
	private Long id;
	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "O campo sigla é obrigatório")
	private String sigla;

	
}
