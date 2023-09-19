package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    private val work1 = Work1()
    private val work2 = Work2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        modifier = Modifier.size(300.dp, 60.dp),
                        lineHeight = 30.sp,
                        textAlign = TextAlign.Center,
                        fontSize = 26.sp,
                        text = "Лабораторна робота №1"
                    )
                    Row {
                        Button(
                            onClick = {
                                work1.isGroupListVisible = !work1.isGroupListVisible
                            },
                            modifier = Modifier.padding(16.dp).size(128.dp, 50.dp)
                        ) {
                            Text(
                                fontSize = 18.sp,
                                text = "Робота 1"
                            )
                        }
                        Button(
                            onClick = {
                                work2.isTextInputVisible = !work2.isTextInputVisible
                            },
                            modifier = Modifier.padding(16.dp).size(128.dp, 50.dp)
                        ) {
                            Text(
                                fontSize = 18.sp,
                                text = "Робота 2"
                            )
                        }
                    }

                    work1.Content()

                    work2.Content()
                }
            }
        }
    }
}
