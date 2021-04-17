package top.xcphoenix.code.kotlin.dik.two

fun main(args: Array<String>) {
    val nums = mutableListOf<Int>()
    var str: String = "HelloWorld"
    nums.add(1)
    nums.add(2)    
    nums.add(3)
    println(filterNumCnt(nums, ::filter))
    // lambda 表达式如果是函数的最后一个参数，可以放在外面
    println(filterNumCnt(nums) { num -> num % 2 == 1 })
    val func = fun(a: Int, b: Int): Int {
        return a + b
    }
    println(func(1, 2))

    for (i in 1..10) {
        println(i)
    }
}

// 表达式函数体
fun filter(i: Int): Boolean = i % 2 == 1

// 正常的函数
fun filterFun(i: Int): Boolean {
    return i % 2 == 1
}

// 表达式函数体，不同的是这里返回的是一个 lambda 表达式
// 返回值省略掉就看起来很令人迷惑
fun filterLambdaByFun(i: Int): (Int) -> Boolean = {
    i % 2 == 1
}

fun filterNumCnt(nums: List<Int>, test: (Int) -> Boolean): Int {
    var res = 0
    for (i in nums) {
        if (!test(i)) {
            res += i
        }
    }
    return res
}