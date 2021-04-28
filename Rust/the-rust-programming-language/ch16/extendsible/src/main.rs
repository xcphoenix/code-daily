fn main() {
    
    // trait 定义行为
    // trait 对象指向一个实现了 trait 类型的实例
    // trait 对象必须使用指针
    
    let screen = Screen {
        components: vec![
            Box::new(SelectBox {}),
            Box::new(Button {}),
        ],
    };
    screen.run();
}

pub trait Draw {
    fn draw(&self);
}

// 如果使用泛型，那么 components 里面只能有一种类型
pub struct Screen {
    pub components: Vec<Box<dyn Draw>>,
}

impl Screen {
    pub fn run(&self) {
        for component in self.components.iter() {
            component.draw();
        }
    }
}

pub struct Button {}

impl Draw for Button {
    fn draw(&self) {
        println!("Draw button!");
    }
}

pub struct SelectBox {}

impl Draw for SelectBox {
    fn draw(&self) {
        println!("Draw select box!");
    }
}

