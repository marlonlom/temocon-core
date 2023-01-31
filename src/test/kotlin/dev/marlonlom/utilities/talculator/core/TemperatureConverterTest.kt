package dev.marlonlom.utilities.talculator.core

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class TemperatureConverterTest {
  private val converter = TemperatureConverter()

  @Test
  fun shouldCalculateTemperatureForZeroCelsius() {
    val request = TemperatureConvertRequest(0.0, TemperatureUnit.CELSIUS)
    val response = converter.calculate(request)
    assertEquals(request.valueToConvert, response.celsiusValue)
    assertEquals(32.0, response.fahrenheitValue)
    assertEquals(273.15, response.kelvinValue)
    assertEquals(491.67, response.rankineValue)
  }

  @Test
  fun shouldCalculateTemperatureForNegativeTenFahrenheit() {
    val request = TemperatureConvertRequest(-10.0, TemperatureUnit.FAHRENHEIT)
    val response = converter.calculate(request)
    assertEquals(-23.33, response.celsiusValue)
    assertEquals(request.valueToConvert, response.fahrenheitValue)
    assertEquals(249.82, response.kelvinValue)
    assertEquals(449.67, response.rankineValue)
  }

  @Test
  fun shouldCalculateTemperatureForOneThousandKelvin() {
    val request = TemperatureConvertRequest(1000.0, TemperatureUnit.KELVIN)
    val response = converter.calculate(request)
    assertEquals(726.85, response.celsiusValue)
    assertEquals(1340.33, response.fahrenheitValue)
    assertEquals(request.valueToConvert, response.kelvinValue)
    assertEquals(1800.0, response.rankineValue)
  }

  @Test
  fun shouldCalculateTemperatureForThreeThousandRankine() {
    val request = TemperatureConvertRequest(300.0, TemperatureUnit.RANKINE)
    val response = converter.calculate(request)
    assertEquals(-106.48, response.celsiusValue)
    assertEquals(-159.67, response.fahrenheitValue)
    assertEquals(166.67, response.kelvinValue)
    assertEquals(request.valueToConvert, response.rankineValue)
  }

  @Test
  fun shouldCalculateBoilingPointOfWater() {
    val request = TemperatureConvertRequest(100.0, TemperatureUnit.CELSIUS)
    val response = converter.calculate(request)
    assertEquals(request.valueToConvert, response.celsiusValue)
    assertEquals(212.0, response.fahrenheitValue)
    assertEquals(373.15, response.kelvinValue)
    assertEquals(671.67, response.rankineValue)
    assertTrue(response.isBoilingPointOfWater())
  }

  @Test
  fun shouldCalculateAbsoluteZero() {
    val request = TemperatureConvertRequest(-459.67, TemperatureUnit.FAHRENHEIT)
    val response = converter.calculate(request)
    assertEquals(-273.15, response.celsiusValue)
    assertEquals(request.valueToConvert, response.fahrenheitValue)
    assertEquals(0.0, response.kelvinValue)
    assertEquals(0.0, response.rankineValue)
    assertTrue(response.isAbsoluteZero())
  }

  @Test
  fun shouldCalculateRoomTemperature() {
    val request = TemperatureConvertRequest(529.47, TemperatureUnit.RANKINE)
    val response = converter.calculate(request)
    assertEquals(21.00, response.celsiusValue)
    assertEquals(69.8, response.fahrenheitValue)
    assertEquals(294.15, response.kelvinValue)
    assertEquals(request.valueToConvert, response.rankineValue)
    assertTrue(response.isRoomTemperature())
  }
}
