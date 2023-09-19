package com.example.lab1.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Navigation {
    companion object {
        @Composable
        fun NavButtons(onDismiss: () -> Unit, onConfirm: () -> Unit) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                TextButton(
                    onClick = { onDismiss() },
                    modifier = Modifier.padding(8.dp),
                ) {
                    Text(fontSize = 17.sp, text = "Відміна")
                }
                TextButton(
                    onClick = { onConfirm() },
                    modifier = Modifier.padding(8.dp),
                ) {
                    Text(fontSize = 17.sp, text = "Так")
                }
            }
        }
    }
}
