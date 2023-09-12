package com.example.lab1

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue

class Work2 {
    var isTextInputVisible by mutableStateOf(false)
    private var inputValue by mutableStateOf(TextFieldValue(""))

    private fun onInputTextChanged(newValue: String) {
        inputValue = TextFieldValue(newValue)
        isTextInputVisible = false
    }

    @Composable
    fun Content() {
        if (isTextInputVisible) {
            TextInput.DialogInput(showDialog = isTextInputVisible) { newValue ->
                onInputTextChanged(newValue)
            }
        }

        if (inputValue.text.isNotEmpty()) {
            Text(text = "Введений текст")
            Text(text = inputValue.text)
        }
    }
}
