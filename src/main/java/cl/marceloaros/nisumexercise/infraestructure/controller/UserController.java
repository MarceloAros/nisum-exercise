package cl.marceloaros.nisumexercise.infraestructure.controller;

import cl.marceloaros.nisumexercise.UsersApi;
import cl.marceloaros.nisumexercise.infraestructure.exception.NotImplementedException;
import cl.marceloaros.nisumexercise.model.ApiGetUserByEmailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UsersApi {

  @Override
  public ResponseEntity<ApiGetUserByEmailResponse> getUserByEmail(String userEmail) {
    throw new NotImplementedException();
  }
}
