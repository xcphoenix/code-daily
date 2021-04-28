pub struct Post {
    state: Option<Box<dyn State>>,
    content: String,
}

impl Post {
    pub fn new() -> Post {
        Post {
            state: Some(Box::new(Draft {})),
            content: String::new(),
        }
    }
    
    pub fn add_text(&mut self, text: &str) {
        self.content.push_str(text);
    }
    
    pub fn content(&self) -> &str {
        self.state.as_ref().unwrap().content(self)
    }
    
    pub fn request_review(&mut self) {
        // take 取出 Some 值，并留下一个 None
        if let Some(s) = self.state.take() {
            self.state = Some(s.request_review())
        }
    }
    
    pub fn approve(&mut self) {
        if let Some(s) = self.state.take() {
            self.state = Some(s.approve())
        }
    }
}

pub trait State {
    /// `Box<Self>` 意味着这个方法调用只对这个类型的 Box 有效，
    /// 同时获取了 `Box<Self>` 的所有权，使老状态无效
    fn request_review(self: Box<Self>) -> Box<dyn State>;
    
    fn approve(self: Box<Self>) -> Box<dyn State>;
    
    fn content<'a>(&self, _post: &'a Post) -> &'a str {
        ""
    }
}

pub struct Draft {}

impl State for Draft {
    fn request_review(self: Box<Self>) -> Box<dyn State> {
        Box::new(PendingReview {})
    }
    
    fn approve(self: Box<Self>) -> Box<dyn State> {
        self
    }
}

pub struct PendingReview {}

impl State for PendingReview {
    fn request_review(self: Box<Self>) -> Box<dyn State> {
        self
    }
    
    fn approve(self: Box<Self>) -> Box<dyn State> {
        Box::new(Published {})
    }
}

pub struct Published {}

impl State for Published {
    fn request_review(self: Box<Self>) -> Box<dyn State> {
        self
    }
    
    fn approve(self: Box<Self>) -> Box<dyn State> {
        self
    }
    
    fn content<'a>(&self, post: &'a Post) -> &'a str {
        &post.content
    }
}
