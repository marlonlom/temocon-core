package dev.marlonlom.utilities.talculator.core

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CelsiusTemperatureConversionTest {

  private val converter = CelsiusTemperatureConversion()

  @Test
  fun shouldHaveTemperatureUnit() {
    assertEquals(TemperatureUnit.CELSIUS, converter.from)
  }

  @Test
  fun shouldConvertZero() {
    val response = converter.calculate(0.0)
    assertEquals(0.0, response.celsiusValue)
    assertEquals(32.0, response.fahrenheitValue)
    assertEquals(273.15, response.kelvinValue)
    assertEquals(491.67, response.rankineValue)
  }
}
