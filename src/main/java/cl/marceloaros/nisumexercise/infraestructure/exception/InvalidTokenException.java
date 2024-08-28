package cl.marceloaros.nisumexercise.infraestructure.exception;

public class InvalidTokenException extends RuntimeException {
  public InvalidTokenException(String message) {
    super(message);
  }
}
