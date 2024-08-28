package cl.marceloaros.nisumexercise.infraestructure.persistence.impl;

import cl.marceloaros.nisumexercise.application.ports.out.IGetUserByEmailRepository;
import cl.marceloaros.nisumexercise.domain.User;
import cl.marceloaros.nisumexercise.infraestructure.persistence.IUserRepository;
import cl.marceloaros.nisumexercise.infraestructure.persistence.entity.UserEntity;
import cl.marceloaros.nisumexercise.infraestructure.persistence.mapper.UserEntityToUser;

import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class GetUserByEmailRepository implements IGetUserByEmailRepository {
  private final IUserRepository userRepository;
  private final UserEntityToUser userEntityToUser;

  public GetUserByEmailRepository(IUserRepository userRepository, UserEntityToUser userEntityToUser) {
    this.userRepository = userRepository;
    this.userEntityToUser = userEntityToUser;
  }

  @Override
  public Optional<User> execute(String email) {
    Optional<UserEntity> userEntity = userRepository.findByEmail(email);
    return userEntity.map(userEntityToUser::execute);
  }
}

