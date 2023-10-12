package com.example.lab2test.editors

import android.graphics.Paint
import android.view.MotionEvent
import com.example.lab2test.CanvasView
import com.example.lab2test.shapes.Shape

abstract class Editor() {
    abstract fun touchDown(event: MotionEvent)
    abstract fun touchMove(event: MotionEvent)
    abstract fun touchUp(event: MotionEvent)
}