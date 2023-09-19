package com.example.lab1

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import com.example.lab1.components.GroupSelector

class Work1 {
    var isGroupListVisible by mutableStateOf(false)
    private var groupValue by mutableStateOf("")

    private fun onGroupSelected(newValue: String) {
        groupValue = newValue
        isGroupListVisible = false
    }

    @Composable
    fun Content() {
        if (isGroupListVisible) {
            GroupSelector.GroupsDialog(showDialog = isGroupListVisible) { newValue ->
                onGroupSelected(newValue)
            }
        }

        if (groupValue.isNotEmpty()) {
            Text(fontSize = 20.sp, text = "Обрана група")
            Text(fontSize = 20.sp, text = groupValue)
        }
    }
}
