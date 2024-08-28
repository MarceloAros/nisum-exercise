package cl.marceloaros.nisumexercise.infraestructure.controller;

import cl.marceloaros.nisumexercise.AuthApi;
import cl.marceloaros.nisumexercise.application.ports.in.IUserSignIn;
import cl.marceloaros.nisumexercise.application.ports.in.IUserSignUp;
import cl.marceloaros.nisumexercise.domain.User;
import cl.marceloaros.nisumexercise.infraestructure.controller.mapper.ApiSignUpRequestToUser;
import cl.marceloaros.nisumexercise.infraestructure.controller.mapper.UserToApiSignUpResponse;
import cl.marceloaros.nisumexercise.model.ApiSignInRequest;
import cl.marceloaros.nisumexercise.model.ApiSignInResponse;
import cl.marceloaros.nisumexercise.model.ApiSignUpRequest;
import cl.marceloaros.nisumexercise.model.ApiSignUpResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

  private final IUserSignUp userSignUp;
  private final IUserSignIn userSignIn;

  private final ApiSignUpRequestToUser apiSignUpRequestToUser;
  private final UserToApiSignUpResponse userToApiSignUpResponse;

  AuthController(IUserSignUp userSignUp, IUserSignIn userSignIn, ApiSignUpRequestToUser apiSignUpRequestToUser, UserToApiSignUpResponse userToApiSignUpResponse) {
    this.userSignUp = userSignUp;
    this.userSignIn = userSignIn;
    this.apiSignUpRequestToUser = apiSignUpRequestToUser;
    this.userToApiSignUpResponse = userToApiSignUpResponse;
  }

  @Override
  public ResponseEntity<ApiSignUpResponse> userSignUp(ApiSignUpRequest apiSignUpRequest) {
    User newUser = userSignUp.execute(apiSignUpRequestToUser.execute(apiSignUpRequest));
    return new ResponseEntity<>(userToApiSignUpResponse.execute(newUser), HttpStatusCode.valueOf(201));
  }

  @Override
  public ResponseEntity<ApiSignInResponse> userSignIn(ApiSignInRequest apiSignInRequest) {
    User signInUser = userSignIn.execute(apiSignInRequest.getEmail(), apiSignInRequest.getPassword());
    return ResponseEntity.ok(new ApiSignInResponse().name(signInUser.getName()).token(signInUser.getToken()));
  }
}
