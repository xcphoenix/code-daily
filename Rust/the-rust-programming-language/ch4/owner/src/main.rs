fn main() {
    {
        // 两个冒号（::）是运算符，允许将特定的 from 函数置于 String 类型的命名空间（namespace）下
        let mut s = String::from("hello");
        println!("{}", s);

        // error
        // let mut s = "Hello";

        s.push_str(", world!");
        println!("{}", s)
    }

    // 移动
    let s1 = String::from("hello");
    let s2 = s1; // s1 无效了，可以看做 s1 移动到了 s2

    // println!("{}, world!", s1);

    // 克隆
    let s1 = String::from("hello");
    let s2 = s1.clone();

    println!("s1 = {}, s2 = {}", s1, s2);

}
