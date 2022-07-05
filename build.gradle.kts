plugins {
  id("uk.gov.justice.hmpps.gradle-spring-boot") version "4.3.2"
  kotlin("plugin.spring") version "1.6.21"
  kotlin("plugin.jpa") version "1.7.0"
}

configurations {
  testImplementation { exclude(group = "org.junit.vintage") }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")

  runtimeOnly("org.postgresql:postgresql:42.4.0")
  runtimeOnly("org.flywaydb:flyway-core:8.5.13")
}

java {
  toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks {
  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
      jvmTarget = "17"
    }
  }
}
