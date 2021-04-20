fn main() {
    let v: Vec<i32> = Vec::new();
    let mut v = vec![1, 2, 3];

    v.push(5);
    v.push(6);
    v.push(5);

    // vector 被丢弃，元素也会被丢弃
    //let a = String::from("world");
    //
    //{
    //    let v = vec!["hello".to_string(), a];
    //}
    //
    //println!("{}", a); //error: value borrowed here after move

    let v = vec![1, 2, 3, 4, 5];

    let third: &i32 = &v[2];
    println!("The third element is {}", third);

    match v.get(2) {
        None => println!("There is no third element."),
        Some(third) => println!("The third element is {}", third),
    }

    // push 可能会导致新内存的分配，这样引用可能指向了一个被释放的内存
    //let mut v = vec![1, 2, 3, 4, 5];
    //let first = &v[0];
    //v.push(6);
    //println!("The first element is: {}", first);

    let v = vec![100, 32, 57];
    // PS: 如果这里不是引用，for会拥有v的所有权，当for结束后，v将会被失效
    for x in &v {
        println!("{}", x);
    }

    println!("{}", v.len());

    let v = vec![1, 2, 3];

    let mut s = String::new();
    let data = "initial contents";
    let s = data.to_string();
    let s = "initial contents".to_string();
    let s = String::from("initial contents");

    let mut hello = "hello".to_string();
    hello.push_str("world");

    let s1 = String::from("hello, ");
    let s2 = String::from("world!");
    // 使用 s2 的引用的原因，与使用 + 运算符时调用的函数签名有关。+ 运算符使用了 add 函数，这个函数签名看起来像这样：
    //fn add(self, s: &str) -> String {}
    // &s2 类型是 `&String`，它可以被强制转换为 `&str`
    let s3 = s1 + &s2; // 这里 s1 的所有权被转移了

    let s1 = String::from("tic");
    let s2 = String::from("tac");
    let s3 = String::from("toe");

    // 使用 format! 宏来拼接字符串，而且不会获取参数的所有权
    let s = format!("{}-{}-{}", s1, s2, s3);
}
