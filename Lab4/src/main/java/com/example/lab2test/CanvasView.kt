package com.example.lab2test

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var myEditor: MyEditor = MyEditor()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        myEditor.onDraw(canvas)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                myEditor.touchDown(event.x, event.y)
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                myEditor.touchMove(event.x, event.y)
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                myEditor.touchUp()
                invalidate()
            }
        }
        return true
    }
}

