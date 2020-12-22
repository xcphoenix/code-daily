package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.view.Show;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.View;

/**
 * @author      xuanc
 * @date        2019/12/9 下午8:52
 * @version     1.0
 */
@RestController
public class EchoController {

    @GetMapping("/test")
    public User test() {
        User user = new User();
        user.setId(1);
        user.setUsername("lala");
        user.setPassword("haha");
        user.add("newField", "new Field");

        return user;
    }

}
