package cl.marceloaros.nisumexercise.mocks.user;

import cl.marceloaros.nisumexercise.domain.Phone;
import cl.marceloaros.nisumexercise.domain.User;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

public class UserMocks {
  public UserMocks() {
    throw new IllegalArgumentException("Utility class");
  }
  public static final String UUID_USER_1_STRING = "e58ed763-928c-4155-bee9-fdbaaadc15f3";
  public static final UUID UUID_USER_1 = UUID.fromString(UUID_USER_1_STRING);
  public static final String NAME_SAMPLE = "Fulgencio";
  public static final String PASSWORD_SAMPLE = "123456";
  public static final String EMAIL_SAMPLE = "fulgencio@dominio.cl";
  public static final String EMAIL_INVALID_SAMPLE = "fulgencio@dominio.c";
  public static final OffsetDateTime CREATED_AT_SAMPLE = OffsetDateTime.of(2024, 8, 27, 14, 30, 0, 0, ZoneOffset.UTC);
  public static final OffsetDateTime UPDATE_AT_SAMPLE = OffsetDateTime.of(2024, 8, 27, 14, 30, 0, 0, ZoneOffset.UTC);
  public static final OffsetDateTime LAST_SIGN_IN_AT_SAMPLE = OffsetDateTime.of(2024, 8, 27, 14, 30, 0, 0, ZoneOffset.UTC);
  public static final String TOKES_SAMPLE = "header.payload.signature";

  public static final String NUMBER_SAMPLE = "123456789";
  public static final String COUNTRY_CODE_SAMPLE = "56";
  public static final String CITY_CODE_SAMPLE = "32";
  public static final Boolean IS_ACTIVE_TRUE = true;
  public static final Boolean IS_ACTIVE_FALSE = false;

  public static final User validInputUser = User.builder()
      .name(NAME_SAMPLE)
      .email(EMAIL_SAMPLE)
      .password(PASSWORD_SAMPLE)
      .phoneList(List.of(Phone.builder()
              .number(NUMBER_SAMPLE)
              .countryCode(COUNTRY_CODE_SAMPLE)
              .cityCode(CITY_CODE_SAMPLE)
          .build()))
      .build();

  public static final User InputUserInvalidEmail = User.builder()
      .name(NAME_SAMPLE)
      .email(EMAIL_INVALID_SAMPLE)
      .password(PASSWORD_SAMPLE)
      .phoneList(List.of(Phone.builder()
          .number(NUMBER_SAMPLE)
          .countryCode(COUNTRY_CODE_SAMPLE)
          .cityCode(CITY_CODE_SAMPLE)
          .build()))
      .build();

  public static final User validOutputUser = User.builder()
      .uuid(UUID_USER_1)
      .name(NAME_SAMPLE)
      .email(EMAIL_SAMPLE)
      .password(PASSWORD_SAMPLE)
      .createdAt(CREATED_AT_SAMPLE)
      .updatedAt(UPDATE_AT_SAMPLE)
      .lastSignInAt(LAST_SIGN_IN_AT_SAMPLE)
      .token(TOKES_SAMPLE)
      .isActive(IS_ACTIVE_TRUE)
      .phoneList(List.of(Phone.builder()
          .number(NUMBER_SAMPLE)
          .countryCode(COUNTRY_CODE_SAMPLE)
          .cityCode(CITY_CODE_SAMPLE)
          .build()))
      .build();


}
