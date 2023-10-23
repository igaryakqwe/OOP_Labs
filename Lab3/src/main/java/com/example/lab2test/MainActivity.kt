package com.example.lab2test

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.lab2test.editors.EllipseEditor
import com.example.lab2test.editors.LineEditor
import com.example.lab2test.editors.PointEditor
import com.example.lab2test.editors.RectangleEditor

class MainActivity : AppCompatActivity() {
    private lateinit var canvasView: CanvasView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        canvasView = findViewById(R.id.canvasView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.point -> {
                toolbar.title = item.title
                canvasView.curEditor = PointEditor(canvasView.shapesList)
                return true
            }
            R.id.line -> {
                toolbar.title = item.title
                canvasView.curEditor = LineEditor(canvasView.shapesList)
                return true
            }
            R.id.rectangle -> {
                toolbar.title = item.title
                canvasView.curEditor = RectangleEditor(canvasView.shapesList)
                return true
            }
            R.id.ellipse -> {
                toolbar.title = item.title
                canvasView.curEditor = EllipseEditor(canvasView.shapesList)
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    fun onPointButtonClick(item: MenuItem) {
        toolbar.title = item.title
        canvasView.curEditor = PointEditor(canvasView.shapesList)
        return
    }

    fun onLineButtonClick(item: MenuItem) {
        toolbar.title = "Лінія"
        canvasView.curEditor = LineEditor(canvasView.shapesList)
        return
    }
    fun onRectangleButtonClick(item: MenuItem) {
        toolbar.title = "Прямокутник"
        canvasView.curEditor = RectangleEditor(canvasView.shapesList)
        return
    }
    fun onEllipseButtonClick(item: MenuItem) {
        toolbar.title = "Елліпс"
        canvasView.curEditor = EllipseEditor(canvasView.shapesList)
        return
    }

}
