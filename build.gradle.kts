import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "no.kartveit"
version = "1.0.0-SNAPSHOT"


plugins {
    java
    kotlin("jvm") version "1.3.31"
    id("com.github.johnrengelman.shadow") version "4.0.4"
}

repositories {
    mavenCentral()
}


dependencies {
    implementation(kotlin("stdlib"))
}


tasks {
    withType<Jar> {
        manifest.attributes["Main-Class"] = "BootstrapKt"
    }

    create("printVersion") {
        doLast {
            println(project.version)
        }
    }
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

}
