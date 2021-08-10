// build.gradle.kts
// source: https://dzone.com/articles/getting-started-with-javalin
// I had to tweak it and gradle seemed to too

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//    val kotlinVersion = "1.4.31"
    val kotlinVersion = "1.5.21"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    application
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
//    api("io.javalin:javalin:2.8.0")
    api("io.javalin:javalin:3.13.10")
//    implementation("org.slf4j:slf4j-simple:1.7.26")
    implementation("org.slf4j:slf4j-simple:1.7.32")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")

    testImplementation("org.junit.jupiter:junit-jupiter:5.4.1")
    testImplementation("com.github.kittinunf.fuel:fuel:2.0.1")
    testImplementation("com.github.kittinunf.fuel:fuel-jackson:2.0.1")
}

repositories {
    mavenCentral()
}

//application {
    // Define the main class for the application
//    mainClassName = "ApplicationKt"
//}
// https://stackoverflow.com/questions/64749528/setter-for-mainclassname-string-is-deprecated-deprecated-in-java
application {
    mainClass.set("JavalinKt")
}
