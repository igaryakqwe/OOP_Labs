package com.example.lab2test.shapes

import android.graphics.Canvas
import android.graphics.Paint

abstract class Shape(
    open var startX: Float,
    open var startY: Float,
    open var endX: Float,
    open var endY: Float,
    open var color: Int
) {
    abstract fun draw(canvas: Canvas, paint: Paint)

    abstract fun update(newEndX: Float, newEndY: Float, newColor: Int)

    abstract fun clone(): Shape
}