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

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  jvmTarget = "1.8"
}

/* dokka */
val dokkaOutputDir = "$buildDir/dokka"

tasks.dokkaHtml.configure {
  outputDirectory.set(buildDir.resolve("dokka"))
}

val deleteDokkaOutputDir by tasks.register<Delete>("deleteDokkaOutputDirectory") {
  delete(dokkaOutputDir)
}
/* dokka - end */

val javadocJar = tasks.register<Jar>("javadocJar") {
  dependsOn(deleteDokkaOutputDir, tasks.dokkaHtml)
  archiveClassifier.set("javadoc")
  from(dokkaOutputDir)
}

tasks {
  val sourcesJar by creating(Jar::class) {
    dependsOn(JavaPlugin.CLASSES_TASK_NAME)
    from(sourceSets.main.get().allSource)
    archiveClassifier.set("sources")
  }

  artifacts {
    add("archives", sourcesJar)
    add("archives", javadocJar)
  }
}
