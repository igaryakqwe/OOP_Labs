    package com.example.lab2test.editors

    import com.example.lab2test.shapes.LineShape
    import com.example.lab2test.shapes.Shape

    class LineEditor(
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
            tempShape = LineShape(startX, startY, endX, endY)
            isTouching = true
        }

        override fun touchMove(x: Float, y: Float) {
            if (isTouching) {
                endX = x
                endY = y
                tempShape?.paint?.color = 0xFF000000.toInt()
                tempShape?.update(endX, endY)
            }
        }

        override fun touchUp(x: Float, y: Float) {
            shapesList.add(LineShape(startX, startY, endX, endY))
            isTouching = false
            tempShape?.paint?.color = 0xFF0000FF.toInt()
            tempShape = null
        }
    }
