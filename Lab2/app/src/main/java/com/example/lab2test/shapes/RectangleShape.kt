package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

class RectangleShape (
    override var startX: Float,
    override var startY: Float,
    override var endX: Float,
    override var endY: Float
): Shape(
    startX,
    startY,
    endX,
    endY
) {
    override var paint = Paint()

    init {
        paint.strokeWidth = 10f
    }

    override fun draw(canvas: Canvas) {
        paint.style = Paint.Style.FILL
        paint.color = 0xFFFFA200.toInt()
        canvas.drawRect(startX, startY, endX, endY, paint)

        paint.style = Paint.Style.STROKE
        paint.color = 0xFF000000.toInt()
        canvas.drawRect(startX, startY, endX, endY, paint)
    }

    override fun update(newEndX: Float, newEndY: Float) {
        endX = newEndX
        endY = newEndY
    }
}
