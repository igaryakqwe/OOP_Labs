import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.lab1.components.Navigation
import com.example.lab1.values.Module1

class GroupSelector() {
    companion object {
        @Composable
        fun GroupsDialog(showDialog: Boolean, onValueChange: (String) -> Unit) {
            var value by remember { mutableStateOf<String>("") }
            var selectedGroupName by remember { mutableStateOf<String?>(null) }
            var showDialogState by remember { mutableStateOf(showDialog) }

            if (showDialogState) {
                Dialog(onDismissRequest = { showDialogState = false }) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(1f)
                            .padding(16.dp),
                        shape = RoundedCornerShape(16.dp),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(modifier = Modifier.padding(10.dp), text = "Оберіть групу:")
                            GroupList(Module1.groups, selectedGroupName) { newValue ->
                                selectedGroupName = newValue
                            }
                            Navigation.NavButtons(
                                onDismiss = {
                                    showDialogState = false
                                    selectedGroupName = null
                                }
                            ) {
                                selectedGroupName?.let {
                                    onValueChange(it)
                                }
                                showDialogState = false
                            }
                        }
                    }
                }
            }
        }

        @Composable
        private fun GroupList(groupList: List<String>, selectedGroupName: String?, onValueChange: (String) -> Unit) {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(600.dp),
            ) {
                items(groupList) { groupName ->
                    val isSelected = groupName == selectedGroupName
                    Button(
                        onClick = { onValueChange(groupName) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor =
                            if (isSelected) {
                                MaterialTheme.colorScheme.background
                            } else {
                                MaterialTheme.colorScheme.primary
                            },
                            contentColor =
                            if (isSelected) {
                                MaterialTheme.colorScheme.onBackground
                            } else {
                                MaterialTheme.colorScheme.onPrimary
                            },
                        )
                    ) {
                        Text(text = groupName)
                    }
                }
            }
        }
    }
}
