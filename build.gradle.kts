plugins {
    kotlin("jvm") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.kord.dev/snapshots")
}

dependencies {
    implementation("dev.kord:kord-core:0.15.0")
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}