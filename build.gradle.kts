plugins {
	kotlin("jvm") version "1.9.25" apply false
	kotlin("plugin.spring") version "1.9.25" apply false
	kotlin("plugin.jpa") version "1.9.25" apply false
	kotlin("plugin.allopen") version "1.9.25" apply false
	id("org.springframework.boot") version "3.5.3" apply false
	id("io.spring.dependency-management") version "1.1.7" apply false
}

extra["kotlinVersion"] = "1.9.25"

allprojects {
	group = "com"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs += "-Xjsr305=strict"
			jvmTarget = "17"
		}
	}

	dependencies {
		val implementation by configurations
		val testImplementation by configurations
		val testRuntimeOnly by configurations

		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

		testImplementation("org.junit.jupiter:junit-jupiter")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}

	tasks.register("prepareKotlinBuildScriptModel") {}
}