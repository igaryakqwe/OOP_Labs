package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

class RectangleShape (
    override var startX: Float,
    override var startY: Float,
    override var endX: Float,
    override var endY: Float,
    private val isTouching: Boolean
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

    override fun draw(canvas: Canvas, color: Int) {
        val dx = 2 * startX - endX
        val dy = 2 * startY - endY

        paint.style = Paint.Style.FILL
        paint.color = 0xFF7D7C7C.toInt()
        canvas.drawRect(dx, dy, endX, endY, paint)

        paint.style = Paint.Style.STROKE
        paint.color = color
        canvas.drawRect(dx, dy, endX, endY, paint)
    }

    override fun update(newEndX: Float, newEndY: Float) {
        endX = newEndX
        endY = newEndY
    }
}
