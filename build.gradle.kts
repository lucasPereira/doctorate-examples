plugins {
  kotlin("jvm") version "2.1.20"
}

group = "br.dev.lucas"
version = "1.0-SNAPSHOT"

val configuration: RepositoryHandler.() -> Unit = {
  mavenCentral()
}
repositories(configuration)

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

tasks.test {
  useJUnitPlatform()
}

kotlin {
  jvmToolchain(17)
}