package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

class RectangleShape (
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
        canvas.drawRect(startX, startY, endX, endY, paint)
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