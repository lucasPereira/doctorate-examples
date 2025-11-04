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
  testImplementation(kotlin("test"))
}

tasks.test {
  useJUnitPlatform()
}
kotlin {
  jvmToolchain(17)
}