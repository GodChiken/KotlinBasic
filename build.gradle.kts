import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
}

group = "me.masterkbh"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}

tasks.test {
    useJUnitPlatform()
}

//https://runebook.dev/ko/docs/kotlin/docs/reference/opt-in-requirements
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-opt-in=org.mylibrary.OptInAnnotation"
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}
//https://kotlinlang.org/docs/opt-in-requirements.html#experimental-status-of-the-opt-in-requirements
kotlin.sourceSets.all {
    languageSettings.optIn("kotlin.RequiresOptIn")
}

application {
    mainClass.set("MainKt")
}