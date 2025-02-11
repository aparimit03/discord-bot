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

    // Kord is the library we use to interact with Discord
    implementation("dev.kord:kord-core:0.15.0")

    // dotenv-kotlin is a library that allows us to read environment variables from a .env file
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.0")

    // SLF4J is a logging facade that allows us to use different logging libraries
    implementation("org.slf4j:slf4j-simple:2.0.9")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}