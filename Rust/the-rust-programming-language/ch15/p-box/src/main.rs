use crate::List::{Cons, Nil};

enum List {
    // Cons(i32, List),    // error
    Cons(i32, Box<List>),
    Nil,
}

fn main() {
    // `Box<T>` 堆上存储数据
    let b = Box::new(5);
    println!("b = {}", b);
    
    // `Box` 创建递归类型（无法在编译时知道大小）
    // let list = Cons(1, Cons(2, Cons(3, Nil))); // error
    let list = Cons(1,
                    Box::new(Cons(2,
                                  Box::new(Cons(3,
                                                Box::new(Nil))))));
}
