plugins {
    kotlin("jvm") version "1.8.21"
    application
    id("app.cash.sqldelight") version "2.0.0-rc01"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("org.example")
            dialect("app.cash.sqldelight:postgresql-dialect:2.0.0-rc01")
            deriveSchemaFromMigrations.set(true)
            srcDirs("src/main/timestamp")
//            srcDirs("src/main/int")
        }
    }
}