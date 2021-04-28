use std::sync::{Mutex, Arc};
use std::thread;
use std::rc::Rc;

fn main() {
    // Arc 并发安全
    let counter = Arc::new(Mutex::new(0));
    let mut handles = vec![];
    
    for _ in 0..10 {
        // 这里所有权被转移
        let counter = Arc::clone(&counter);
        let handle = thread::spawn(move || {
            let mut num = counter.lock().unwrap();
            // Mutex 提供了内部可变性，所以这里可以改变值
            *num += 1;
        });
        handles.push(handle);
    }
    
    for handle in handles {
        handle.join().unwrap();
    }
    
    println!("Result: {}", counter.lock().unwrap());
}
