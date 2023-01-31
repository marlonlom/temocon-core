import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.7.10"
  id("org.jetbrains.dokka") version "1.7.10"
}

group = "dev.marlonlom.utilities"
version = "1.0.0"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}

tasks {
  val sourcesJar by creating(Jar::class) {
    dependsOn(JavaPlugin.CLASSES_TASK_NAME)
    from(sourceSets.main.get().allSource)
    archiveClassifier.set("sources")
  }

  val javadocJar by creating(Jar::class) {
    val javadoc by tasks
    from(javadoc)
    archiveClassifier.set("javadoc")
  }

  artifacts {
    add("archives", sourcesJar)
    add("archives", javadocJar)
  }
}

