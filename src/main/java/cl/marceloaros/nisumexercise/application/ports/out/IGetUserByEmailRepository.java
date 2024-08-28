package cl.marceloaros.nisumexercise.application.ports.out;

import cl.marceloaros.nisumexercise.domain.User;

import java.util.Optional;

public interface IGetUserByEmailRepository {
  Optional<User> execute(String email);
}
