package br.ebr.autores.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StandardError {

	
		private LocalDateTime timestamp;
		private Integer status;
		private String error;
		private String path;
		
		
		
	
	
}
