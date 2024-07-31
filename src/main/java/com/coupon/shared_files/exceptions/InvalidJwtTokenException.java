package com.coupon.shared_files.exceptions;

public class InvalidJwtTokenException extends Exception {

  public InvalidJwtTokenException(String message) {
    super(message);
  }
}
