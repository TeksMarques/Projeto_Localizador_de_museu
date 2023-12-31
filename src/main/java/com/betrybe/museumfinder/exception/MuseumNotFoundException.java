package com.betrybe.museumfinder.exception;

/**
 * Museum not found exception.
 */

public class MuseumNotFoundException extends RuntimeException {

  public MuseumNotFoundException(String message) {
    super(message);
  }

  public MuseumNotFoundException() {
    super();
  }

}
