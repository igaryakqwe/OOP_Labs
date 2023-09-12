package com.example.lab1

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

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
            Text(text = "Обрана група")
            Text(text = groupValue)
        }
    }
}
