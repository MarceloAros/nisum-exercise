package cl.marceloaros.nisumexercise.infraestructure.exception;

public class NotImplementedException extends RuntimeException {
  public static final String TEXT = "Funcionalidad no implementada.";

  public NotImplementedException() {
    super(TEXT);
  }

  public NotImplementedException(String message) {
    super(message);
  }
}
