package cl.marceloaros.nisumexercise.application.exception;

public class UserPasswordIncorrectException extends RuntimeException {
  public UserPasswordIncorrectException(String message) {
    super(message);
  }
}
