package cl.marceloaros.nisumexercise.application.utils;

public interface ITokenProvider {
  String generateToken(String userEmail);
}
