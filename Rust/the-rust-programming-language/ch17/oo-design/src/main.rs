use oo_design::blog::Post; // package 名字是 oo-design 这里访问需要下划线来表示，手动指定包的名字

fn main() {
    let mut post = Post::new();
    
    post.add_text("I ate a salad for lunch today");
    assert_eq!("", post.content());
    
    post.request_review();
    assert_eq!("", post.content());
    
    post.approve();
    assert_eq!("I ate a salad for lunch today", post.content());
}
