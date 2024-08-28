package cl.marceloaros.nisumexercise.infraestructure.controller.handler;

import cl.marceloaros.nisumexercise.application.exception.UserEmailDuplicatedException;
import cl.marceloaros.nisumexercise.application.exception.UserEmailIncorrectDomainException;
import cl.marceloaros.nisumexercise.application.exception.UserPasswordIncorrectException;
import cl.marceloaros.nisumexercise.infraestructure.exception.NotImplementedException;
import cl.marceloaros.nisumexercise.model.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerHandler {

  @ExceptionHandler(UserEmailIncorrectDomainException.class)
  public ResponseEntity<ApiErrorResponse> handleUserEmailIncorrectDomain(UserEmailIncorrectDomainException ex) {
    ApiErrorResponse response = new ApiErrorResponse().mensaje(ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UserEmailDuplicatedException.class)
  public ResponseEntity<ApiErrorResponse> handleUserEmailDuplicated(UserEmailDuplicatedException ex) {
    ApiErrorResponse response = new ApiErrorResponse().mensaje(ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(UserPasswordIncorrectException.class)
  public ResponseEntity<ApiErrorResponse> handleUserPasswordIncorrect(UserPasswordIncorrectException ex) {
    ApiErrorResponse response = new ApiErrorResponse().mensaje(ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NotImplementedException.class)
  public ResponseEntity<ApiErrorResponse> handleNotImplemented(NotImplementedException ex) {
    ApiErrorResponse response = new ApiErrorResponse().mensaje(ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.NOT_IMPLEMENTED);
  }
}
