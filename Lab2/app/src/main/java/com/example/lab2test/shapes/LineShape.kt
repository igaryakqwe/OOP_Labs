package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

class LineShape(
    startX: Float,
    startY: Float,
    endX: Float,
    endY: Float,
): Shape(
    startX,
    startY,
    endX,
    endY,
) {
    override var paint = Paint()

    init {
        paint.strokeWidth = 10f
        paint.color = 0xFF0000FF.toInt()
    }

    override fun draw(canvas: Canvas) {
        canvas.drawLine(startX, startY, endX, endY, paint)
    }

    override fun update(newEndX: Float, newEndY: Float) {
        endX = newEndX
        endY = newEndY
    }
}
