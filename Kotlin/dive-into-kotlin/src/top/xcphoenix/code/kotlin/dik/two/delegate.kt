package top.xcphoenix.code.kotlin.dik.two

interface CanFly {
    fun fly()
}

interface CanEat {
    fun eat()
}

open class XFlyer : CanFly {
    override fun fly() {
        println("I can fly")
    }
}

open class XAnimal : CanEat {
    override fun eat() {
        println("I can eat")
    }
}

class XBird(flyer: XFlyer, animal: XAnimal) : CanFly by flyer, CanEat by animal

fun main(args: Array<String>) {
    val flyer = XFlyer()
    val animal = XAnimal()
    val b = XBird(flyer, animal)
    b.fly()
    b.eat()
}
