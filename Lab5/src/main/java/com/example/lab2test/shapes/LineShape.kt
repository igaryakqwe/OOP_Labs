package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

class LineShape: Shape() {
    override var name: String = "Line"
    override var startX: Float = 0.0f
    override var startY: Float = 0.0f
    override var endX: Float = 0.0f
    override var endY: Float = 0.0f
    override var isTouching: Boolean = false
    override var isSelected: Boolean = false
    var strokePaint: Paint = Paint()

    init {
        strokePaint.style = Paint.Style.STROKE
        strokePaint.strokeWidth = 8f
        strokePaint.color = 0xFF000000.toInt()
    }

    override fun setStrokeColor(color: Int) {
        strokePaint.color = color
    }

    override fun setStartCords (x: Float, y: Float) {
        startX = x
        startY = y
        endX = x
        endY = y
    }


    override fun draw(canvas: Canvas, paint: Paint) {
        paint.style = Paint.Style.STROKE
        paint.color = paint.color
        if (!isTouching) {
            canvas.drawLine(startX, startY, endX, endY, strokePaint)
        } else {
            canvas.drawLine(startX, startY, endX, endY, paint)
        }
    }

    override fun update(newEndX: Float, newEndY: Float) {
        endX = newEndX
        endY = newEndY
    }
}
