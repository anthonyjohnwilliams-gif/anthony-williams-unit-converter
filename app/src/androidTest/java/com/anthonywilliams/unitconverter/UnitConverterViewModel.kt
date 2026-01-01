package com.anthonywilliams.unitconverter

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class UiState(
    val input: String = "",
    val output: String = ""
)

@HiltViewModel
class UnitConverterViewModel @Inject constructor(
    private val converter: Converter
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state

    fun onInputChange(text: String) {
        _state.update { it.copy(input = text, output = "") }
    }

    fun onConvert() {
        val value = _state.value.input.toDoubleOrNull()
        _state.update { current ->
            if (value == null) {
                current.copy(output = "Invalid number")
            } else {
                val f = converter.celsiusToFahrenheit(value)
                current.copy(output = "%.2f °F".format(f))
            }
        }
    }
}
