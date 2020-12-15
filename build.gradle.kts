import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    application
}

group = "me.letsding"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
repositories {
    maven {
        // Look for POMs and artifacts, such as JARs, here
        url = uri("http://packages.confluent.io/maven/")
        // Look for artifacts here if not found at the above location
//        artifactUrls("http://repo.mycompany.com/jars")
//        artifactUrls("http://repo.mycompany.com/jars2")
    }
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    //    testImplementation("io.mockk:mockk:{1.10.3-jdk8}")

    // https://mvnrepository.com/artifact/org.apache.kafka/kafka
    implementation("org.apache.kafka:kafka_2.13:2.6.0")

    // https://mvnrepository.com/artifact/io.confluent/kafka-avro-serializer
    implementation("io.confluent:kafka-avro-serializer:6.0.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}