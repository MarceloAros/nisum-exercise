package cl.marceloaros.nisumexercise.infraestructure.utils;

import cl.marceloaros.nisumexercise.application.utils.ICurrentDateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class CurrentDateTimeProviderImpl implements ICurrentDateTimeProvider {

  @Override
  public OffsetDateTime execute() {
    return OffsetDateTime.now();
  }
}
