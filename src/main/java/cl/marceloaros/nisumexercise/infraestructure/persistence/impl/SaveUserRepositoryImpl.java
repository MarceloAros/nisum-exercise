package cl.marceloaros.nisumexercise.infraestructure.persistence.impl;

import cl.marceloaros.nisumexercise.application.ports.out.ISaveUserRepository;
import cl.marceloaros.nisumexercise.domain.User;
import cl.marceloaros.nisumexercise.infraestructure.persistence.IUserRepository;
import cl.marceloaros.nisumexercise.infraestructure.persistence.entity.UserEntity;
import cl.marceloaros.nisumexercise.infraestructure.persistence.mapper.UserEntityToUser;
import cl.marceloaros.nisumexercise.infraestructure.persistence.mapper.UserToUserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class SaveUserRepositoryImpl implements ISaveUserRepository {

  private final IUserRepository iUserRepository;

  private final UserToUserEntity userToUserEntity;
  private final UserEntityToUser userEntityToUser;

  public SaveUserRepositoryImpl(IUserRepository iUserRepository,
                                UserToUserEntity userToUserEntity,
                                UserEntityToUser userEntityToUser) {
    this.iUserRepository = iUserRepository;
    this.userToUserEntity = userToUserEntity;
    this.userEntityToUser = userEntityToUser;
  }

  @Override
  public User execute(User user) {
    UserEntity newUser = iUserRepository.save(userToUserEntity.execute(user));
    return userEntityToUser.execute(newUser);
  }
}
