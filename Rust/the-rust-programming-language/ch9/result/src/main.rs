use std::fs::File;
use std::io::{Error, ErrorKind, Read};
use std::{io, fs};

fn main() {
    let f = File::open("hello.txt");
    let f = match f {
        Ok(file) => file,
        Err(error) => match error.kind() {
            ErrorKind::NotFound => match File::create("hello.txt") {
                Ok(fc) => fc,
                Err(e) => panic!("Problem creating the file: {:?}", e)
            },
            other_err => panic!("Problem opening the file: {:?}", other_err),
        },
    };

    let f = File::open("hello.txt").unwrap();
    let f = File::open("Hello.txt").expect("Failed to open hello.txt");
}

fn read_username_from_file() -> Result<String, io::Error> {
    let f = File::open("hello.txt");

    let mut f = match f {
        Ok(file) => file,
        Err(e) => return Err(e), // 向上传播错误
    };

    let mut s = String::new();

    match f.read_to_string(&mut s) {
        Ok(_) => Ok(s),
        Err(e) => Err(e),
    }
}

fn read_username_from_file_simple() -> Result<String, io::Error> {
    // ? 表达式，如果 Result 的值是 Ok，这个表达式将会返回 Ok 中的值继续执行，
    // 如果是 Err，Err 的值将作为整个函数的返回值，这样错误被传播给了调用者
    let mut f = File::open("hello.txt")?;
    let mut s = String::new();
    f.read_to_string(&mut s)?;
    Ok(s)
}

fn read_username_from_file_simple_chain() -> Result<String, io::Error> {
    let mut s = String::new();

    File::open("hello.txt")?.read_to_string(&mut s)?;
    Ok(s)
}

fn read_username_from_file_simple_plus() -> Result<String, io::Error> {
    fs::read_to_string("hello.txt")
}
