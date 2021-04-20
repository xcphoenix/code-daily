enum Coin {
    Penny,
    Nickel,
    Dime,
    Quarter(UsState),
}

#[derive(Debug)]
enum UsState {
    Alabama,
    Alaska,
    // --snip--
}

fn main() {
    let cents = value_in_cents(Coin::Quarter(UsState::Alabama));
    let some_u8_value = Option::Some(8u8);
    if let Some(3) = some_u8_value {
        println!("three");
    } else {
        println!("value: {}", some_u8_value.unwrap())
    }
}

fn value_in_cents(coin: Coin) -> u8 {
    match coin {
        Coin::Penny => {
            println!("Lucky penny!");
            1
        }
        Coin::Nickel => 5,
        Coin::Dime => 10,
        Coin::Quarter(state) => {
            println!("State quarter from {:#?}!", state);
            25
        },
    }
}
