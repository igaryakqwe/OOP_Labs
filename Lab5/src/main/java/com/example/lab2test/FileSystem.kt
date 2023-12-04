package com.example.lab2test

import android.content.Context
import com.example.lab2test.shapes.CubeShape
import com.example.lab2test.shapes.EllipseShape
import com.example.lab2test.shapes.LineOOShape
import com.example.lab2test.shapes.LineShape
import com.example.lab2test.shapes.PointShape
import com.example.lab2test.shapes.RectangleShape
import com.example.lab2test.shapes.Shape
import com.example.lab2test.shapes.ShapeData
import com.google.gson.Gson
import java.io.*

class FileSystem(private val context: Context) {
    private val shapeClassMap = mapOf(
        "Point" to PointShape::class.java,
        "Line" to LineShape::class.java,
        "Rectangle" to RectangleShape::class.java,
        "Ellipse" to EllipseShape::class.java,
        "Cube" to CubeShape::class.java,
        "LineOO" to LineOOShape::class.java,
    )

    private fun toShapeData(shape: Shape): ShapeData {
        return ShapeData(
            shape.name,
            shape.startX,
            shape.startY,
            shape.endX,
            shape.endY
        )
    }

    private fun fromShapeData(shapeData: ShapeData): Shape {
        return shapeClassMap[shapeData.name]?.newInstance()?.apply {
            setStartCords(shapeData.startX, shapeData.startY)
            update(shapeData.endX, shapeData.endY)
        } ?: throw Exception("Unknown shape name")
    }

    fun saveToFile(fileName: String, shapes: List<Shape>) {
        val gson = Gson()
        val shapeDataList = shapes.map { toShapeData(it) }
        val jsonString = gson.toJson(shapeDataList)

        try {
            val file = File(context.getExternalFilesDir(null), fileName)
            val writer = BufferedWriter(FileWriter(file))
            writer.write(jsonString)
            writer.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun loadFromFile(fileName: String, shapesList: MutableList<Shape>) {
        try {
            val file = File(context.getExternalFilesDir(null), fileName)
            if (file.exists()) {
                val reader = BufferedReader(FileReader(file))
                val typeToken = object : com.google.gson.reflect.TypeToken<List<ShapeData>>() {}.type
                val shapeDataList: List<ShapeData> = Gson().fromJson(reader, typeToken)

                shapesList.addAll(shapeDataList.map { fromShapeData(it) })

                reader.close()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
