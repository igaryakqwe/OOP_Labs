package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

class LineShape(
    startX: Float,
    startY: Float,
    endX: Float,
    endY: Float,
    color: Int
): Shape(startX, startY, endX, endY, color) {

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = color
        canvas.drawLine(startX, startY, endX, endY, paint)
    }

    override fun update(newEndX: Float, newEndY: Float, newColor: Int) {
        endX = newEndX
        endY = newEndY
        color = newColor
    }

    override fun clone(): LineShape {
        return LineShape(startX, startY, endX, endY, color)
    }
}