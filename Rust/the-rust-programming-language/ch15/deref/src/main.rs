
use std::ops::Deref;

// 实现 Deref trait 允许重载 解引用运算符 *，
// 实现 Deref trait 的智能指针可被当做常规引用来对待

fn main() {
    /// 通过解引用运算符来追踪指针的值
    let x = 5;
    let y = &x;
    
    assert_eq!(5, x);
    assert_eq!(5, *y);
    // i32 与 &i32 是两种不同的类型，需要使用解引用来追踪引用指向的值
    
    /// 像引用一样使用 `Box<T>`
    let x = 5;
    let y = Box::new(x);
    
    assert_eq!(5, x);
    assert_eq!(5, *y);
    
    /// 自定义智能指针
    let x = 5;
    let y = MyBox::new(x);
    assert_eq!(5, x);
    assert_eq!(5, *y); // 相当于运行了 `*(y.deref())`
    
    /// 函数和方法的隐式解引用强制多态
    /// 解引用强制多态（deref coercions）是 Rust 在函数或方法传参上的一种简化。
    /// 将实现了 Deref 的类型的引用，转换为 原始类型通过 Deref 可以转换的类型 的引用。
    /// 当这种特定类型的引用作为实参传递给和形参类型不同的函数或方法时，解引用强制多态将自动发生。
    /// 这时会有一系列的 deref 方法被调用，把我们提供的类型转换成了参数所需的类型。
    let m = MyBox::new(String::from("Rust"));
    hello(&m);
    // before: &MyBox<String>
    // then:   &String        -- use MyBox Deref
    // after:  &str           -- use String Deref
    
    /// 可变性
    ///
    /// Deref    不可变
    /// DerefMut 可变
    ///
    /// - 当 T: Deref<Target=U> 时从 &T 到 &U。
    /// - 当 T: DerefMut<Target=U> 时从 &mut T 到 &mut U。
    /// - 当 T: Deref<Target=U> 时从 &mut T 到 &U。
}

/// 元组结构体
/// 自定义智能指针
struct MyBox<T>(T);

impl<T> MyBox<T> {
    fn new(x: T) -> MyBox<T> {
        MyBox(x)
    }
}

impl<T> Deref for MyBox<T> {
    // trait 的关联类型
    type Target = T;
    
    fn deref(&self) -> &T {
        &self.0
    }
}

fn hello(name: &str) {
    println!("Hello, {}!", name);
}