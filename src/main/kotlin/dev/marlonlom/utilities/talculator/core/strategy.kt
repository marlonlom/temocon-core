package dev.marlonlom.utilities.talculator.core

private fun Double.roundToTwoDecimals() = "%.2f".format(this).toDouble()

interface TemperatureConversion {
  val from: TemperatureUnit
  fun calculate(valueToConvert: Double): TemperatureConvertResponse
}

class CelsiusTemperatureConversion : TemperatureConversion {
  override val from = TemperatureUnit.CELSIUS
  override fun calculate(valueToConvert: Double): TemperatureConvertResponse = TemperatureConvertResponse(
    celsiusValue = valueToConvert.roundToTwoDecimals(),
    fahrenheitValue = (((9 / 5) * valueToConvert) + 32.0).roundToTwoDecimals(),
    kelvinValue = (valueToConvert + 273.15).roundToTwoDecimals(),
    rankineValue = ((1.8 * (valueToConvert + 273.15))).roundToTwoDecimals()
  )
}

class FahrenheitTemperatureConversion : TemperatureConversion {
  override val from = TemperatureUnit.FAHRENHEIT
  override fun calculate(valueToConvert: Double): TemperatureConvertResponse = TemperatureConvertResponse(
    celsiusValue = (((valueToConvert - 32.0) * 5) / 9).roundToTwoDecimals(),
    fahrenheitValue = valueToConvert.roundToTwoDecimals(),
    kelvinValue = (((valueToConvert + 459.67) * 5) / 9).roundToTwoDecimals(),
    rankineValue = (valueToConvert + 459.67).roundToTwoDecimals()
  )
}

class KelvinTemperatureConversion : TemperatureConversion {
  override val from = TemperatureUnit.KELVIN
  override fun calculate(valueToConvert: Double): TemperatureConvertResponse = TemperatureConvertResponse(
    celsiusValue = (valueToConvert - 273.15).roundToTwoDecimals(),
    fahrenheitValue = ((((9 * valueToConvert)) / 5) - 459.67).roundToTwoDecimals(),
    kelvinValue = valueToConvert.roundToTwoDecimals(),
    rankineValue = (((9 * valueToConvert)) / 5).roundToTwoDecimals()
  )
}

class RankineTemperatureConversion : TemperatureConversion {
  override val from = TemperatureUnit.RANKINE
  override fun calculate(valueToConvert: Double): TemperatureConvertResponse = TemperatureConvertResponse(
    celsiusValue = (((valueToConvert - 491.67) * 5) / 9).roundToTwoDecimals(),
    fahrenheitValue = (valueToConvert - 459.67).roundToTwoDecimals(),
    kelvinValue = ((valueToConvert * 5) / 9).roundToTwoDecimals(),
    rankineValue = valueToConvert.roundToTwoDecimals()
  )
}
