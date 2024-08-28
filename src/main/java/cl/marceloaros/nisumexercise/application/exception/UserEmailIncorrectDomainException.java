package cl.marceloaros.nisumexercise.application.exception;

public class UserEmailIncorrectDomainException extends RuntimeException {
  public UserEmailIncorrectDomainException(String message) {
    super(message);
  }
}
