package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

abstract class Shape {
    abstract var startX: Float
    abstract var startY: Float
    abstract var endX: Float
    abstract var endY: Float
    abstract var isTouching: Boolean

    abstract fun draw(canvas: Canvas, paint: Paint)

    abstract fun setStartCords (x: Float, y: Float)

    abstract fun update(newEndX: Float, newEndY: Float)
}
