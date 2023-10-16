package com.example.lab2test.editors

import com.example.lab2test.shapes.RectangleShape
import com.example.lab2test.shapes.Shape

class RectangleEditor(
    private var shapesList: MutableList<Shape>,
): Editor() {
    private var startX = 0f
    private var startY = 0f
    private var endX = 0f
    private var endY = 0f
    private var isTouching = false
    override var tempShape: Shape? = null


    override fun touchDown(x: Float, y: Float) {
        startX = x
        startY = y
        endX = x
        endY = y
        tempShape = RectangleShape(startX, startY, endX, endY)
        isTouching = true
    }

    override fun touchMove(x: Float, y: Float) {
        endX = x
        endY = y
        tempShape?.update(endX, endY)
    }

    override fun touchUp(x: Float, y: Float) {
        shapesList.add(RectangleShape(startX, startY, endX, endY))
        tempShape = null
    }
}
