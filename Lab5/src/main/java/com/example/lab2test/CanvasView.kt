package com.example.lab2test

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var myEditor: MyEditor = MyEditor.getInstance()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        myEditor.onDraw(canvas)
    }

    fun invalidateCanvas() {
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                myEditor.touchDown(event.x, event.y)
                invalidateCanvas()
            }

            MotionEvent.ACTION_MOVE -> {
                myEditor.touchMove(event.x, event.y)
                invalidateCanvas()
            }

            MotionEvent.ACTION_UP -> {
                myEditor.touchUp()
                invalidateCanvas()
            }
        }
        return true
    }

}

