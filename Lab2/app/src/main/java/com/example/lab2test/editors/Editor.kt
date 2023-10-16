package com.example.lab2test.editors

import com.example.lab2test.shapes.Shape

abstract class Editor {
    abstract var tempShape: Shape?

    abstract fun touchDown(x: Float, y: Float)
    abstract fun touchMove(x: Float, y: Float)
    abstract fun touchUp(x: Float, y: Float)
}
