package com.example.lab2test.editors

import android.graphics.Paint
import android.view.MotionEvent
import com.example.lab2test.shapes.LineShape
import com.example.lab2test.CanvasView

class LineEditor(): Editor() {
    private val paint = Paint()
    private var startX = 0f
    private var startY = 0f
    private var endX = 0f
    private var endY = 0f
    private var isTouching = false

    init {
        paint.strokeWidth = 10f
    }

    override fun touchDown(event: MotionEvent) {
    }

    override fun touchMove(event: MotionEvent) {
    }

    override fun touchUp(event: MotionEvent) {
    }


}