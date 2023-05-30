# temocon-core

[![CodeFactor](https://www.codefactor.io/repository/github/marlonlom/temocon-core/badge/main)](https://www.codefactor.io/repository/github/marlonlom/temocon-core/overview/main)

Utility library for handling temperature conversion between Celsius, Fahrenheit, Kelvin, Rankine units, and providing the results in all of these units for general usage.


## Adding the library in your projects

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


## How to use the library
The following is a step-by-step for executing a temperature conversion calculation using a provided numeric value and temperature unit:

1. Construct the temperature conversion request, it must have the value (as double) to convert and the prefered unit (Celsius, Fahrenheit, Kelvin, Rankine).
```kotlin
val request = TemperatureConvertRequest(21.00, TemperatureUnit.CELSIUS)
```

2. Construct the temperature converter instance.
```kotlin
val converter = TemperatureConverter()
```

3. Use the converter instance to perform calculation using the provided request.
```kotlin
val response = converter.calculate(request)
```

4. Use the response and get the temperature values for selected units.
```kotlin
println("response=$response") 
/* 
  prints: response=TemperatureConvertResponse(celsiusValue=21.0, fahrenheitValue=69.8, kelvinValue=294.15, rankineValue=529.47) 
*/
```


## License

This software is distributed under the terms of the [MIT license](LICENSE).

```
MIT license

Copyright 2023 Marlonlom

Use of this source code is governed by an MIT-style
license that can be found in the LICENSE file or at
https://opensource.org/licenses/MIT.

```
