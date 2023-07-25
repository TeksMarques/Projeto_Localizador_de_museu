package com.betrybe.museumfinder.exception;

/**
 * Invalid Coordinate Exception class.
 */

public class InvalidCoordinateException extends RuntimeException {

  public InvalidCoordinateException(String message) {
    super(message);
  }
}
