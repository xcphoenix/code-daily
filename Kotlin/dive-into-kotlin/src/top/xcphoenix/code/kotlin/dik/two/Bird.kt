package top.xcphoenix.code.kotlin.dik.two

import kotlin.random.Random

class Bird(
    var weight: Double = 100.0,
    val age: Int = 0,
    val color: String = "blue"
) {
    // 编译完之后是 public
    lateinit var name: String
    var food = "bug"

    init {
        println("do some other things")
        println("the weight is $weight")
        this.weight = 123.0
    }

    /**
     * - [LazyThreadSafetyMode.NONE] 完全不保证线程安全，也没有线程的开销
     * - [LazyThreadSafetyMode.PUBLICATION] 允许多个线程并发，但只有第一个返回的有效
     * - [LazyThreadSafetyMode.SYNCHRONIZED] 线程安全
     */
    val sex: String by lazy(LazyThreadSafetyMode.NONE) {
        println("lazy init for `sex`")
        if (color == "yellow") "male" else "female"
    }

    fun printName() {
        println("init name prop")
        this.name = "bird#" + Random.nextInt()
        println(this.name)
    }
}

fun main() {
    val bird = Bird()
    println(bird.weight)
    println(bird.sex)
    bird.printName()
    bird.printName()
}