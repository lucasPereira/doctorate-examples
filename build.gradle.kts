plugins {
  java
  kotlin("jvm") version "2.1.20"
}

group = "br.dev.lucas"
version = "1.0-SNAPSHOT"

val configuration: RepositoryHandler.() -> Unit = {
  mavenCentral()
}
repositories(configuration)

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.10.2"))
  testImplementation("org.junit.jupiter:junit-jupiter-api")
  testImplementation("org.junit.jupiter:junit-jupiter-params")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
  useJUnitPlatform()
}

kotlin {
  jvmToolchain(17)
}