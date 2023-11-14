package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

class PointShape: Shape() {
    override var startX: Float = 0.0f
    override var startY: Float = 0.0f
    override var endX: Float = 0.0f
    override var endY: Float = 0.0f
    override var isTouching: Boolean = false

    override fun setStartCords (x: Float, y: Float) {
        startX = x
        startY = y
        endX = x
        endY = y
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.style = Paint.Style.STROKE
        canvas.drawOval(RectF(endX - 4f, endY - 4f, endX + 4f, endY + 4f), paint)
    }

    override fun update(newEndX: Float, newEndY: Float) {}
}
