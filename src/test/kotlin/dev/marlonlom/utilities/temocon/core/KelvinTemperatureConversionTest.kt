/*
 * Copyright 2023 Marlonlom
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
*/
package dev.marlonlom.utilities.temocon.core

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class KelvinTemperatureConversionTest {

  private val converter = KelvinTemperatureConversion()

  @Test
  fun shouldHaveTemperatureUnit() {
    assertEquals(TemperatureUnit.KELVIN, converter.from)
  }

  @Test
  fun shouldConvertZero() {
    val response = converter.calculate(0.0)
    assertEquals(-273.15, response.celsiusValue)
    assertEquals(-459.67, response.fahrenheitValue)
    assertEquals(0.0, response.kelvinValue)
    assertEquals(0.0, response.rankineValue)
  }
}
