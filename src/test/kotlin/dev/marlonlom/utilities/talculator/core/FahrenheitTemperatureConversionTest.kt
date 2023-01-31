/*
 * Copyright 2023 Marlonlom
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
*/
package dev.marlonlom.utilities.talculator.core

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class FahrenheitTemperatureConversionTest {

  private val converter = FahrenheitTemperatureConversion()

  @Test
  fun shouldHaveTemperatureUnit() {
    assertEquals(TemperatureUnit.FAHRENHEIT, converter.from)
  }

  @Test
  fun shouldConvertZero() {
    val response = converter.calculate(0.0)
    assertEquals(-17.78, response.celsiusValue)
    assertEquals(0.0, response.fahrenheitValue)
    assertEquals(255.37, response.kelvinValue)
    assertEquals(459.67, response.rankineValue)
  }
}
