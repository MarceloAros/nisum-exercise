package cl.marceloaros.nisumexercise.infraestructure.utils;

import cl.marceloaros.nisumexercise.application.utils.IEmailDomainCheckerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailDomainCheckerProviderImpl implements IEmailDomainCheckerProvider {
  @Value("${email-regex-allowed}")
  private String emailRegEx;

  @Override
  public Boolean execute(String email) {
    return email.matches(emailRegEx);
  }
}
