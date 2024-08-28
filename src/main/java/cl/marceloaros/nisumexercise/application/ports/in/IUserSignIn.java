package cl.marceloaros.nisumexercise.application.ports.in;

import cl.marceloaros.nisumexercise.domain.User;

public interface IUserSignIn {
  User execute(String userEmail, String password);
}
