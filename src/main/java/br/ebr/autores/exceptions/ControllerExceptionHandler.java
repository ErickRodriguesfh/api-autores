package br.ebr.autores.exceptions;


import java.time.LocalDateTime;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError>objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request){

        StandardError standardError = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .error(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<StandardError>cpfJaCadastradoException(RegraNegocioException ex, HttpServletRequest request){

        StandardError standardError = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .error(ex.getMessage())
                .status(HttpStatus.OK.value())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(standardError);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    	return "Erro no campo " + ex.getBindingResult().getFieldError().getField() + 
    			" - Descrição: " + ex.getBindingResult().getFieldError().getDefaultMessage();
    }
   
    
    
    
    
    
    
    
    
    
}