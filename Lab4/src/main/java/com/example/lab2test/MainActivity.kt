package com.example.lab2test

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.lab2test.shapes.CubeShape
import com.example.lab2test.shapes.EllipseShape
import com.example.lab2test.shapes.LineOOShape
import com.example.lab2test.shapes.LineShape
import com.example.lab2test.shapes.PointShape
import com.example.lab2test.shapes.RectangleShape

class MainActivity : AppCompatActivity() {
    private lateinit var canvasView: CanvasView
    private lateinit var titleToolbar: Toolbar
    private lateinit var menuToolbar: Toolbar
    private lateinit var myEditor: MyEditor
    private var titleIcon: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuToolbar = findViewById(R.id.menuToolbar)
        setSupportActionBar(menuToolbar)

        canvasView = findViewById(R.id.canvasView)
        myEditor = canvasView.myEditor

        titleIcon = findViewById(R.id.titleIcon)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.point -> {
                myEditor.curShape = PointShape()
                updateIcon(R.drawable.ic_point)
                return true
            }
            R.id.line -> {
                myEditor.curShape = LineShape()
                updateIcon(R.drawable.ic_line)
                return true
            }
            R.id.rectangle -> {
                myEditor.curShape = RectangleShape()
                updateIcon(R.drawable.ic_rectangle)
                return true
            }
            R.id.ellipse -> {
                myEditor.curShape = EllipseShape()
                updateIcon(R.drawable.ic_ellipse)
                return true
            }
            R.id.cube -> {
                myEditor.curShape = CubeShape()
                updateIcon(R.drawable.ic_cube)
                return true
            }
            R.id.lineOO -> {
                myEditor.curShape = LineOOShape()
                updateIcon(R.drawable.ic_lineoo)
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    fun onPointButtonClick(item: MenuItem) {
        myEditor.curShape = PointShape()
        updateIcon(R.drawable.ic_point)
        return
    }

    fun onLineButtonClick(item: MenuItem) {
        myEditor.curShape = LineShape()
        updateIcon(R.drawable.ic_line)
        return
    }
    fun onRectangleButtonClick(item: MenuItem) {
        myEditor.curShape = RectangleShape()
        updateIcon(R.drawable.ic_rectangle)
        return
    }
    fun onEllipseButtonClick(item: MenuItem) {
        myEditor.curShape = EllipseShape()
        updateIcon(R.drawable.ic_ellipse)
        return
    }

    fun onCubeButtonClick(item: MenuItem) {
        myEditor.curShape = CubeShape()
        updateIcon(R.drawable.ic_cube)
        return
    }

    fun onLineOOButtonClick(item: MenuItem) {
        myEditor.curShape = LineOOShape()
        updateIcon(R.drawable.ic_lineoo)
        return
    }

    private fun updateIcon(iconResourceId: Int) {
        titleIcon?.apply {
            setImageResource(iconResourceId)
            visibility = View.VISIBLE
        }
    }

}
