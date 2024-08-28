package cl.marceloaros.nisumexercise.infraestructure.persistence.impl;

import cl.marceloaros.nisumexercise.application.ports.out.IExistUserWIthEmailRepository;
import cl.marceloaros.nisumexercise.infraestructure.persistence.IUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExistUserWIthEmailRepositoryImpl implements IExistUserWIthEmailRepository {
  private final IUserRepository iUserRepository;

  public ExistUserWIthEmailRepositoryImpl(IUserRepository iUserRepository) {
    this.iUserRepository = iUserRepository;
  }

  @Override
  public Boolean existUserWithEmail(String email) {
    return iUserRepository.existsByEmail(email);
  }
}
