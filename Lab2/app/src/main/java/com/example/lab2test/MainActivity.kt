package com.example.lab2test

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.lab2test.enums.ShapesEnum
import com.example.lab2test.shapes.LineShape
import com.example.lab2test.shapes.Shape

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
                canvasView.setCurrentShape(ShapesEnum.POINT)
                return true
            }
            R.id.line -> {
                toolbar.title = item.title
                canvasView.setCurrentShape(ShapesEnum.LINE)
                return true
            }
            R.id.rectangle -> {
                toolbar.title = item.title
                canvasView.setCurrentShape(ShapesEnum.RECTANGLE)
                return true
            }
            R.id.ellipse -> {
                toolbar.title = item.title
                canvasView.setCurrentShape(ShapesEnum.ELLIPSE)
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
