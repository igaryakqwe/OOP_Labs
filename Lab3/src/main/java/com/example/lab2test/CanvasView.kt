package com.example.lab2test

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.lab2test.editors.*
import com.example.lab2test.shapes.Shape

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var shapesList: MutableList<Shape> = mutableListOf()
    var curEditor: Editor? = null

    private val gumTraceColor = 0xFFE80C0C.toInt()

    private var tempShape: Shape? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (shape in shapesList) {
            shape.draw(canvas, 0xFF000000.toInt())
        }

        if (tempShape != null) {
            tempShape!!.draw(canvas, gumTraceColor)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                curEditor?.touchDown(event.x, event.y)
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                curEditor?.touchMove(event.x, event.y)
                tempShape = curEditor?.tempShape
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                curEditor?.touchUp(event.x, event.y)
                tempShape = null
                invalidate()
            }
        }
        return true
    }
}

