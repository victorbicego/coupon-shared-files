package com.coupon.shared_files.controllers;

import com.coupon.shared_files.exceptions.*;
import jakarta.validation.ValidationException;
import java.net.URI;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(
      Exception ex,
      @Nullable Object body,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    if (body == null || isDefaultProblemDetail(body)) {
      body = createBodyFromException(ex);
    }
    return super.handleExceptionInternal(ex, body, headers, status, request);
  }

  @ExceptionHandler({
    ValidationException.class,
    ExpiredConfirmationException.class,
    InvalidConfirmationException.class,
    SendEmailException.class,
    UploadFileException.class
  })
  public ResponseEntity<Object> handleBadRequestExceptions(Exception ex, WebRequest request) {
    return buildResponseEntity(ex, HttpStatus.BAD_REQUEST, request);
  }

  @ExceptionHandler(InvalidJwtTokenException.class)
  public ResponseEntity<Object> handleInvalidJwtTokenException(
      InvalidJwtTokenException ex, WebRequest request) {
    return buildResponseEntity(ex, HttpStatus.UNAUTHORIZED, request);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
    return buildResponseEntity(ex, HttpStatus.NOT_FOUND, request);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) {
    return buildResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  private boolean isDefaultProblemDetail(Object body) {
    return body instanceof ProblemDetail detail
        && detail.getType().equals(URI.create("about:blank"));
  }

  private Map<String, Object> createBodyFromException(Exception ex) {
    String message = ex.getMessage() != null ? ex.getMessage() : "";
    return Map.of("type", ex.getClass(), "message", message);
  }

  private ResponseEntity<Object> buildResponseEntity(
      Exception ex, HttpStatus status, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();
    return handleExceptionInternal(ex, null, headers, status, request);
  }
}
