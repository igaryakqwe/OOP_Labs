package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

class RectangleShape: Shape() {
    override var startX: Float = 0.0f
    override var startY: Float = 0.0f
    override var endX: Float = 0.0f
    override var endY: Float = 0.0f
    override var isTouching: Boolean = false
    var isCube: Boolean = false

    private var fillPaint: Paint = Paint()
    private var strokePaint: Paint = Paint()

    init {
        fillPaint.style = Paint.Style.FILL
        fillPaint.strokeWidth = 8f
        fillPaint.color = 0xFF757b7d.toInt()

        strokePaint.style = Paint.Style.STROKE
        strokePaint.strokeWidth = 8f
        strokePaint.color = 0xFF000000.toInt()
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        if (!isTouching) {
            canvas.drawRect(startX, startY, endX, endY, paint)
            if (!isCube) {
                canvas.drawRect(startX, startY, endX, endY, fillPaint)
            }

        } else {
            canvas.drawRect(startX, startY, endX, endY, paint)
        }
    }

    override fun setStartCords (x: Float, y: Float) {
        startX = x
        startY = y
        endX = x
        endY = y
    }

    override fun update(newEndX: Float, newEndY: Float) {
        endX = newEndX
        endY = newEndY
    }
}
