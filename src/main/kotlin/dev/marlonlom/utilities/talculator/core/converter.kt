package dev.marlonlom.utilities.talculator.core

data class TemperatureConvertRequest(
  val valueToConvert: Double,
  val temperatureUnit: TemperatureUnit
)

data class TemperatureConvertResponse(
  val celsiusValue: Double,
  val fahrenheitValue: Double,
  val kelvinValue: Double,
  val rankineValue: Double
)

class TemperatureConverter {
  fun calculate(request: TemperatureConvertRequest): TemperatureConvertResponse =
    request.temperatureUnit.getConverter().calculate(request.valueToConvert)
}
