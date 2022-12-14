package br.ebr.autores.entidade;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@GeneratedValue(generator = "sq_autor")
	private Long id;
	
	@NotNull
	private String nomeCompleto;
	
	@NotNull
	private String sexo;
	
	@Column(unique = true)
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataNascimento;
	
	@OneToOne
	@JoinColumn(name = "fk_pais")
	private Pais pais;
	
	@JsonIgnore
	@ManyToMany
	private List<Obra> obras ;
	
	@Column(unique = true)
	private String cpf;
	
	
	
	
	
}
