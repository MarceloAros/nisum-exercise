package cl.marceloaros.nisumexercise.infraestructure.persistence.mapper;

import cl.marceloaros.nisumexercise.domain.User;
import cl.marceloaros.nisumexercise.infraestructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUser {
  public User execute(UserEntity userEntity) {
    return User.builder()
        .uuid(userEntity.getUuid())
        .name(userEntity.getName())
        .email(userEntity.getEmail())
        .password(userEntity.getPassword())
        .createdAt(userEntity.getCreatedAt())
        .updatedAt(userEntity.getUpdatedAt())
        .lastSignInAt(userEntity.getLastSignInAt())
        .token(userEntity.getToken())
        .isActive(userEntity.getIsActive())
        .build();
  }
}
