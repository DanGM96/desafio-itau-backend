package com.itau.desafio.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

  @ExceptionHandler(exception = MethodArgumentNotValidException.class)
  public ResponseEntity<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    // Log exception internally
    return ResponseEntity.unprocessableEntity().build();
  }

  @ExceptionHandler(exception = HttpMessageNotReadableException.class)
  public ResponseEntity<Void> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
    // Log exception internally
    return ResponseEntity.badRequest().build();
  }
}
