# Nisum Exercise

## Descripción
### Descripción ejercicio
Archivo de instrucciones: Ejercicio_JAVA-Especialista_Integracion-BCI.docx.pdf

### Endpoints
- ✅ POST /api/v1/auth/registro 100%
- ✅ POST /api/v1/auth/login 90% (pendiente: refrescar token)
- ⚠️ GET /api/v1/users/{userId} (✅ Auth )

NOTA: Esto también se puede ver en los Contratos OpenApi (Swagger) 3 [\[ Link \]](http://localhost:8080/api/v1/swagger-ui.html)

### Tecnologías usadas
- Java 21
- Spring Boot 3.3
- Spring Security
- java-jwt
- openapi-generator 7.8.0
- Lombok 1.18.34
- Build Tool: Gradle Kotlin DSL
- H2 (DB en Memoria)
- Docker y Docker Compose

## Instrucciones 📖

### Requisitos previos ️📝
- Java 21
  - Variable de entorno JAVA_HOME definida
- IntelliJ IDEA o Docker (con docker-compose)
- Cliente HTTP (ej.: Bruno o Postman)

### Ejecutarlo en local 💻
* 1\. Abrir una terminal en la carperta del proyecto
* 2\. Ejecutar en la terminal el siguiente comando: ```./gradlew bootRun```
* 3\. Pegarle al endpoint registro para registrar un usario.
* 4\. Pegarle al endpoint ingreso para obtener un nuevo token.

### Enlaces utiles
* Contratos OpenApi (Swagger) 3 [\[ Link \]](http://localhost:8080/api/v1/swagger-ui.html)
* Consola BD H2 [\[ Link \]](http://localhost:8080/api/v1/h2-console) 


