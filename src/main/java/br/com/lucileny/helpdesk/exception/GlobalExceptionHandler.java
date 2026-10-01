package br.com.lucileny.helpdesk.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)

    public ResponseEntity<String> tratarExecao(IllegalArgumentException mensage) {

        return ResponseEntity
                .badRequest()
                .body(mensage.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)

    public ResponseEntity<String> tratarChamadoNaoEncontrado(NoSuchElementException mensage) {

        return ResponseEntity
                .status(404)
                .body(mensage.getMessage());

    }
    @ExceptionHandler (MethodArgumentNotValidException.class)

    public ResponseEntity<String> tratarErroValidacao(MethodArgumentNotValidException exception){

        var erro = exception.getBindingResult().getFieldError();

        String mensagem;

        if (erro != null) {
            mensagem = erro.getDefaultMessage();
        } else {
            mensagem = "Erro de validação";
        }
        return ResponseEntity
                .badRequest()
                .body(mensagem);

    }
}