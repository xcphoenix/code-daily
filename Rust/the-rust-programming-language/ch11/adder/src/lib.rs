#[derive(Debug)]
struct Rectangle {
    width: u32,
    height: u32,
}

impl Rectangle {
    fn can_hold(&self, other: &Rectangle) -> bool {
        self.width > other.width && self.height > other.height
    }
}

#[cfg(test)] // 测试模块, 只有执行测试的时候才编译和运行测试代码
mod tests {
    
    use super::Rectangle;
    
    // `#[test]` 表示这是一个测试函数
    #[test]
    fn exploration() {
        assert_eq!(2 + 2, 4);
    }
    
    #[test]
    #[should_panic(expected = "EEMake the test fail")]
    // 表示测试期望出现 panic
    // expected 确保错误信息中包含提供的文本，例如这样就不匹配，仍然会测试失败
    fn another() {
        panic!("Make the test fail");
    }
    
    #[test]
    fn larger_can_hold_smaller() {
        let larger = Rectangle {width: 8, height:7};
        let smaller = Rectangle {width: 5, height: 1};
        
        // assert!(larger.can_hold(&smaller));
        assert!(!larger.can_hold(&smaller), "custom error message: {:?}", smaller);
    }
    
    #[test]
    // 注意返回 Result<T, E> 的函数体，作为测试时，不用使用 #[should_panic] 注解
    // 返回 Err 表示测试失败
    // 如果 Err 返回的是一个字符串，会显示字符串信息
    fn it_works() -> Result<(), String> {
        if 2 + 2 != 4 {
            Ok(())
        } else {
            Err(String::from("tow plus tow does not equal four"))
            // Err(0)
        }
    }
    
    
}
