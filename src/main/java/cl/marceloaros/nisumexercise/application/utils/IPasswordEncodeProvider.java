package cl.marceloaros.nisumexercise.application.utils;

public interface IPasswordEncodeProvider {
  String encryptPassword(String password);
  Boolean verifyPassword(String password, String encryptedPassword);
}
