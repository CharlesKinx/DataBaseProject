package com.example.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class PublishBlog {
    @RequestMapping("/publish")
    public String index(){
        return "publish";
    }
}
