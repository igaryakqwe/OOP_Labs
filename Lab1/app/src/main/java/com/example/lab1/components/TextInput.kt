package com.example.lab1.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

class TextInput {
    companion object {
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun DialogInput(showDialog: Boolean, onTextChange: (String) -> Unit) {
            var showDialogState by remember { mutableStateOf(showDialog) }
            var text by remember { mutableStateOf("") }

            if (showDialogState) {
                Dialog(onDismissRequest = { showDialogState = false }) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        shape = RoundedCornerShape(16.dp),
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(modifier = Modifier.padding(10.dp), fontSize = 20.sp, text = "Введіть текст:")
                            TextField(
                                textStyle = TextStyle(
                                    fontSize = 20.sp
                                ),
                                value = text,
                                onValueChange = {
                                    text = it
                                }
                            )
                            Navigation.NavButtons(
                                onDismiss = {
                                    showDialogState = false
                                },
                                onConfirm = {
                                    onTextChange(text)
                                    showDialogState = false
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
