package cl.marceloaros.nisumexercise.application.ports.out;

import cl.marceloaros.nisumexercise.domain.User;

public interface ISaveUserRepository {
  User execute(User user);
}
