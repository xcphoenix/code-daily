package top.xcphoenix.code.kotlin.dik.two

open class Horse {
    fun runFast() {
        println("I can run fast")
    }
}

open class Donkey {
    fun doLongTimeThing() {
        println("I can do some thing long time")
    }
}

class Mule {
    fun runFast() {
        HorseC().runFast()
    }

    fun doLongTimeThing() {
        DonkeyC().doLongTimeThing()
    }

    // 不加 inner 为 Java 中的静态内部类，加上 inner 才是内部类
    private inner class HorseC : Horse()
    private inner class DonkeyC : Donkey()

}