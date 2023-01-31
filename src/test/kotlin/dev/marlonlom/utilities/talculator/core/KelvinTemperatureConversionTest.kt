package dev.marlonlom.utilities.talculator.core

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
