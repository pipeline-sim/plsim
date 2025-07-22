plugins {
    kotlin("plugin.spring")
    kotlin("plugin.allopen")
    id("io.spring.dependency-management")
}

dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))
    
    implementation("org.springframework:spring-context")
    implementation("org.springframework:spring-tx")
}
