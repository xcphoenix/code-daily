struct User {
    username: String,
    email: String,
    sign_in_count: u64,
    active: bool,
}

fn main() {
    let mut user1 = User {
        email: String::from("someone@example.com"),
        username: String::from("someusername123"),
        active: true,
        sign_in_count: 1,
    };
    user1.email = String::from("anothemail@example.com");

    // 字符串字面量是 &str，参数则需要 String
    let user2 = build_user("new email".to_string(), "new username".to_string());

    // .. 语法指定了剩余未显式设置值的字段应有与给定实例对应字段相同的值。
    let user2 = User {
        email: String::from("another@example.com"),
        username: String::from("anotherusername567"),
        ..user1
    };

    // 元组结构体，为元组名称提供具体的含义
    struct Color(i32, i32, i32);
    struct Point(i32, i32, i32);

    let black = Color(0, 0, 0);
    let origin = Point(0, 0, 0);
    
}

fn build_user(email: String, username: String) -> User {
    // User {
    //     email: email,
    //     username: username,
    //     active: true,
    //     sign_in_count: 1,
    // }

    // 如果参数与字段同名，可以用简写语法
    User {
        email,
        username,
        active: true,
        sign_in_count: 1,
    }
}
