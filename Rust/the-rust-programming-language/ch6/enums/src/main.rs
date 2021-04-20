enum IpAddrKind {
    V4,
    V6,
}

struct IpAddr {
    kind: IpAddrKind,
    address: String,
}

// 枚举的每个成员可以处理不同类型和数量的数据
enum IpAddrPlus {
    V4(u8, u8, u8, u8),
    V6(String),
}

enum Message {
    Quit,
    Move { x: i32, y: i32 },
    Write(String),
    ChangeColor(i32, i32, i32),
}

impl Message {
    fn call(&self) {
        println!("Call");
    }
}

fn main() {
    let four = IpAddrKind::V4;
    let six = IpAddrKind::V6;

    route(four);

    let home = IpAddr {
        kind: IpAddrKind::V4,
        address: String::from("127.0.0.1"),
    };

    let loopback = IpAddr {
        kind: IpAddrKind::V6,
        address: String::from("::1"),
    };

    let home = IpAddrPlus::V4(127, 0, 0, 1);
    let loopback = IpAddrPlus::V6(String::from("::1"));

    // Optional
    let some_number = Some(5);
    let some_string = Some("a string");

    let absent_number: Option<i32> = None;
}

fn route(ip_type: IpAddrKind) {}