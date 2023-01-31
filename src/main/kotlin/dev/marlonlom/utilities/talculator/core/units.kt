package dev.marlonlom.utilities.talculator.core

interface TemperatureUnitConvertible {
  fun getConverter(): TemperatureConversion
}

enum class TemperatureUnit : TemperatureUnitConvertible {
  CELSIUS {
    override fun getConverter(): TemperatureConversion = CelsiusTemperatureConversion()
  },
  FAHRENHEIT {
    override fun getConverter(): TemperatureConversion = FahrenheitTemperatureConversion()
  },
  KELVIN {
    override fun getConverter(): TemperatureConversion = KelvinTemperatureConversion()
  },
  RANKINE {
    override fun getConverter(): TemperatureConversion = RankineTemperatureConversion()
  }
}
