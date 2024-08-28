package cl.marceloaros.nisumexercise.domain;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public class User {
  private UUID uuid;
  private String name;
  private String email;
  private String password;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
  private OffsetDateTime lastSignInAt;
  private String token;
  private Boolean isActive;
  private List<Phone> phoneList;

  public User(UUID uuid, String name, String email, String password, OffsetDateTime createdAt, OffsetDateTime updatedAt, OffsetDateTime lastSignInAt, String token, Boolean isActive, List<Phone> phoneList) {
    this.uuid = uuid;
    this.name = name;
    this.email = email;
    this.password = password;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.lastSignInAt = lastSignInAt;
    this.token = token;
    this.isActive = isActive;
    this.phoneList = phoneList;
  }

  public static UserBuilder builder() {
    return new UserBuilder();
  }

  public UUID getUuid() {
    return this.uuid;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }

  public OffsetDateTime getCreatedAt() {
    return this.createdAt;
  }

  public OffsetDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public OffsetDateTime getLastSignInAt() {
    return this.lastSignInAt;
  }

  public String getToken() {
    return this.token;
  }

  public Boolean getIsActive() {
    return this.isActive;
  }

  public List<Phone> getPhoneList() {
    return this.phoneList;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setLastSignInAt(OffsetDateTime lastSignInAt) {
    this.lastSignInAt = lastSignInAt;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public void setPhoneList(List<Phone> phoneList) {
    this.phoneList = phoneList;
  }

  public static class UserBuilder {
    private UUID uuid;
    private String name;
    private String email;
    private String password;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime lastSignInAt;
    private String token;
    private Boolean isActive;
    private List<Phone> phoneList;

    UserBuilder() {
    }

    public UserBuilder uuid(UUID uuid) {
      this.uuid = uuid;
      return this;
    }

    public UserBuilder name(String name) {
      this.name = name;
      return this;
    }

    public UserBuilder email(String email) {
      this.email = email;
      return this;
    }

    public UserBuilder password(String password) {
      this.password = password;
      return this;
    }

    public UserBuilder createdAt(OffsetDateTime createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public UserBuilder updatedAt(OffsetDateTime updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public UserBuilder lastSignInAt(OffsetDateTime lastSignInAt) {
      this.lastSignInAt = lastSignInAt;
      return this;
    }

    public UserBuilder token(String token) {
      this.token = token;
      return this;
    }

    public UserBuilder isActive(Boolean isActive) {
      this.isActive = isActive;
      return this;
    }

    public UserBuilder phoneList(List<Phone> phoneList) {
      this.phoneList = phoneList;
      return this;
    }

    public User build() {
      return new User(this.uuid, this.name, this.email, this.password, this.createdAt, this.updatedAt, this.lastSignInAt, this.token, this.isActive, this.phoneList);
    }

    public String toString() {
      return "User.UserBuilder(uuid=" + this.uuid + ", name=" + this.name + ", email=" + this.email + ", password=" + this.password + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", lastSignInAt=" + this.lastSignInAt + ", token=" + this.token + ", isActive=" + this.isActive + ", phoneList=" + this.phoneList + ")";
    }
  }
}
