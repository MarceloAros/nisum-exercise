package cl.marceloaros.nisumexercise.infraestructure.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class OpenApiConfig {
  public static final String TITLE = "Nisum API Exercise";
  public static final String VERSION = "1.0.0";
  public static final String DESCRIPTION = "Nisum Exercise";
  public static final String CONTACT_EMAIL = "marceloaros@gmail.com";
  public static final String CONTACT_NAME = "Marcelo Aros";
  public static final String CONTACT_URL = "https://github.com/marceloaros";

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title(TITLE)
            .description(DESCRIPTION)
            .version(VERSION)
            .contact(new Contact()
                .email(CONTACT_EMAIL)
                .name(CONTACT_NAME)
                .url(CONTACT_URL)
            )
        )
        .components(
            new Components()
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")
        ));
  }
}
