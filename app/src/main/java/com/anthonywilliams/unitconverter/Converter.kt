package com.anthonywilliams.unitconverter

interface Converter {
    fun celsiusToFahrenheit(celsius: Double): Double
}

class DefaultConverter : Converter {
    override fun celsiusToFahrenheit(celsius: Double): Double {
        return (celsius * 9.0 / 5.0) + 32.0
    }
}