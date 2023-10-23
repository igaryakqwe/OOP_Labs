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
        override var tempShape: Shape? = null

        override fun touchDown(x: Float, y: Float) {
            startX = x
            startY = y
            endX = x
            endY = y
            tempShape = LineShape(startX, startY, endX, endY)
        }

        override fun touchMove(x: Float, y: Float) {
            endX = x
            endY = y
            tempShape?.paint?.color = 0xFFE80C0C.toInt()
            tempShape?.update(endX, endY)
        }

        override fun touchUp(x: Float, y: Float) {
            shapesList.add(LineShape(startX, startY, endX, endY))
            tempShape?.paint?.color = 0xFF0000FF.toInt()
        }
    }
