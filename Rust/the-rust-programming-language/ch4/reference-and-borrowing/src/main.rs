fn main() {
    let mut s1 = String::from("Hello");
    let len = calculate_length(&s1);
    println!("The length of '{}' is {}.", s1, len);

    change(&mut s1);
    println!("after change: {}", s1);

    let reference_to_nothing = dangle();
}

// 引用：使用值但不获取其所有权
fn calculate_length(s: &String) -> usize {
    s.len()
}

// 可变引用
// 不过可变引用有一个很大的限制：在特定作用域中的特定数据只能有一个可变引用.
// ---
// 注意一个引用的作用域从声明的地方开始一直持续到最后一次使用为止
fn change(some_string: &mut String) {
    some_string.push_str(", world");
}

fn dangle() -> &String {
    let s = String::from("hello");
    // 悬垂引用
    // 函数执行完毕后，s 会被释放，那么这个引用将会指向一个无效的值
    &s
}