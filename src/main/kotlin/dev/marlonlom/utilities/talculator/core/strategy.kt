package dev.marlonlom.utilities.talculator.core

/**
 * Performs double value rounding to two decimals.
 * @author marlonlom
 * @since 1.0.0
 *
 * @return A Double value formatted with two decimals.
 */
private fun Double.roundToTwoDecimals() = "%.2f".format(this).toDouble()

/**
 * Definition interface for temperature unit conversion feature.
 * @author marlonlom
 * @since 1.0.0
 *
 * @property from Temperature unit for be used in conversion calculations.
 */
interface TemperatureConversion {
  /**
   * Temperature unit for be used in conversion calculations.
   * @author marlonlom
   * @since 1.0.0
   */
  val from: TemperatureUnit

  /**
   * Performs temperature conversion calculations using selected unit.
   * @author marlonlom
   * @since 1.0.0
   *
   * @param valueToConvert Numeric temperature value to be used
   * @return A temperature conversion response.
   */
  fun calculate(valueToConvert: Double): TemperatureConvertResponse
}

/**
 * Interface implementation for Celsius temperature unit conversion feature.
 * @author marlonlom
 * @since 1.0.0
 * @constructor Constructs definition implementation class.
 */
class CelsiusTemperatureConversion : TemperatureConversion {
  override val from = TemperatureUnit.CELSIUS
  override fun calculate(valueToConvert: Double): TemperatureConvertResponse = TemperatureConvertResponse(
    celsiusValue = valueToConvert.roundToTwoDecimals(),
    fahrenheitValue = ((valueToConvert * 1.8) + 32.0).roundToTwoDecimals(),
    kelvinValue = (valueToConvert + 273.15).roundToTwoDecimals(),
    rankineValue = ((1.8 * (valueToConvert + 273.15))).roundToTwoDecimals()
  )
}

/**
 * Interface implementation for Fahrenheit temperature unit conversion feature.
 * @author marlonlom
 * @since 1.0.0
 * @constructor Constructs definition implementation class.
 */
class FahrenheitTemperatureConversion : TemperatureConversion {
  override val from = TemperatureUnit.FAHRENHEIT
  override fun calculate(valueToConvert: Double): TemperatureConvertResponse = TemperatureConvertResponse(
    celsiusValue = (((valueToConvert - 32.0) * 5) / 9).roundToTwoDecimals(),
    fahrenheitValue = valueToConvert.roundToTwoDecimals(),
    kelvinValue = (((valueToConvert + 459.67) * 5) / 9).roundToTwoDecimals(),
    rankineValue = (valueToConvert + 459.67).roundToTwoDecimals()
  )
}

/**
 * Interface implementation for Kelvin temperature unit conversion feature.
 * @author marlonlom
 * @since 1.0.0
 * @constructor Constructs definition implementation class.
 */
class KelvinTemperatureConversion : TemperatureConversion {
  override val from = TemperatureUnit.KELVIN
  override fun calculate(valueToConvert: Double): TemperatureConvertResponse = TemperatureConvertResponse(
    celsiusValue = (valueToConvert - 273.15).roundToTwoDecimals(),
    fahrenheitValue = ((((9 * valueToConvert)) / 5) - 459.67).roundToTwoDecimals(),
    kelvinValue = valueToConvert.roundToTwoDecimals(),
    rankineValue = (((9 * valueToConvert)) / 5).roundToTwoDecimals()
  )
}

/**
 * Interface implementation for Rankine temperature unit conversion feature.
 * @author marlonlom
 * @since 1.0.0
 * @constructor Constructs definition implementation class.
 */
class RankineTemperatureConversion : TemperatureConversion {
  override val from = TemperatureUnit.RANKINE
  override fun calculate(valueToConvert: Double): TemperatureConvertResponse = TemperatureConvertResponse(
    celsiusValue = (((valueToConvert - 491.67) * 5) / 9).roundToTwoDecimals(),
    fahrenheitValue = (valueToConvert - 459.67).roundToTwoDecimals(),
    kelvinValue = ((valueToConvert * 5) / 9).roundToTwoDecimals(),
    rankineValue = valueToConvert.roundToTwoDecimals()
  )
}
