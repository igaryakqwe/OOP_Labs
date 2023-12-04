package com.example.lab2test

import android.graphics.Canvas
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.PathEffect
import com.example.lab2test.shapes.Shape

class MyEditor {
    var shapesList = mutableListOf<Shape>()
    var prevShapes = mutableListOf<Shape>()
    var curShape: Shape? = null
    private var tempShape: Shape? = null
    private val gumTraceColor = 0xFFE80C0C.toInt()
    private lateinit var newShape: Shape
    private val paint = Paint()
    var myTable: MyTable? = null

    fun onDraw (canvas: Canvas) {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8f
        paint.color = 0xFF000000.toInt()
        paint.pathEffect = PathEffect()

        for (shape in shapesList) {
            shape.isTouching = false
            shape.draw(canvas, paint)
        }

        paint.pathEffect = DashPathEffect(floatArrayOf(10f, 10f), 0f)
        paint.color = gumTraceColor
        if (tempShape != null) {
            tempShape!!.isTouching = true
            tempShape!!.draw(canvas, paint)
        }
    }

    fun touchDown(x: Float, y: Float) {
        curShape = curShape?.javaClass?.newInstance()
        curShape?.setStartCords(x, y)
        tempShape = curShape
    }

    fun touchMove(x: Float, y: Float) {
        tempShape?.update(x, y)
    }

    fun touchUp() {
        newShape = curShape!!
        shapesList.add(newShape)
        myTable?.add(newShape)
        prevShapes.clear()
        tempShape = null
    }

    companion object {
        private var instance: MyEditor? = null

        fun getInstance(): MyEditor {
            if (instance == null) {
                instance = MyEditor()
            }
            return instance!!
        }
    }
}
