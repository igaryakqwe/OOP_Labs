package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    private val work1 = Work1()
    private val work2 = Work2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(text = "Лабораторна робота №1")
                    Row {
                        Button(
                            onClick = { work1.isGroupListVisible = !work1.isGroupListVisible },
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = "Робота 1")
                        }
                        Button(
                            onClick = { work2.isTextInputVisible = !work2.isTextInputVisible },
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = "Робота 2")
                        }
                    }

                    work1.Content()

                    work2.Content()
                }
            }
        }
    }
}
