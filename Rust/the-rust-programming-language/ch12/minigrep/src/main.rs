use std::{env, process};

use minigrep::Config;

fn main() {
    // unwrap_or_else 当值为 Err 时，调用一个闭包，将定义的参数传递给
    // unwrap_or_else 的匿名函数
    let config = Config::new(env::args()).unwrap_or_else(|err| {
        eprintln!("Problem parsing arguments: {}", err);
        process::exit(1);
    });
    
    // if let 简写
    if let Err(e) = minigrep::run(config) {
        eprintln!("Application error: {}", e);

        process::exit(1);
    }
}