import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        maven(url = "https://kotlin.bintray.com/kotlinx")
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "1.3.20"))
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.3.20")
    }
}

plugins {
    kotlin("jvm") version "1.3.20"
}

apply {
    plugin("kotlinx-serialization")
}

group = "io.github.wellingtoncosta"
version = "0.0.1"

repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.10.0")
    implementation("io.ktor:ktor-server-core:1.1.2")
    implementation("io.ktor:ktor-server-netty:1.1.2")
    implementation("org.slf4j:slf4j-simple:1.7.25")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
