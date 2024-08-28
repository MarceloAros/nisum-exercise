package cl.marceloaros.nisumexercise.infraestructure.utils;

import cl.marceloaros.nisumexercise.application.utils.ITokenProvider;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenProviderImpl implements ITokenProvider {
  private final JwtUtils jwtUtils;

  public TokenProviderImpl(JwtUtils jwtUtils) {
    this.jwtUtils = jwtUtils;
  }

  @Override
  public String generateToken(String userEmail) {
    return jwtUtils.generateTokenWithUserEmail(userEmail);
  }
}
