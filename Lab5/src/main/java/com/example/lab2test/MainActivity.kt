package com.example.lab2test

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TableLayout
import android.widget.Toast
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
    private val fileSystem = FileSystem(this)

    private lateinit var menuToolbar: Toolbar
    private lateinit var titleToolbar: Toolbar
    private lateinit var scrollView: ScrollView
    private lateinit var myEditor: MyEditor
    private lateinit var tableLayout: TableLayout
    private var titleIcon: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuToolbar = findViewById(R.id.menuToolbar)
        setSupportActionBar(menuToolbar)

        titleToolbar = findViewById(R.id.titleToolbar)
        setSupportActionBar(titleToolbar)

        canvasView = findViewById(R.id.canvasView)
        myEditor = canvasView.myEditor
        myEditor.curShape = PointShape()
        tableLayout = findViewById(R.id.tableLayout)
        myEditor.myTable = MyTable(tableLayout, canvasView, myEditor)

        titleIcon = findViewById(R.id.titleIcon)
        titleIcon?.apply {
            setImageResource(R.drawable.ic_point)
            visibility = View.VISIBLE
        }

        scrollView = findViewById(R.id.scrollView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        titleToolbar.inflateMenu(R.menu.menu_toolbar)
        menuToolbar.inflateMenu(R.menu.menu_items)
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

    private fun updateIcon(iconResourceId: Int) {
        titleIcon?.apply {
            setImageResource(iconResourceId)
            visibility = View.VISIBLE
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


    fun onTableClick(item: MenuItem) {
        if (scrollView.visibility == View.VISIBLE) {
            scrollView.visibility = View.GONE
            return
        } else {
            scrollView.visibility = View.VISIBLE
            return
        }
    }

    fun onClearButtonClick(item: MenuItem) {
        val childCount = tableLayout.childCount
        if (childCount > 1) {
            for (i in childCount - 1 downTo 1) {
                tableLayout.removeViewAt(i)
            }
        }

        myEditor.shapesList.clear()
        myEditor.prevShapes.clear()

        canvasView.invalidateCanvas()
    }

    fun onPrevButtonClick(item: MenuItem) {
        if (myEditor.shapesList.isEmpty()) {
            Toast.makeText(this, "Nothing to undo", Toast.LENGTH_SHORT).show()
        } else {
            val shape = myEditor.shapesList.last()
            myEditor.prevShapes.add(shape)
            myEditor.shapesList.remove(shape)

            val rowCount = tableLayout.childCount
            if (rowCount > 0) {
                tableLayout.removeViewAt(rowCount - 1)
            }

            canvasView.invalidateCanvas()
        }
    }

    fun onNextButtonClick(item: MenuItem) {
        if (myEditor.prevShapes.isEmpty()) {
            Toast.makeText(this, "Nothing to redo", Toast.LENGTH_SHORT).show()
        } else {
            val shape = myEditor.prevShapes.last()
            myEditor.shapesList.add(shape)
            myEditor.prevShapes.remove(shape)

            myEditor.myTable?.add(shape)

            canvasView.invalidateCanvas()
        }
    }

    fun onSave(item: MenuItem) {
        fileSystem.saveToFile("shapes.json", myEditor.shapesList)
        Toast.makeText(this, "Shapes saved to file", Toast.LENGTH_SHORT).show()
    }

    fun onLoad(item: MenuItem) {
        fileSystem.loadFromFile("shapes.json", myEditor.shapesList)
        for (shape in myEditor.shapesList) {
            myEditor.myTable?.add(shape)
        }
        canvasView.invalidateCanvas()
        Toast.makeText(this, "Shapes loaded from file", Toast.LENGTH_SHORT).show()
    }


}
