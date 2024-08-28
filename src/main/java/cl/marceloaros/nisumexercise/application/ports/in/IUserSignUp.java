package cl.marceloaros.nisumexercise.application.ports.in;

import cl.marceloaros.nisumexercise.domain.User;

public interface IUserSignUp {
  User execute(User user);
}
