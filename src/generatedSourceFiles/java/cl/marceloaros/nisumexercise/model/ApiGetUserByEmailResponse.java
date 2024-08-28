package cl.marceloaros.nisumexercise.model;

import java.net.URI;
import java.util.Objects;
import cl.marceloaros.nisumexercise.model.ApiSignUpRequestPhonesInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ApiGetUserByEmailResponse
 */

@JsonTypeName("GetUserByEmailResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.8.0")
public class ApiGetUserByEmailResponse {

  private String name;

  private String email;

  @Valid
  private List<@Valid ApiSignUpRequestPhonesInner> phones = new ArrayList<>();

  public ApiGetUserByEmailResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", example = "Fulgencio Rutherford", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ApiGetUserByEmailResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  
  @Schema(name = "email", example = "aaaaaaa@dominio.cl", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ApiGetUserByEmailResponse phones(List<@Valid ApiSignUpRequestPhonesInner> phones) {
    this.phones = phones;
    return this;
  }

  public ApiGetUserByEmailResponse addPhonesItem(ApiSignUpRequestPhonesInner phonesItem) {
    if (this.phones == null) {
      this.phones = new ArrayList<>();
    }
    this.phones.add(phonesItem);
    return this;
  }

  /**
   * Get phones
   * @return phones
   */
  @Valid 
  @Schema(name = "phones", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phones")
  public List<@Valid ApiSignUpRequestPhonesInner> getPhones() {
    return phones;
  }

  public void setPhones(List<@Valid ApiSignUpRequestPhonesInner> phones) {
    this.phones = phones;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiGetUserByEmailResponse getUserByEmailResponse = (ApiGetUserByEmailResponse) o;
    return Objects.equals(this.name, getUserByEmailResponse.name) &&
        Objects.equals(this.email, getUserByEmailResponse.email) &&
        Objects.equals(this.phones, getUserByEmailResponse.phones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, phones);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiGetUserByEmailResponse {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phones: ").append(toIndentedString(phones)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

