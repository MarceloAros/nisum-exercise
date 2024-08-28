package cl.marceloaros.nisumexercise.application.exception;

public class UserEmailDuplicatedException extends RuntimeException {
  public UserEmailDuplicatedException(String message) {
    super(message);
  }
}
