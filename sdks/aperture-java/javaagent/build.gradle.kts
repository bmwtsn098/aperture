plugins {
    id("java")
    id("com.github.johnrengelman.shadow")
}

tasks.jar {
    manifest {
        attributes["Premain-Class"] = "com.fluxninja.aperture.instrumentation.ApertureInstrumentationAgent"
    }
}

tasks.shadowJar {
    archiveBaseName.set("agent")
    archiveClassifier.set("")

    relocate("javassist", "com.exmaple.javassist")
}

dependencies {
    implementation("net.bytebuddy:byte-buddy-dep:1.12.19")
    implementation("org.slf4j:log4j-over-slf4j:2.0.6")

    implementation(project(":lib:core"))
}

repositories {
    mavenCentral()
}
