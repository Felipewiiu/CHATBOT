package com.project.chatbot.infrastructure.exeptionhandler;

import com.project.chatbot.application.exeptions.DuplicatePhoneException;
import com.project.chatbot.application.exeptions.NotFoundUserException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler { // Corrigido o typo no nome

    @ExceptionHandler(ValidationException.class)
    public Mono<ResponseEntity<StandardError>> validateError(ValidationException ex, ServerWebExchange exchange) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError();

        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError(ex.getMessage());
        error.setMessage("Validation error");
        error.setPath(exchange.getRequest().getPath().value());

        return Mono.just(ResponseEntity.status(status).body(error));
    }

    @ExceptionHandler(NullPointerException.class)
    public Mono<ResponseEntity<StandardError>> nullPointerException(NullPointerException ex, ServerWebExchange exchange) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError();

        error.setTimestamp(Instant.now());
        error.setStatus(httpStatus.value());
        error.setError(ex.getMessage());
        error.setMessage("Null pointer exception");
        error.setPath(exchange.getRequest().getPath().value());

        return Mono.just(ResponseEntity.status(httpStatus).body(error));
    }

    @ExceptionHandler(DuplicatePhoneException.class)
    public Mono<ResponseEntity<StandardError>> handleDuplicatePhoneException(DuplicatePhoneException ex, ServerWebExchange exchange) {

        HttpStatus httpStatus = HttpStatus.CONFLICT;
        StandardError error = new StandardError();

        error.setTimestamp(Instant.now());
        error.setStatus(httpStatus.value());
        error.setError("Duplicate key violation");
        error.setMessage(ex.getMessage());
        error.setPath(exchange.getRequest().getPath().value());

        return Mono.just(ResponseEntity.status(httpStatus).body(error));
    }

    @ExceptionHandler(NotFoundUserException.class)
    public Mono<ResponseEntity<StandardError>> handleNotFoundUserExeption(NotFoundUserException ex, ServerWebExchange exchange) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError();

        error.setTimestamp(Instant.now());
        error.setStatus(httpStatus.value());
        error.setError("User not Found");
        error.setMessage(ex.getMessage());
        error.setPath(exchange.getRequest().getPath().value());

        return Mono.just(ResponseEntity.status(httpStatus).body(error));

    }
}