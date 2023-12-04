package com.example.lab2test

import android.annotation.SuppressLint
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.example.lab2test.shapes.Shape

class MyTable(
    private val tableLayout: TableLayout,
    private val canvasView: CanvasView,
    private val myEditor: MyEditor
) {
    @SuppressLint("UseCompatLoadingForDrawables")
    fun add(shape: Shape) {
        val tableRow = TableRow(tableLayout.context)

        val textViewName = createTextView(shape.name)
        val textViewStartX = createTextView(shape.startX.toString())
        val textViewStartY = createTextView(shape.startY.toString())
        val textViewEndX = createTextView(shape.endX.toString())
        val textViewEndY = createTextView(shape.endY.toString())

        val textViews: MutableList<TextView> = mutableListOf(textViewName, textViewStartX, textViewStartY, textViewEndX, textViewEndY)

        tableRow.setOnClickListener {
            for (textView in textViews) {
                if (tableRow.isSelected) {
                    textView.background = tableLayout.resources.getDrawable(R.drawable.grid_background)
                    shape.isSelected = false
                } else {
                    textView.background = tableLayout.resources.getDrawable(R.drawable.selected_grid_background)
                    shape.isSelected = true
                }
            }

            if (shape.isSelected) {
                shape.setStrokeColor(0xFF0e55cf.toInt())
            } else {
                shape.setStrokeColor(0xFF000000.toInt())
            }

            canvasView.invalidate()
        }

        tableRow.setOnLongClickListener {
            tableLayout.removeView(tableRow)
            myEditor.shapesList.remove(shape)
            canvasView.invalidate()
            true
        }

        for (textView in textViews) {
            tableRow.addView(textView)
        }

        tableLayout.addView(tableRow)
    }

    private fun createTextView(text: String): TextView {
        val textView = TextView(tableLayout.context)
        textView.text = text
        textView.gravity = Gravity.CENTER
        textView.background = tableLayout.resources.getDrawable(R.drawable.grid_background)
        textView.layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 10f)
        return textView
    }
}
