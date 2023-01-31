package dev.marlonlom.utilities.talculator.core

/**
 * Data class for temperature conversion request.
 * @author marlonlom
 * @since 1.0.0
 *
 * @constructor Constructs data class.
 *
 *  @property valueToConvert Temperature numeric value to be converted.
 *  @property temperatureUnit Temperature unit enum value to be used.
 */
data class TemperatureConvertRequest(
  val valueToConvert: Double, val temperatureUnit: TemperatureUnit
)

/**
 * Data class for temperature conversion response.
 * @author marlonlom
 * @since 1.0.0
 *
 * @constructor Constructs data class.
 *
 *  @property celsiusValue Celsius response value.
 *  @property fahrenheitValue Fahrenheit response value.
 *  @property kelvinValue Kelvin response value.
 *  @property rankineValue Rankine response value.
 */
data class TemperatureConvertResponse(
  val celsiusValue: Double, val fahrenheitValue: Double, val kelvinValue: Double, val rankineValue: Double
) {

  /**
   * Returns true/false if temperature is boiling point of water.
   * @author marlonlom
   * @since 1.0.0
   * @return true/false.
   */
  fun isBoilingPointOfWater(): Boolean =
    celsiusValue.equals(100.0).and(fahrenheitValue.equals(212.00)).and(kelvinValue.equals(373.15))
      .and(rankineValue.equals(671.67))

  /**
   * Returns true/false if temperature is freezing point of water.
   * @author marlonlom
   * @since 1.0.0
   * @return true/false.
   */
  fun isFreezingPointOfWater(): Boolean =
    celsiusValue.equals(0.0).and(fahrenheitValue.equals(32.00)).and(kelvinValue.equals(273.15))
      .and(rankineValue.equals(491.67))

  /**
   * Returns true/false if temperature is absolute zero.
   * @author marlonlom
   * @since 1.0.0
   * @return true/false.
   */
  fun isAbsoluteZero(): Boolean =
    celsiusValue.equals(-273.15).and(fahrenheitValue.equals(-459.67)).and(kelvinValue.equals(0.0))
      .and(rankineValue.equals(0.0))

  /**
   * Returns true/false if temperature is room temperature.
   * @author marlonlom
   * @since 1.0.0
   * @return true/false.
   */
  fun isRoomTemperature(): Boolean =
    celsiusValue.equals(21.00).and(fahrenheitValue.equals(69.8)).and(kelvinValue.equals(294.15))
      .and(rankineValue.equals(529.47))

  /**
   * Returns true/false if temperature is average body.
   * @author marlonlom
   * @since 1.0.0
   * @return true/false.
   */
  fun isAverageBodyTemperature(): Boolean =
    celsiusValue.equals(37.00).and(fahrenheitValue.equals(98.6)).and(kelvinValue.equals(310.15))
      .and(rankineValue.equals(558.27))
}

/**
 * Main class for temperature converter utility.
 * @author marlonlom
 * @since 1.0.0
 *
 * @constructor Constructs utility class.
 */
class TemperatureConverter {
  /**
   * Performs temperature conversion calculation using the request.
   * @author marlonlom
   * @since 1.0.0
   * @param request the Conversion request.
   * @return A conversion response, that contains selected units.
   */
  fun calculate(
    request: TemperatureConvertRequest
  ): TemperatureConvertResponse = request.let {
    it.temperatureUnit.getConverter().calculate(it.valueToConvert)
  }
}
