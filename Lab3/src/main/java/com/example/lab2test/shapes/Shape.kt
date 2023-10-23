package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

abstract class Shape(
    open var startX: Float,
    open var startY: Float,
    open var endX: Float,
    open var endY: Float,
) {
    abstract var paint: Paint

    abstract fun draw(canvas: Canvas, color: Int)

    abstract fun update(newEndX: Float, newEndY: Float)
}
