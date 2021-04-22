fn main() {
    let string1 = String::from("abcd");
    let string2 = "xyz";

    let result = longest(string1.as_str(), string2);
    println!("The longest string is {}", result);

    //==================================================

    let string1 = String::from("long string is long");
    let result;
    {
        let string2 = String::from("xyz");
        result = longest(string1.as_str(), string2.as_str());
        println!("The longest string is {}", result);
    }
    // 返回的生命周期与 string1 和 string2 一致，这里生命周期已经结束了
    //println!("The longest string is {}", result);

    //==================================================

    let novel = String::from("Call me Ishmael. Some years ago...");
    let first_sentence = novel.split('.')
        .next()
        .expect("Couldn't find a '.'");
    let i = ImportantExcerpt { part: first_sentence };

    //==================================================
    // 生命周期存活于整个程序
    let s: &'static str = "I have a static lifetime";

}

// 泛型生命周期参数'a的具体生命周期等同于x和y的生命周期中较小的一个
fn longest<'a>(x: &'a str, y: &'a str) -> &'a str {
    if x.len() > y.len() {
        x
    } else {
        y
    }
}

struct ImportantExcerpt<'a> {
    part: &'a str, // 结构体包含了引用, 需要定义生命周期注解
}

impl<'a> ImportantExcerpt<'a> {
    // 生命周期省略规则的第一条规则
    fn level(&self) -> i32 {
        3
    }
    fn announce_and_return_part(&self, announcement: &str) -> &str {
        println!("{}", announcement);
        self.part
    }
}

struct TestStruct<'a, 'b> {
    part: &'a str,
    all: &'b str,
}