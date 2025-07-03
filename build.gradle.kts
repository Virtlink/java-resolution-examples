plugins {
    java
    alias(libs.plugins.kotlin.jvm)
}

group = "net.pelsmaeker"
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
    jvmToolchain(17)
}