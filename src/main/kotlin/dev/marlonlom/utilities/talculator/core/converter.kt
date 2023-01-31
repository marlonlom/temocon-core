package dev.marlonlom.utilities.talculator.core

/**
 * Data class for temperature conversion request.
 * @author marlonlom
 *
 * @constructor Constructs data class.
 *
 *  @property valueToConvert temperature numeric value to be converted.
 *  @property temperatureUnit temperature unit enum value to be used.
 */
data class TemperatureConvertRequest(
  val valueToConvert: Double, val temperatureUnit: TemperatureUnit
)

/**
 * Data class for temperature conversion response.
 * @author marlonlom
 *
 * @constructor Constructs data class.
 *
 *  @property celsiusValue celsius response value.
 *  @property fahrenheitValue fahrenheit response value.
 *  @property kelvinValue kelvin response value.
 *  @property rankineValue rankine response value.
 */
data class TemperatureConvertResponse(
  val celsiusValue: Double, val fahrenheitValue: Double, val kelvinValue: Double, val rankineValue: Double
) {

  /**
   * Returns if temperature is boiling point of water.
   * @return true/false.
   */
  fun isBoilingPointOfWater(): Boolean =
    celsiusValue.equals(100.0).and(fahrenheitValue.equals(212.00)).and(kelvinValue.equals(373.15))
      .and(rankineValue.equals(671.67))

  /**
   * Returns if temperature is freezing point of water.
   * @return true/false.
   */
  fun isFreezingPointOfWater(): Boolean =
    celsiusValue.equals(0.0).and(fahrenheitValue.equals(32.00)).and(kelvinValue.equals(273.15))
      .and(rankineValue.equals(491.67))

  /**
   * Returns if temperature is absolute zero.
   * @return true/false.
   */
  fun isAbsoluteZero(): Boolean =
    celsiusValue.equals(-273.15).and(fahrenheitValue.equals(-459.67)).and(kelvinValue.equals(0.0))
      .and(rankineValue.equals(0.0))

  /**
   * Returns if temperature is room temperature.
   * @return true/false.
   */
  fun isRoomTemperature(): Boolean =
    celsiusValue.equals(21.00).and(fahrenheitValue.equals(69.8)).and(kelvinValue.equals(294.15))
      .and(rankineValue.equals(529.47))

  /**
   * Returns if temperature is average body.
   * @return true/false.
   */
  fun isAverageBodyTemperature(): Boolean =
    celsiusValue.equals(37.00).and(fahrenheitValue.equals(98.6)).and(kelvinValue.equals(310.15))
      .and(rankineValue.equals(558.27))
}

/**
 * Main class for temperature converter utility.
 * @author marlonlom
 *
 * @constructor Constructs utility class.
 */
class TemperatureConverter {
  /**
   * Performs temperature conversion calculation using the request.
   * @param request conversion request.
   * @return conversion response, that contains selected units.
   */
  fun calculate(
    request: TemperatureConvertRequest
  ): TemperatureConvertResponse = request.let {
    it.temperatureUnit.getConverter().calculate(it.valueToConvert)
  }
}
