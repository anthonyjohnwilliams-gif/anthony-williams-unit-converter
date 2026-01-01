package com.anthonywilliams.unitconverter

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

class UnitConverterViewModelMockkTest {

    @Test
    fun convert_usesConverterDependency() {
        val converter = mockk<Converter>()
        every { converter.celsiusToFahrenheit(0.0) } returns 32.0

        val vm = UnitConverterViewModel(converter)

        vm.onInputChange("0")
        vm.onConvert()

        assertEquals("32.00 °F", vm.state.value.output)
    }
}
