package cl.marceloaros.nisumexercise.infraestructure.persistence;


import cl.marceloaros.nisumexercise.infraestructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
  boolean existsByEmail(String email);

  Optional<UserEntity> findByEmail(String email);
}
