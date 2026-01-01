package com.anthonywilliams.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                UnitConverterScreen()
            }
        }
    }
}

@Composable
fun UnitConverterScreen(
    vm: UnitConverterViewModel = viewModel()
) {
    val state by vm.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Unit Converter", style = MaterialTheme.typography.headlineSmall)

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = state.input,
            onValueChange = vm::onInputChange,
            label = { Text("Value (°C)") },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("inputField")
        )

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = vm::onConvert,
            modifier = Modifier.testTag("convertButton")
        ) {
            Text("Convert to °F")
        }

        Spacer(Modifier.height(12.dp))

        Text(
            text = state.output,
            modifier = Modifier.testTag("outputText")
        )
    }
}
