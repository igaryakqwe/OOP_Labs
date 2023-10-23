package com.example.lab2test.editors

import com.example.lab2test.shapes.PointShape
import com.example.lab2test.shapes.Shape

class PointEditor(
    private var shapesList: MutableList<Shape>,
): Editor() {
    private var startX = 0f
    private var startY = 0f
    private var endX = 0f
    private var endY = 0f

    override var tempShape: Shape? = null

    override fun touchDown(x: Float, y: Float) {
        startX = x
        startY = y
        endX = x
        endY = y
    }

    override fun touchMove(x: Float, y: Float) {
        endX = x
        endY = y
    }

    override fun touchUp(x: Float, y: Float) {
        shapesList.add(PointShape(startX, startY, endX, endY))
    }

}
