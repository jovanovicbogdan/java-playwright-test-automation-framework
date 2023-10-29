plugins {
    id("application")
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "dev.bogdanjovanovic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("org.junit.platform:junit-platform-launcher:1.10.0")

    implementation("com.microsoft.playwright:playwright:1.38.0")
    implementation("com.google.code.gson:gson:2.10.1")
}

application {
    mainClass.set("dev.bogdanjovanovic.Application")
}

// Usage: ./gradlew playwright --args="help"
tasks.register<JavaExec>("playwright") {
    classpath(sourceSets["test"].runtimeClasspath)
    mainClass.set("com.microsoft.playwright.CLI")
}

tasks.test {
    val browser = System.getProperty("browser") ?: "chromium"
    systemProperty("browser", browser)

    val headless = System.getProperty("headless") ?: "true"
    systemProperty("headless", headless)

    useJUnitPlatform() {
        val includeTags = System.getProperty("includeTags")
        val excludeTags = System.getProperty("excludeTags")

        includeTags?.split(',')?.let {
            includeTags(*it.toTypedArray())
        }

        excludeTags?.split(',')?.let {
            excludeTags(*it.toTypedArray())
        }
    }

    testLogging {
        events("passed", "skipped", "failed")
    }
}
