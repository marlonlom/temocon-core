# talculator-core
Utility library for handling temperature conversion between Celsius, Fahrenheit, Kelvin, Rankine units, and providing the results in all of these units for general usage.

## Using in your projects

### Maven

Add dependencies (you can also add other modules that you need):

```xml
<dependency>
    <groupId>dev.marlonlom.utilities</groupId>
    <artifactId>talculator-core</artifactId>
    <version>${talculator_core.latestVersion}</version>
</dependency>
```

And make sure that you use the latest Kotlin version:

```xml
<properties>
    <kotlin.version>1.7.10</kotlin.version>
</properties>
```

### Gradle

Add dependencies (you can also add other modules that you need):

```kotlin
dependencies {
    implementation("dev.marlonlom.utilities:talculator-core:${talculator_core.latestVersion}")
}
```

And make sure that you use the latest Kotlin version:

```kotlin
plugins {
    // For build.gradle.kts (Kotlin DSL)
    kotlin("jvm") version "1.7.10"
    
    // For build.gradle (Groovy DSL)
    id "org.jetbrains.kotlin.jvm" version "1.7.10"
}
```

Make sure that you have `mavenCentral()` in the list of repositories:

```kotlin
repositories {
    mavenCentral()
}
```

## Quick Start
TBD


## License

This software is distributed under the terms of the [MIT license](LICENSE).

```
MIT license

Copyright 2023 Marlonlom

Use of this source code is governed by an MIT-style
license that can be found in the LICENSE file or at
https://opensource.org/licenses/MIT.

```
