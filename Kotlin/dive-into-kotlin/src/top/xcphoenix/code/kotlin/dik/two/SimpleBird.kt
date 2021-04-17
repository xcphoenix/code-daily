package top.xcphoenix.code.kotlin.dik.two

@Suppress("JoinDeclarationAndAssignment")
class SimpleBird(
    age: Int
) {
    private val age: Int

    init {
        this.age = age
    }

    constructor(birth: String) : this(getAge(birth)) {
        println("Use minor constructor")
    }

}

fun getAge(birth: String) = birth.toInt()
