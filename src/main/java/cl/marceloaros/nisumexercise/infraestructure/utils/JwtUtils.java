package cl.marceloaros.nisumexercise.infraestructure.utils;

import cl.marceloaros.nisumexercise.infraestructure.exception.InvalidTokenException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
  @Value("${spring.security.jwt.keys.private}")
  private String privateKey;

  @Value("${spring.security.jwt.isser}")
  private String issuer;

  public String generateToken(Authentication authentication) {
    final Algorithm algorithm = Algorithm.HMAC512(privateKey);
    final String userEmail = authentication.getPrincipal().toString();

    return JWT.create()
        .withIssuer(this.issuer)
        .withSubject(userEmail)
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(System.currentTimeMillis() + 172800000))
        .sign(algorithm);
  }

  public String generateTokenWithUserEmail(String userEmail) {
    final Algorithm algorithm = Algorithm.HMAC512(privateKey);
    return JWT.create()
        .withIssuer(this.issuer)
        .withSubject(userEmail)
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(System.currentTimeMillis() + 172800000))
        .sign(algorithm);
  }

  public DecodedJWT verifyToken(String token) {
    final Algorithm algorithm = Algorithm.HMAC512(privateKey);
    try {
      JWTVerifier verifier = JWT.require(algorithm)
          .withIssuer(this.issuer)
          .build();
      return verifier.verify(token);
    } catch (JWTVerificationException e) {
      throw new InvalidTokenException("Token invalido");
    }
  }

}
