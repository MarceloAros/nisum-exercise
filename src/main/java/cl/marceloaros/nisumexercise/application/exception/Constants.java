package cl.marceloaros.nisumexercise.application.exception;

public class Constants {
  public Constants() {
    throw new IllegalAccessError("Utility class");
  }

  public static final String DOMAIN_EMAIL_NO_ALLOWED = "El dominio del correo no está permitido.";

  public static final String DUPLICATE_EMAIL = "El correo ya registrado.";

  public static final String USER_EMAIL_NOT_FOUND = "Correo electronico no encontrado.";

  public static final String USER_PASSWORD_INCORRECT = "Contraseña ingresada incorrecta.";
}
