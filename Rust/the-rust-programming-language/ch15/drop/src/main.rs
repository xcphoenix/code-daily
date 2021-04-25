struct CustomSmartPointer {
    data: String,
}

impl Drop for CustomSmartPointer {
    fn drop(&mut self) {
        println!("Dropping CustomSmartPointer with data: {}!", self.data);
    }
}

fn main() {
    let c = CustomSmartPointer {data: String::from("my stuff")};
    let d = CustomSmartPointer {data: String::from("other stuff")};
    println!("CustomSmartPointer created");
    // 可以提前释放值，但不能显示调用 c.drop() 这回造成 double free 因为作用域
    // 结束后仍然会调用一次 drop
    // 可以使用 `std::mem::drop()` 来提前释放
    std::mem::drop(c);  // 其实也就是将值放入一个空的作用域直接释放掉
}
