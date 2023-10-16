package com.example.lab2test

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.lab2test.editors.*
import com.example.lab2test.enums.ShapesEnum
import com.example.lab2test.shapes.Shape

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var shapesList: MutableList<Shape> = mutableListOf()
    private var curEditor: Editor? = null

    private var tempShape: Shape? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (shape in shapesList) {
            shape.draw(canvas)
        }

        if (tempShape != null) {
            tempShape!!.draw(canvas)
        }
    }

    fun setCurrentEditor(shape: ShapesEnum) {
        curEditor = when (shape) {
            ShapesEnum.POINT -> PointEditor(shapesList)
            ShapesEnum.LINE -> LineEditor(shapesList)
            ShapesEnum.RECTANGLE -> RectangleEditor(shapesList)
            ShapesEnum.ELLIPSE -> EllipseEditor(shapesList)
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
                invalidate()
            }
        }
        return true
    }
}

