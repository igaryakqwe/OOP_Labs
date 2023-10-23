package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

class EllipseShape (
    override var startX: Float,
    override var startY: Float,
    override var endX: Float,
    override var endY: Float,
): Shape(
    startX,
    startY,
    endX,
    endY,
) {
    override var paint = Paint()

    init {
        paint.strokeWidth = 10f
    }

    override fun draw(canvas: Canvas, color: Int) {
        paint.style = Paint.Style.STROKE
        paint.color = color
        canvas.drawOval(startX, startY, endX, endY, paint)
    }

    override fun update(newEndX: Float, newEndY: Float) {
        endX = newEndX
        endY = newEndY
    }
}
