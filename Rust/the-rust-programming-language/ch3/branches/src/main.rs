fn main() {
    let number = 3;

    if number < 5 {
        println!("true")
    } else {
        println!("false")
    }

    // 因为 if 是一个表达式，我们可以在 let 语句的右侧使用它
    // if 的每个分支的可能的返回值都必须是相同类型
    let val = if true {
        5
    } else {
        6
    };

    let a = [10, 20, 30, 40, 50];

    // NOTE loop 可以返回值

    // rev 反转
    for element in a.iter().rev() {
        println!("the value is: {}", element);
    }
}
