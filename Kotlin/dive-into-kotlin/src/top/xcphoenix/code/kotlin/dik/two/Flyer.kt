package top.xcphoenix.code.kotlin.dik.two

interface Flyer {
    val speed
        get() = 100
    var height: Int
    fun kind()
    fun fly() {
        println("I can fly")
    }
}