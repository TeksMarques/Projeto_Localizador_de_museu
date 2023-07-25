package com.betrybe.museumfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global Exception Handler for Museum API.
 */

@ControllerAdvice
public class ControllerHandleError {

  /**
   * Handles the exception when a Museum is not found.
   *
   * @param exception The MuseumNotFoundException that occurred.
   * @return ResponseEntity with HttpStatus NOT_FOUND (404) and an error message.
   */

  @ExceptionHandler(MuseumNotFoundException.class)
  public ResponseEntity<String> handleMuseumNotFoundException(MuseumNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Museu não encontrado!");
  }

  /**
   * Handles the exception when an invalid Coordinate is provided.
   *
   * @param exception The InvalidCoordinateException that occurred.
   * @return ResponseEntity with HttpStatus BAD_REQUEST (400) and an error message.
   */

  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handleInvalidCoordinateException(
      InvalidCoordinateException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenada inválida!");
  }

  /**
   * Another handle errors.
   */

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleThrowable(Throwable exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno!");
  }
}
