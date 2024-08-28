package cl.marceloaros.nisumexercise.application.usecase;

import cl.marceloaros.nisumexercise.application.exception.Constants;
import cl.marceloaros.nisumexercise.application.exception.UserEmailDuplicatedException;
import cl.marceloaros.nisumexercise.application.exception.UserEmailIncorrectDomainException;
import cl.marceloaros.nisumexercise.application.ports.in.IUserSignUp;
import cl.marceloaros.nisumexercise.application.ports.out.IExistUserWIthEmailRepository;
import cl.marceloaros.nisumexercise.application.ports.out.ISaveUserRepository;
import cl.marceloaros.nisumexercise.application.utils.ICurrentDateTimeProvider;
import cl.marceloaros.nisumexercise.application.utils.IEmailDomainCheckerProvider;
import cl.marceloaros.nisumexercise.application.utils.IPasswordEncodeProvider;
import cl.marceloaros.nisumexercise.application.utils.ITokenProvider;
import cl.marceloaros.nisumexercise.domain.User;

public class UserSignUpUseCase implements IUserSignUp {
  private final ISaveUserRepository saveUserRepository;
  private final IExistUserWIthEmailRepository existUserWIthEmailRepository;
  private final ICurrentDateTimeProvider currentDateTimeProvider;
  private final IPasswordEncodeProvider passwordEncodeProvider;
  private final ITokenProvider tokenProvider;
  private final IEmailDomainCheckerProvider emailDomainCheckerProvider;

  public UserSignUpUseCase(ISaveUserRepository saveUserRepository,
                           IExistUserWIthEmailRepository existUserWIthEmailRepository,
                           ICurrentDateTimeProvider currentDateTimeProvider,
                           IPasswordEncodeProvider passwordEncodeProvider,
                           ITokenProvider tokenProvider,
                           IEmailDomainCheckerProvider emailDomainCheckerProvider) {
    this.saveUserRepository = saveUserRepository;
    this.existUserWIthEmailRepository = existUserWIthEmailRepository;
    this.currentDateTimeProvider = currentDateTimeProvider;
    this.passwordEncodeProvider = passwordEncodeProvider;
    this.tokenProvider = tokenProvider;
    this.emailDomainCheckerProvider = emailDomainCheckerProvider;
  }

  @Override
  public User execute(User user) {
    if (!emailDomainCheckerProvider.execute(user.getEmail())) {
      throw new UserEmailIncorrectDomainException(Constants.DOMAIN_EMAIL_NO_ALLOWED);
    }
    if (existUserWIthEmailRepository.existUserWithEmail(user.getEmail())) {
      throw new UserEmailDuplicatedException(Constants.DUPLICATE_EMAIL);
    }
    user.setPassword(passwordEncodeProvider.encryptPassword(user.getPassword()));
    user.setCreatedAt(currentDateTimeProvider.execute());
    user.setLastSignInAt(currentDateTimeProvider.execute());
    user.setToken(tokenProvider.generateToken(user.getEmail()));
    user.setIsActive(true);
    return saveUserRepository.execute(user);
  }
}
