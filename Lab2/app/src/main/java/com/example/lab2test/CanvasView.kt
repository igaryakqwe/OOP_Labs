package com.example.lab2test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.lab2test.editors.LineEditor
import com.example.lab2test.enums.ShapesEnum
import com.example.lab2test.shapes.EllipseShape
import com.example.lab2test.shapes.LineShape
import com.example.lab2test.shapes.PointShape
import com.example.lab2test.shapes.RectangleShape
import com.example.lab2test.shapes.Shape

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint()
    private var startX = 0f
    private var startY = 0f
    private var endX = 0f
    private var endY = 0f
    private var isTouching = false
    private var shapesList = mutableListOf<Shape>()
    private var curShape: Shape? = null

    var tempShape: Shape? = null

    init {
        paint.strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (shape in shapesList) {
            shape.draw(canvas, paint)
        }

        if (tempShape != null) {
            tempShape!!.draw(canvas, paint)
        }
    }

    fun addShape(startX: Float, startY: Float, endX: Float, endY: Float, paint: Paint) {
        val shape = when(curShape) {
            is LineShape -> LineShape(startX, startY, endX, endY, paint.color)
            is PointShape -> PointShape(startX, startY, endX, endY, paint.color)
            is RectangleShape -> RectangleShape(startX, startY, endX, endY, paint.color)
            is EllipseShape -> EllipseShape(startX, startY, endX, endY, paint.color)
            else -> PointShape(startX, startY, endX, endY, paint.color)
        }
        shapesList.add(shape)
    }

    fun setCurrentShape(shape: ShapesEnum) {
        curShape = when (shape) {
            ShapesEnum.POINT -> PointShape(startX, startY, endX, endY, paint.color)
            ShapesEnum.LINE -> LineShape(startX, startY, endX, endY, paint.color)
            ShapesEnum.RECTANGLE -> RectangleShape(startX, startY, endX, endY, paint.color)
            ShapesEnum.ELLIPSE -> EllipseShape(startX, startY, endX, endY, paint.color)
            else -> null
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
                endX = event.x
                endY = event.y
                paint.color = 0xFF0000FF.toInt()
                isTouching = true
                when (curShape) {
                    is LineShape -> {
                        tempShape = LineShape(startX, startY, endX, endY, paint.color)
                    }

                    is PointShape -> {
                        tempShape = PointShape(startX, startY, endX, endY, paint.color)
                    }

                    is RectangleShape -> {
                        tempShape = RectangleShape(startX, startY, endX, endY, paint.color)
                    }

                    is EllipseShape -> {
                        tempShape = EllipseShape(startX, startY, endX, endY, paint.color)
                    }
                }
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                if (isTouching) {
                    endX = event.x
                    endY = event.y
                    paint.color = 0xFF000000.toInt()
                    tempShape?.update(endX, endY, paint.color)
                    invalidate()
                }
            }

            MotionEvent.ACTION_UP -> {
                isTouching = false
                paint.color = 0xFF0000FF.toInt()
                addShape(startX, startY, endX, endY, paint)
                tempShape = null
                invalidate()
            }
        }
        return true
    }
}

