package cl.marceloaros.nisumexercise.domain;

public class Phone {
  private String number;
  private String cityCode;
  private String countryCode;

  public Phone(String number, String cityCode, String countryCode) {
    this.number = number;
    this.cityCode = cityCode;
    this.countryCode = countryCode;
  }

  public static PhoneBuilder builder() {
    return new PhoneBuilder();
  }

  public String getNumber() {
    return this.number;
  }

  public String getCityCode() {
    return this.cityCode;
  }

  public String getCountryCode() {
    return this.countryCode;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public static class PhoneBuilder {
    private String number;
    private String cityCode;
    private String countryCode;

    PhoneBuilder() {
    }

    public PhoneBuilder number(String number) {
      this.number = number;
      return this;
    }

    public PhoneBuilder cityCode(String cityCode) {
      this.cityCode = cityCode;
      return this;
    }

    public PhoneBuilder countryCode(String countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    public Phone build() {
      return new Phone(this.number, this.cityCode, this.countryCode);
    }

    public String toString() {
      return "Phone.PhoneBuilder(number=" + this.number + ", cityCode=" + this.cityCode + ", countryCode=" + this.countryCode + ")";
    }
  }
}
