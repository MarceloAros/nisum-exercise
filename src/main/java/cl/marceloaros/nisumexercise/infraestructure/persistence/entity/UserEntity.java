package cl.marceloaros.nisumexercise.infraestructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "uuid")
  private UUID uuid;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", unique = true, nullable = false)
  @Email
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "created_at", updatable = false, nullable = false)
  private OffsetDateTime createdAt;

  @Column(name = "update_at")
  private OffsetDateTime updatedAt;

  @Column(name = "last_signin_at")
  private OffsetDateTime lastSignInAt;

  @Column(name = "token")
  private String token;

  @Column(name = "is_active", nullable = false)
  private Boolean isActive;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PhoneEntity> phoneEntityList;
}

