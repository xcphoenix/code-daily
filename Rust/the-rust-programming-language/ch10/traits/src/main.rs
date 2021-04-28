use std::fmt::{Debug, Display};

/**
 * Traits test
 */
fn main() {
    returns_summarizable(true);
}


pub trait Summary {
    // 可以提供默认的实现
    fn summarize(&self) -> String {
        String::from("(Reading more...)")
    }
    //fn summarize(&self) -> String;
}

pub fn notify(item: impl Summary) {
    println!("Breaking news! {}", item.summarize());
}

pub fn notify_plus<T: Summary>(item: T) {
    println!("NNNN")
}

// 指定多个 trait，trait bound 也可以这样
pub fn notify_display(item: impl Summary + Display) {}

// 用 where 从句来指定 trait bound，更易阅读
pub fn notify_where<T, U>(t: T, u: U)
    where T: Display + Clone,
          U: Clone + Debug
{}

// Rust 之所以要求函数不能返回多种类型是因为 Rust 在需要在
// 编译期确定返回值占用的内存大小, 显然不同类型的返回值其内存大小不一定相同.
fn returns_summarizable(switch: bool) -> Box<dyn Summary> {
    // NewArticle {
    //     headline: String::from("Penguins win the Stanley Cup Championship!"),
    //     location: String::from("Pittsburgh, PA, USA"),
    //     author: String::from("Iceburgh"),
    //     content: String::from("The Pittsburgh Penguins once again are the best
    //         hockey team in the NHL."),
    // }
    
    if switch {
        Box::new(NewArticle {
            headline: String::from("Penguins win the Stanley Cup Championship!"),
            location: String::from("Pittsburgh, PA, USA"),
            author: String::from("Iceburgh"),
            content: String::from("The Pittsburgh Penguins once again are the best
            hockey team in the NHL."),
        })
    } else {
        Box::new(Tweet {
            username: String::from("horse_ebooks"),
            content: String::from("of course, as you probably already know, people"),
            reply: false,
            retweet: false,
        })
    }
}

pub struct NewArticle {
    pub headline: String,
    pub location: String,
    pub author: String,
    pub content: String,
}

impl Summary for NewArticle {
    fn summarize(&self) -> String {
        format!("{}, by {}, ({})", self.headline, self.author, self.location)
    }
}

pub struct Tweet {
    pub username: String,
    pub content: String,
    pub reply: bool,
    pub retweet: bool,
}

impl Summary for Tweet {
    fn summarize(&self) -> String {
        format!("{}: {}", self.username, self.content)
    }
}

