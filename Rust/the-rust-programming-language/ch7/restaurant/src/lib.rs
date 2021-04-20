// 嵌套路径
//use std::io::{self, Write};

mod front_of_house {
    // pub 表示公有，默认都是私有的
    pub mod hosting {
        pub fn add_to_waitlist() {}
        //fn seat_at_table() {}
    }
    //
    //mod serving {
    //    fn take_order() {}
    //
    //    fn server_order() {}
    //
    //    fn take_payment() {}
    //}
}

fn server_order() {}

mod back_of_house {
    pub struct Breakfast {
        pub toast: String,
        seasonal_first: String,
    }

    impl Breakfast {
        pub fn summer(toast: &str) -> Breakfast {
            Breakfast {
                toast: String::from(toast),
                seasonal_first: String::from("peaches"),
            }
        }
    }

    // 枚举前加 pub，所有的成员都会变成公有
    pub enum Appetizer {
        Soup,
        Salad,
    }

    fn fix_incorrect_order() {
        cook_order();
        super::server_order();
    }

    fn cook_order() {}
}

pub fn eat_at_restaurant() {
    //// Absolute path
    //crate::front_of_house::hosting::add_to_waitlist();
    //
    //// Relative path
    //front_of_house::hosting::add_to_waitlist();

    let mut meal = back_of_house::Breakfast::summer("Rye");
    meal.toast = String::from("Wheat");
    println!("I'd like {} toast please", meal.toast);

    let order1 = back_of_house::Appetizer::Salad;
    let order2 = back_of_house::Appetizer::Soup;
}