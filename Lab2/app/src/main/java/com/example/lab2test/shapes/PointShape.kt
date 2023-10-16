package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

class PointShape(
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

    override fun draw(canvas: Canvas) {
        paint.color = paint.color
        canvas.drawOval(RectF(endX - 5f, endY - 5f, endX + 5f, endY + 5f), paint)
    }

    override fun update(newEndX: Float, newEndY: Float) {
        endX = newEndX
        endY = newEndY
    }
}
