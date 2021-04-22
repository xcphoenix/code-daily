fn main() {
    let number_list = vec![34, 50, 25, 100, 65];

    let result = largest(&number_list);
    println!("The largest number is {}", result);

    let number_list = vec![102, 34, 6000, 89, 54, 2, 43, 8];

    let result = largest(&number_list);
    println!("The largest number is {}", result);
}

struct Point<T> {
    x: T,
    y: T,
}

// 要在 impl 后声明泛型 T, 这样才知道他是一个泛型
impl<T> Point<T> {
    fn x(&self) -> &T {
        &self.x
    }
}

// 只有 Point<f32> 才拥有的方法
impl Point<f32> {
    fn distance_from_origin(&self) -> f32 {
        (self.x.powi(2) + self.y.powi(2)).sqrt()
    }
}

//fn largest_generic<T>(list: &Vec<T>) -> T {
//
//}

// `&[i32]` slice
fn largest(list: &[i32]) -> i32 {
    let mut largest = list[0];

    for &item in list {
        if item > largest {
            largest = item;
        }
    }

    largest
}
