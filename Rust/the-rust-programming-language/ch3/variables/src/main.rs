fn main() {
    let mut x = 5;
    println!("The value of x is: {}", x);
    x = 6;
    println!("The value of x is: {}", x);

    // - 必须 注明值的类型
    // - 常量可以在任何作用域中声明，包括全局作用域
    // - 常量只能被设置为常量表达式，而不能是函数调用的结果，或任何其他只能在运行时计算出的值。
    const MAX_POINTS: u32 = 100_000;

    let y = 5;
    println!("The value of x is: {}", y);

    // 实际上创建了一个新的变量，可以修改变直的类型，但可以复用这个名字
    let y = y + 1;
    println!("The value of x is: {}", y);

    let y = y * 2;
    println!("The value of x is: {}", y);

    let mut y = 23usize;
    let y = y * 2;
    let mut y: u64 = 100;

    let c = 'z';
    let z = '和';
    let k = '😻';

    // 元组，长度固定，元素类型可以不一致
    let tup: (i32, f64, u8) = (500, 6.4, 1);
    // 解构
    let (a, b, c) = tup;
    let one = tup.0;

    // 数组，长度固定，元素类型一致
    let a = [1, 2, 3, 4, 5];
    // 明确指定类型
    let k: [i32; 5] = [1, 2, 3, 4, 5];
    // 声明一个数组，初始值为3，长度为5，每个元素的值都被设置为 3
    let k = [3; 5];

    let first = k[0];
    // let invalid = k[100];

    another_function(1);

    // 函数调用是一个表达式。宏调用是一个表达式。我们用来创建新作用域的大括号（代码块），{}，也是一个表达式
    let x = 5;

    let y = {
        let x = 3;
        x + 1 // 表达式的结尾没有分号。如果在表达式的结尾加上分号，它就变成了语句，而语句不会返回值。
    };

    println!("The value of y is: {}", y);
    println!("{}", five())
}

fn another_function(x: i32) {
    println!("HHH");
}

fn five() -> i32 {
    return 6;
    // 不能只写6; '6;' 不是表达式，而是一个语句
    // '()' 表示不返回值
}


