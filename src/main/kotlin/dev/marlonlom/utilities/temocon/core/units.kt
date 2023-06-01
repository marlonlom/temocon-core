/*
 * Copyright 2023 Marlonlom
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 *
*/
package dev.marlonlom.utilities.temocon.core

/**
 * Definition interface for temperature unit convertible values.
 * @author marlonlom
 * @since 1.0.0
 */
interface TemperatureUnitConvertible {
  /**
   * Returns a defined temperature converter the selected unit.
   * @return a specified temperature conversion from strategy.
   * @author marlonlom
   * @since 1.0.0
   */
  fun getConverter(): TemperatureConversion
}

/**
 * Enum definition for temperature units for conversion.
 * @author marlonlom
 * @since 1.0.0
 */
enum class TemperatureUnit : TemperatureUnitConvertible {
  /**
   * Celsius temperature unit enum value.
   * @author marlonlom
   * @since 1.0.0
   */
  CELSIUS {
    override fun getConverter(): TemperatureConversion = CelsiusTemperatureConversion()
  },

  /**
   * Fahrenheit temperature unit enum value.
   * @author marlonlom
   * @since 1.0.0
   */
  FAHRENHEIT {
    override fun getConverter(): TemperatureConversion = FahrenheitTemperatureConversion()
  },

  /**
   * Kelvin temperature unit enum value.
   * @author marlonlom
   * @since 1.0.0
   */
  KELVIN {
    override fun getConverter(): TemperatureConversion = KelvinTemperatureConversion()
  },

  /**
   * Rankine temperature unit enum value.
   * @author marlonlom
   * @since 1.0.0
   */
  RANKINE {
    override fun getConverter(): TemperatureConversion = RankineTemperatureConversion()
  }
}
