package cl.marceloaros.nisumexercise.application.utils;

import java.time.OffsetDateTime;

public interface ICurrentDateTimeProvider {
  OffsetDateTime execute();
}
