package dev.marlonlom.utilities.talculator.core

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class RankineTemperatureConversionTest {

  private val converter = RankineTemperatureConversion()

  @Test
  fun shouldHaveTemperatureUnit() {
    assertEquals(TemperatureUnit.RANKINE, converter.from)
  }

  @Test
  fun shouldConvertZero() {
    val response = converter.calculate(0.0)
    assertEquals(0.0, response.rankineValue)
    assertEquals(-273.15, response.celsiusValue)
    assertEquals(-459.67, response.fahrenheitValue)
    assertEquals(0.0, response.kelvinValue)
  }
}
