package cl.marceloaros.nisumexercise.infraestructure.controller.mapper;

import cl.marceloaros.nisumexercise.domain.Phone;
import cl.marceloaros.nisumexercise.domain.User;

import cl.marceloaros.nisumexercise.model.ApiSignUpRequest;
import cl.marceloaros.nisumexercise.model.ApiSignUpRequestPhonesInner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiSignUpRequestToUser {
  public User execute(ApiSignUpRequest apiSignUpRequest) {
    return User.builder()
        .name(apiSignUpRequest.getName())
        .email(apiSignUpRequest.getEmail())
        .password(apiSignUpRequest.getPassword())
        .phoneList(apiSignUpRequestPhonesInnerToPhoneList(apiSignUpRequest.getPhones()))
        .build();
  }

  private List<Phone> apiSignUpRequestPhonesInnerToPhoneList( List<ApiSignUpRequestPhonesInner> apiPhones) {
    return apiPhones.stream()
        .map(apiPhone -> Phone.builder()
            .number(apiPhone.getNumber())
            .cityCode(apiPhone.getCitycode())
            .countryCode(apiPhone.getContrycode())
            .build())
        .toList();
  }

}
