package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

class CubeShape : Shape() {
    override var startX: Float = 0.0f
    override var startY: Float = 0.0f
    override var endX: Float = 0.0f
    override var endY: Float = 0.0f

    private val frontRect = RectangleShape()
    private val backRect = RectangleShape()
    private val lineShape4 = LineShape()
    private val lineShape1 = LineShape()
    private val lineShape2 = LineShape()
    private val lineShape3 = LineShape()

    init {
        frontRect.isCube = true
        backRect.isCube = true
    }

    override var isTouching: Boolean = false

    override fun draw(canvas: Canvas, paint: Paint) {
        frontRect.draw(canvas, paint)
        backRect.draw(canvas, paint)

        lineShape1.draw(canvas, paint)
        lineShape2.draw(canvas, paint)
        lineShape3.draw(canvas, paint)
        lineShape4.draw(canvas, paint)
    }

    override fun setStartCords(x: Float, y: Float) {
        startX = x
        startY = y

        frontRect.setStartCords(x, y)
        backRect.setStartCords(startX - 100, startY - 100)
    }

    override fun update(newEndX: Float, newEndY: Float) {
        endX = newEndX
        endY = newEndY

        frontRect.update(newEndX, newEndY)
        backRect.update(endX - 100, endY - 100)

        val parallelX1 = startX - 100
        val parallelY1 = startY - 100
        val parallelX2 = endX - 100
        val parallelY2 = startY - 100
        val parallelX3 = startX - 100
        val parallelY3 = endY - 100
        val parallelX4 = endX - 100
        val parallelY4 = endY - 100

        lineShape1.setStartCords(startX, startY)
        lineShape1.update(parallelX1, parallelY1)
        lineShape2.setStartCords(endX, startY)
        lineShape2.update(parallelX2, parallelY2)
        lineShape3.setStartCords(startX, endY)
        lineShape3.update(parallelX3, parallelY3)
        lineShape4.setStartCords(endX, endY)
        lineShape4.update(parallelX4, parallelY4)
    }

}
