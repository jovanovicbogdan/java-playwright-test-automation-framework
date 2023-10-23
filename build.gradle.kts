plugins {
    id("application")
    id("java")
}

group = "dev.bogdanjovanovic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("org.junit.jupiter:junit-jupiter")

    implementation("com.microsoft.playwright:playwright:1.38.0")
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
