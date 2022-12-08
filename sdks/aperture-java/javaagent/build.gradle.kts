plugins {
    id("java")
}

dependencies {
    implementation("net.bytebuddy:byte-buddy-dep:1.12.19")

    implementation(project(":lib:core"))
}

repositories {
    mavenCentral()
}
