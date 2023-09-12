import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.lab1.components.Navigation

class TextInput {
    companion object {
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
                        ) {
                            Text(modifier = Modifier.padding(10.dp), text = "Введіть текст:")
                            BasicTextField(
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
