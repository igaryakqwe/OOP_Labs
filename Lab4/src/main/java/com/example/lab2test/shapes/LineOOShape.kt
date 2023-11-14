package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

class LineOOShape : Shape() {
    override var startX: Float = 0.0f
    override var startY: Float = 0.0f
    override var endX: Float = 0.0f
    override var endY: Float = 0.0f
    override var isTouching: Boolean = false
    private var fillPaint: Paint = Paint()
    private var strokePaint: Paint = Paint()

    init {
        fillPaint.style = Paint.Style.FILL
        fillPaint.strokeWidth = 8f
        fillPaint.color = 0xFFFFFFFF.toInt()

        strokePaint.style = Paint.Style.STROKE
        strokePaint.strokeWidth = 8f
        strokePaint.color = 0xFF000000.toInt()
    }

    private var lineShape = LineShape()
    private var ellipseShape1 = EllipseShape()
    private var ellipseShape2 = EllipseShape()

    override fun draw(canvas: Canvas, paint: Paint) {
        lineShape.draw(canvas, paint)
        if (!isTouching) {
            ellipseShape1.draw(canvas, fillPaint)
            ellipseShape2.draw(canvas, fillPaint)

            ellipseShape1.draw(canvas, strokePaint)
            ellipseShape2.draw(canvas, strokePaint)
        } else {
            ellipseShape1.draw(canvas, paint)
            ellipseShape2.draw(canvas, paint)
        }
    }


    override fun setStartCords(x: Float, y: Float) {
        startX = x
        startY = y

        lineShape.setStartCords(startX, startY)
        ellipseShape1.setStartCords(startX, startY)
    }

    override fun update(newEndX: Float, newEndY: Float) {
        endX = newEndX
        endY = newEndY

        lineShape.update(endX, endY)
        ellipseShape1.update(startX + 50f, startY + 50f)
        ellipseShape2.setStartCords(endX, endY)
        ellipseShape2.update(endX + 50f, endY + 50f)
    }
}