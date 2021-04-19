// 加上注解来显示增加 println! 输出调试信息的功能
#[derive(Debug)]
struct Rectangle {
    width: u32,
    height: u32,
}

// 为了使函数定义于 Rectangle 的上下文中，我们开始了一个 impl 块
impl Rectangle {
    fn area(&self) -> u32 {
        self.height * self.width
    }

    fn can_hold(&self, other: &Rectangle) -> bool {
        self.width > other.width && self.height > other.height
    }

    // 允许在 impl 块中定义 不 以 self 作为参数的函数。这被称为 关联函数（associated functions）
    // 关联函数，与结构体关联，但他是函数而不是方法
    fn square(size: u32) -> Rectangle {
        Rectangle { width: size, height: size }
    }
}


fn main() {
    let rect1 = Rectangle { width: 30, height: 50 };

    println!(
        "The area of the rectangle is {} square pixels.",
        area(&rect1)
    );

    println!(
        "The area of the rectangle is {} square pixels.",
        rect1.area()
    );

    // output: rect1 is Rectangle { width: 30, height: 50 }
    // println!("rect1 is {:?}", rect1);

    // output: rect1 is Rectangle {
    //     width: 30,
    //     height: 50,
    // }
    println!("rect1 is {:#?}", rect1);

    let rect2 = Rectangle::square(80);
    println!("rect2 is {:#?}", rect2);
}

fn area(rectangle: &Rectangle) -> u32 {
    rectangle.height * rectangle.width
}