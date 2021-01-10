package com.example.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable(name = "id") Integer id,
                       Model model){


        return "blog";
    }
}
