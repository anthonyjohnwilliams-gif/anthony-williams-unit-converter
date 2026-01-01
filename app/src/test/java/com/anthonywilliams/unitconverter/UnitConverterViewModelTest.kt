package com.anthonywilliams.unitconverter

import org.junit.Assert.assertEquals
import org.junit.Test

class UnitConverterViewModelTest {

    @Test
    fun convert_withValidNumber_outputsFahrenheit() {
        val vm = UnitConverterViewModel()
        vm.onInputChange("0")
        vm.onConvert()
        assertEquals("32.00 °F", vm.state.value.output)
    }

    @Test
    fun convert_withInvalidNumber_outputsErrorMessage() {
        val vm = UnitConverterViewModel()
        vm.onInputChange("abc")
        vm.onConvert()
        assertEquals("Invalid number", vm.state.value.output)
    }

    @Test
    fun inputChange_clearsPreviousOutput() {
        val vm = UnitConverterViewModel()
        vm.onInputChange("0")
        vm.onConvert()
        assertEquals("32.00 °F", vm.state.value.output)

        vm.onInputChange("10")
        assertEquals("", vm.state.value.output)
    }
}
