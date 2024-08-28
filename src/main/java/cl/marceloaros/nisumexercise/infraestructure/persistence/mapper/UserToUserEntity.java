package cl.marceloaros.nisumexercise.infraestructure.persistence.mapper;

import cl.marceloaros.nisumexercise.domain.Phone;
import cl.marceloaros.nisumexercise.domain.User;
import cl.marceloaros.nisumexercise.infraestructure.persistence.entity.PhoneEntity;
import cl.marceloaros.nisumexercise.infraestructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserToUserEntity {
  public UserEntity execute(User user) {
    UserEntity userEntity = UserEntity.builder()
        .name(user.getName())
        .email(user.getEmail())
        .password(user.getPassword())
        .createdAt(user.getCreatedAt())
        .updatedAt(user.getUpdatedAt())
        .lastSignInAt(user.getLastSignInAt())
        .token(user.getToken())
        .isActive(user.getIsActive())
        .build();
    userEntity.setPhoneEntityList(fromPhoneEntity(userEntity, user.getPhoneList()));
    return userEntity;
  }

  private List<PhoneEntity> fromPhoneEntity(UserEntity userEntity, List<Phone> phoneList) {
    return phoneList.stream()
        .map(phone -> PhoneEntity.builder()
              .number(phone.getNumber())
              .cityCode(phone.getCityCode())
              .countryCode(phone.getCountryCode())
              .user(userEntity)
              .build())
        .toList();
  }
}
