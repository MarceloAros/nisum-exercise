package cl.marceloaros.nisumexercise.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ApiSignUpRequestPhonesInner
 */

@JsonTypeName("SignUpRequest_phones_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.8.0")
public class ApiSignUpRequestPhonesInner {

  private String number;

  private String citycode;

  private String contrycode;

  public ApiSignUpRequestPhonesInner number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
   */
  
  @Schema(name = "number", example = "1234567", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ApiSignUpRequestPhonesInner citycode(String citycode) {
    this.citycode = citycode;
    return this;
  }

  /**
   * Get citycode
   * @return citycode
   */
  
  @Schema(name = "citycode", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("citycode")
  public String getCitycode() {
    return citycode;
  }

  public void setCitycode(String citycode) {
    this.citycode = citycode;
  }

  public ApiSignUpRequestPhonesInner contrycode(String contrycode) {
    this.contrycode = contrycode;
    return this;
  }

  /**
   * Get contrycode
   * @return contrycode
   */
  
  @Schema(name = "contrycode", example = "57", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contrycode")
  public String getContrycode() {
    return contrycode;
  }

  public void setContrycode(String contrycode) {
    this.contrycode = contrycode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiSignUpRequestPhonesInner signUpRequestPhonesInner = (ApiSignUpRequestPhonesInner) o;
    return Objects.equals(this.number, signUpRequestPhonesInner.number) &&
        Objects.equals(this.citycode, signUpRequestPhonesInner.citycode) &&
        Objects.equals(this.contrycode, signUpRequestPhonesInner.contrycode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, citycode, contrycode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiSignUpRequestPhonesInner {\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    citycode: ").append(toIndentedString(citycode)).append("\n");
    sb.append("    contrycode: ").append(toIndentedString(contrycode)).append("\n");
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

