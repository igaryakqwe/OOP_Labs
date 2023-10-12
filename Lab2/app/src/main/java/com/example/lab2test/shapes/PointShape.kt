package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

class PointShape(
    override var startX: Float,
    override var startY: Float,
    override var endX: Float,
    override var endY: Float,
    override var color: Int
): Shape(
    startX,
    startY,
    endX,
    endY,
    color
) {
    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = color
        canvas.drawOval(RectF(endX - 5f, endY - 5f, endX + 5f, endY + 5f), paint)
    }

    override fun update(newEndX: Float, newEndY: Float, newColor: Int) {
        endX = newEndX
        endY = newEndY
        color = newColor
    }

    override fun clone(): PointShape {
        return PointShape(startX, startY, endX, endY, color)
    }

}