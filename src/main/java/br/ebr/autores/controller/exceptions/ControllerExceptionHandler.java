package br.ebr.autores.controller.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.ebr.autores.exceptions.ObjectNotFoundException;
import br.ebr.autores.exceptions.PSQLException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError>objectNotFound(ObjectNotFoundException ex, HttpServletRequest request){

        StandardError standardError = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .error(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<StandardError>cpfJaCadastrado(PSQLException ex, HttpServletRequest request){

        StandardError standardError = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .error(ex.getMessage())
                .status(HttpStatus.OK.value())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(standardError);
    }
}