package com.anthonywilliams.unitconverter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class UiState(
    val input: String = "",
    val output: String = ""
)

class UnitConverterViewModel(
    private val converter: Converter = DefaultConverter()
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state

    fun onInputChange(text: String) {
        _state.update { it.copy(input = text, output = "") }
    }

    fun onConvert() {
        val value = _state.value.input.toDoubleOrNull()
        _state.update {
            if (value == null) it.copy(output = "Invalid number")
            else it.copy(output = "%.2f °F".format(converter.celsiusToFahrenheit(value)))
        }
    }
}
