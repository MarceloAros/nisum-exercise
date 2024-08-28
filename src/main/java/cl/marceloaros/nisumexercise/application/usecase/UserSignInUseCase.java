package cl.marceloaros.nisumexercise.application.usecase;

import cl.marceloaros.nisumexercise.application.exception.Constants;
import cl.marceloaros.nisumexercise.application.exception.UserEmailNotFoundException;
import cl.marceloaros.nisumexercise.application.exception.UserPasswordIncorrectException;
import cl.marceloaros.nisumexercise.application.ports.in.IUserSignIn;
import cl.marceloaros.nisumexercise.application.ports.out.IGetUserByEmailRepository;
import cl.marceloaros.nisumexercise.application.utils.IPasswordEncodeProvider;
import cl.marceloaros.nisumexercise.application.utils.ITokenProvider;
import cl.marceloaros.nisumexercise.domain.User;


public class UserSignInUseCase implements IUserSignIn {
  private final IGetUserByEmailRepository getUserByEmailAndPasswordRepository;
  private final IPasswordEncodeProvider passwordEncodeProvider;
  private final ITokenProvider tokenProvider;

  public UserSignInUseCase(IGetUserByEmailRepository getUserByEmailAndPasswordRepository,
                           IPasswordEncodeProvider passwordEncodeProvider,
                           ITokenProvider tokenProvider) {
    this.getUserByEmailAndPasswordRepository = getUserByEmailAndPasswordRepository;
    this.passwordEncodeProvider = passwordEncodeProvider;
    this.tokenProvider = tokenProvider;
  }

  @Override
  public User execute(String userEmail, String password) {

    User existingUser = getUserByEmailAndPasswordRepository.execute(userEmail)
        .orElseThrow(() -> new UserEmailNotFoundException(Constants.USER_EMAIL_NOT_FOUND));

    if(!passwordEncodeProvider.verifyPassword(password, existingUser.getPassword())) {
      throw new UserPasswordIncorrectException(Constants.USER_PASSWORD_INCORRECT);
    }

    return existingUser;
  }
}
