plugins {
    id("java-library")
}

dependencies {
    implementation("com.fluxninja.aperture:aperture-java:0.3.2")
    api("net.bytebuddy:byte-buddy-dep:1.12.19")
}

repositories {
    mavenCentral()
}
