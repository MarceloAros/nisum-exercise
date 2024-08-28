package cl.marceloaros.nisumexercise.application.usecase;

import cl.marceloaros.nisumexercise.application.exception.Constants;
import cl.marceloaros.nisumexercise.application.exception.UserEmailDuplicatedException;
import cl.marceloaros.nisumexercise.application.exception.UserEmailIncorrectDomainException;
import cl.marceloaros.nisumexercise.application.ports.out.IExistUserWIthEmailRepository;
import cl.marceloaros.nisumexercise.application.ports.out.ISaveUserRepository;
import cl.marceloaros.nisumexercise.application.utils.ICurrentDateTimeProvider;
import cl.marceloaros.nisumexercise.application.utils.IEmailDomainCheckerProvider;
import cl.marceloaros.nisumexercise.application.utils.IPasswordEncodeProvider;
import cl.marceloaros.nisumexercise.application.utils.ITokenProvider;
import cl.marceloaros.nisumexercise.domain.User;
import cl.marceloaros.nisumexercise.mocks.user.UserMocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserSignUpUseCaseTest {
  private UserSignUpUseCase userSignUpUseCase;

  @Mock private ISaveUserRepository saveUserRepository;
  @Mock private IExistUserWIthEmailRepository existUserWithEmailRepository;
  @Mock private ICurrentDateTimeProvider currentDateTimeProvider;
  @Mock private IPasswordEncodeProvider passwordEncodeProvider;
  @Mock private ITokenProvider tokenProvider;
  @Mock private IEmailDomainCheckerProvider emailDomainCheckerProvider;

  @BeforeEach
  void setUp() {
    userSignUpUseCase = new UserSignUpUseCase(
      saveUserRepository,
      existUserWithEmailRepository,
      currentDateTimeProvider,
      passwordEncodeProvider,
      tokenProvider,
      emailDomainCheckerProvider);
  }

  @Test
  void should_return_a_valid_user_when_provided_a_valid_user() {
    User expectedUser = UserMocks.validOutputUser;
    // GIVEN
    User givenUser = UserMocks.validInputUser;
    when(emailDomainCheckerProvider.execute(givenUser.getEmail()))
        .thenReturn(true);
    when(existUserWithEmailRepository.existUserWithEmail(givenUser.getEmail()))
        .thenReturn(false);
    when(passwordEncodeProvider.encryptPassword(givenUser.getPassword()))
        .thenReturn(expectedUser.getPassword());
    when(currentDateTimeProvider.execute())
        .thenReturn(expectedUser.getCreatedAt());
    when(tokenProvider.generateToken(givenUser.getEmail()))
        .thenReturn(expectedUser.getToken());
    when(saveUserRepository.execute(givenUser))
        .thenReturn(UserMocks.validOutputUser);

    // WHEN
    User result = userSignUpUseCase.execute(givenUser);

    // THEN
    assertThat(result).usingRecursiveComparison().isEqualTo(expectedUser);
  }

  @Test
  void should_return_Exception_when_provided_a_valid_user_with_not_allow_domain_email() {
    UserEmailIncorrectDomainException expected = new UserEmailIncorrectDomainException(Constants.DOMAIN_EMAIL_NO_ALLOWED);
    // GIVEN
    User givenUser = UserMocks.InputUserInvalidEmail;
    when(emailDomainCheckerProvider.execute(givenUser.getEmail()))
        .thenReturn(false);

    // WHEN
    UserEmailIncorrectDomainException result = assertThrows(UserEmailIncorrectDomainException.class,
        () -> userSignUpUseCase.execute(givenUser));

    // THEN
    assertThat(result).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void should_return_Exception_when_provided_a_valid_user_with_email_then_already_exists() {
    UserEmailDuplicatedException expected = new UserEmailDuplicatedException(Constants.DUPLICATE_EMAIL);
    // GIVEN
    User givenUser = UserMocks.validInputUser;
    when(emailDomainCheckerProvider.execute(givenUser.getEmail()))
        .thenReturn(true);
    when(existUserWithEmailRepository.existUserWithEmail(givenUser.getEmail()))
        .thenReturn(true);

    // WHEN
    UserEmailDuplicatedException result = assertThrows(UserEmailDuplicatedException.class,
        () -> userSignUpUseCase.execute(givenUser));

    // THEN
    assertThat(result).usingRecursiveComparison().isEqualTo(expected);
  }
}



