import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}

repositories {
    jcenter()
    maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/dokka/dev")
}

dependencies {
    compileOnly("org.jetbrains.dokka:dokka-core:1.4.10-dev-70")
    implementation("org.jetbrains.dokka:dokka-base:1.4.10-dev-70")
    implementation("org.jetbrains.dokka:gfm-plugin:1.4.10-dev-70")
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
