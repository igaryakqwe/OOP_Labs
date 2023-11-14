package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

class EllipseShape: Shape() {
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
        val dx = 2 * startX - endX
        val dy = 2 * startY - endY

        canvas.drawOval(dx, dy, endX, endY, paint)
    }

    override fun update(newEndX: Float, newEndY: Float) {
        endX = newEndX
        endY = newEndY
    }
}
