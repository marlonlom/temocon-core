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
) {

  fun isBoilingPointOfWater(): Boolean = celsiusValue.equals(100.0)
    .and(fahrenheitValue.equals(212.00))
    .and(kelvinValue.equals(373.15))
    .and(rankineValue.equals(671.67))
}

class TemperatureConverter {
  fun calculate(request: TemperatureConvertRequest): TemperatureConvertResponse =
    request.let {
      it.temperatureUnit.getConverter().calculate(it.valueToConvert)
    }
}
