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

  fun isFreezingPointOfWater(): Boolean = celsiusValue.equals(0.0)
    .and(fahrenheitValue.equals(32.00))
    .and(kelvinValue.equals(273.15))
    .and(rankineValue.equals(491.67))

  fun isAbsoluteZero(): Boolean = celsiusValue.equals(-273.15)
    .and(fahrenheitValue.equals(-459.67))
    .and(kelvinValue.equals(0.0))
    .and(rankineValue.equals(0.0))

  fun isRoomTemperature(): Boolean = celsiusValue.equals(21.00)
    .and(fahrenheitValue.equals(69.8))
    .and(kelvinValue.equals(294.15))
    .and(rankineValue.equals(529.47))

  fun isAverageBodyTemperature(): Boolean = celsiusValue.equals(37.00)
    .and(fahrenheitValue.equals(98.6))
    .and(kelvinValue.equals(310.15))
    .and(rankineValue.equals(558.27))
}

class TemperatureConverter {
  fun calculate(request: TemperatureConvertRequest): TemperatureConvertResponse =
    request.let {
      it.temperatureUnit.getConverter().calculate(it.valueToConvert)
    }
}
