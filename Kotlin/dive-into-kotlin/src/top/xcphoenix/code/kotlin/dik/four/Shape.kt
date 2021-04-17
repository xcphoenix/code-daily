package top.xcphoenix.code.kotlin.dik.four

/**
 * Shape 密封类
 *
 * @constructor Create empty Shape
 */
sealed class Shape {
    open class Circle(private val radius: Double) : Shape()
    class Rectangle(private val width: Double, val height: Double) : Circle(width)
    class Triangle(private val base: Double, val height: Double) : Shape()
}
