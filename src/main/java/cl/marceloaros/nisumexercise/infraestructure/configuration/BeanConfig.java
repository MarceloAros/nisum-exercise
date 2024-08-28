package cl.marceloaros.nisumexercise.infraestructure.configuration;

import cl.marceloaros.nisumexercise.application.ports.in.IUserSignIn;
import cl.marceloaros.nisumexercise.application.ports.in.IUserSignUp;
import cl.marceloaros.nisumexercise.application.ports.out.IExistUserWIthEmailRepository;
import cl.marceloaros.nisumexercise.application.ports.out.IGetUserByEmailRepository;
import cl.marceloaros.nisumexercise.application.ports.out.ISaveUserRepository;
import cl.marceloaros.nisumexercise.application.usecase.UserSignInUseCase;
import cl.marceloaros.nisumexercise.application.usecase.UserSignUpUseCase;
import cl.marceloaros.nisumexercise.application.utils.ICurrentDateTimeProvider;
import cl.marceloaros.nisumexercise.application.utils.IEmailDomainCheckerProvider;
import cl.marceloaros.nisumexercise.application.utils.IPasswordEncodeProvider;
import cl.marceloaros.nisumexercise.application.utils.ITokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  public IUserSignUp userSignUp(ISaveUserRepository saveUserRepository,
                                IExistUserWIthEmailRepository existUserWIthEmailRepository,
                                ICurrentDateTimeProvider currentDateTimeProvider,
                                IPasswordEncodeProvider passwordEncodeProvider,
                                ITokenProvider tokenProvider,
                                IEmailDomainCheckerProvider emailDomainCheckerProvider) {
    return new UserSignUpUseCase(
        saveUserRepository,
        existUserWIthEmailRepository,
        currentDateTimeProvider,
        passwordEncodeProvider,
        tokenProvider,
        emailDomainCheckerProvider);
  }

  @Bean
  public IUserSignIn userSignIn(IGetUserByEmailRepository getUserByEmailAndPasswordRepository,
                                IPasswordEncodeProvider passwordEncodeProvider,
                                ITokenProvider tokenProvider) {
    return new UserSignInUseCase(
        getUserByEmailAndPasswordRepository,
        passwordEncodeProvider,
        tokenProvider);
  }
}
