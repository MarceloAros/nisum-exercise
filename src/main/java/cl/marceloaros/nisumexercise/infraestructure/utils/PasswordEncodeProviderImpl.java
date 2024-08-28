package cl.marceloaros.nisumexercise.infraestructure.utils;

import cl.marceloaros.nisumexercise.application.utils.IPasswordEncodeProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncodeProviderImpl implements IPasswordEncodeProvider {
  private final PasswordEncoder passwordEncoder;

  public PasswordEncodeProviderImpl(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public String encryptPassword(String password) {
    return passwordEncoder.encode(password);
  }

  @Override
  public Boolean verifyPassword(String password, String encryptedPassword) {
    return passwordEncoder.matches(password, encryptedPassword);
  }
}
