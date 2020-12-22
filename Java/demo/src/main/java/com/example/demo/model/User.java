package com.example.demo.model;

import com.example.demo.view.Show;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author      xuanc
 * @date        2019/12/9 下午8:51
 * @version     1.0
 */
@Data
public class User {

    @JsonView(Show.class)
    private int id;
    @JsonView(Show.class)
    private String username;
    private String password;

    private Map<String, Object> mapAttrs = new HashMap<>();

    public String getExtra(String str) {
        return str;
    }

    @JsonAnySetter
    public void add(String property, Object value) {
        mapAttrs.put(property, value);
    }

}
