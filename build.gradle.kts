plugins {
	java
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
	id("org.openapi.generator") version "7.8.0"
}

group = "cl.marceloaros"
version = "0.0.1-SNAPSHOT"


java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

val generatedCompileConfig: Configuration by configurations.creating


repositories {
	mavenCentral()
}

dependencies {
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	testImplementation("org.springframework.security:spring-security-test")
	implementation("com.auth0:java-jwt:4.4.0")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	generatedCompileConfig("org.springframework.boot:spring-boot-starter-web")
	generatedCompileConfig("org.springframework.data:spring-data-commons")
	generatedCompileConfig("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	generatedCompileConfig("com.google.code.findbugs:jsr305:3.0.2")
	generatedCompileConfig("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
	generatedCompileConfig("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
	generatedCompileConfig("org.openapitools:jackson-databind-nullable:0.2.6")
	generatedCompileConfig("org.springframework.boot:spring-boot-starter-validation")
	generatedCompileConfig("com.fasterxml.jackson.core:jackson-databind")
	generatedCompileConfig("org.projectlombok:lombok")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

/****** CODE GENERATION  ******/
sourceSets {
	val generatedSourceFiles by creating {
		compileClasspath = compileClasspath + generatedCompileConfig
	}
	main {
		compileClasspath = compileClasspath + generatedSourceFiles.output
		runtimeClasspath = runtimeClasspath + generatedSourceFiles.output
	}
	test {
		compileClasspath = compileClasspath + generatedSourceFiles.output
		runtimeClasspath = runtimeClasspath + generatedSourceFiles.output
	}
}


val openApiSourceFile = "src/main/resources/api.yaml"
val openApiTargetFolder = "src/generatedSourceFiles/"

val basePackageName = "cl.marceloaros.nisumexercise"
val modelPackageName = "${basePackageName}.model"

tasks {
	openApiGenerate {
		generatorName.set("spring")

		inputSpec.set("${projectDir}/${openApiSourceFile}")
		outputDir.set("${projectDir}/${openApiTargetFolder}")
		apiPackage.set(basePackageName)
		modelPackage.set(modelPackageName)
		additionalProperties.set(mapOf(
			"library" to "spring-boot",
			"modelNamePrefix" to "Api",
			"modelDocs" to "false"
		))
		configOptions.set(mapOf(
			"generatedConstructorWithRequiredArgs" to "false",
			"useSpringBoot3" to "true",
			"dateLibrary" to "java8",
			"interfaceOnly" to "true",
			"hideGenerationTimestamp" to "true",
			"generateApiDocumentation" to "false",
			"useTags" to "true",
			//"additionalModelTypeAnnotations" to "@lombok.NoArgsConstructor @lombok.AllArgsConstructor @lombok.Builder @lombok.Getter",
			"sourceFolder" to "java",
			"x-setter-extra-annotation" to "@lombok.Builder.Default"
		))
	}

	bootRun {
		classpath = classpath + sourceSets["generatedSourceFiles"].output
	}

	jar {
		from(sourceSets["generatedSourceFiles"].output)
	}

	"compileGeneratedSourceFilesJava" {
		dependsOn(openApiGenerate)
	}
	getByName("classes") {
		dependsOn("generatedSourceFilesClasses")
	}
	compileJava {
		dependsOn("compileGeneratedSourceFilesJava")
	}

	clean {
		doFirst {
			delete(
				"${openApiTargetFolder}/java",
				"${openApiTargetFolder}/.openapi-generator")
		}
	}

	processResources {
		dependsOn(openApiGenerate)
	}
}

