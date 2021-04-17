package top.xcphoenix.code.kotlin.dik.four

// 密封类的子类可以放在任何位置
class TestClass( val width: Double) : Shape.Circle(width)

fun main() {
    println(getArea(Shape.Rectangle(1.0, 2.0)))
    println(getArea(TestClass(1.0)))
    TestClass(0.1).width
}

fun getArea(shape: Shape) : Double = when(shape) {
    // IDEA 生成的只有后两个，但仍然包含了所有的可能，前两个仅仅是 Circle 的一种
    is TestClass -> 0.0
    is Shape.Rectangle -> 1.0
    is Shape.Circle -> 2.0
    is Shape.Triangle -> 3.0
}