package cl.marceloaros.nisumexercise.infraestructure.controller.mapper;

import cl.marceloaros.nisumexercise.domain.User;
import cl.marceloaros.nisumexercise.model.ApiSignUpResponse;
import org.springframework.stereotype.Component;

@Component
public class UserToApiSignUpResponse {
  public ApiSignUpResponse execute(User user) {
    return new ApiSignUpResponse()
        .uuid(user.getUuid())
        .created(user.getCreatedAt())
        .modified(user.getUpdatedAt())
        .lastLogin(user.getLastSignInAt())
        .token(user.getToken())
        .isactive(user.getIsActive());
  }
}
