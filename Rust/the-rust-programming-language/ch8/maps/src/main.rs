use std::collections::HashMap;
use std::hash::Hash;

fn main() {
    let mut scores = HashMap::new();
    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Yellow"), 50);

    let teams = vec![String::from("Blue"), String::from("Yellow")];
    let initial_score = vec![10, 50];

    // PS 可以用下划线占位，Rust 会自动推断
    let scores: HashMap<&String, &i32> = teams.iter().zip(initial_score.iter()).collect();

    let mut scores = HashMap::new();

    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Yellow"), 50);

    let team_name = String::from("Blue");
    let score = scores.get(&team_name); // option

    for (key, value) in &scores {
        println!("{}: {}", key, value);
    }

    let mut scores = HashMap::new();
    scores.insert(String::from("Blue"), 10);
    let old = scores.entry(String::from("Yellow")).or_insert(50);
    *old += 1;
    scores.entry(String::from("Blue")).or_insert(100);
    for (key, value) in &scores {
        println!("{}: {}", key, value);
    }
}
