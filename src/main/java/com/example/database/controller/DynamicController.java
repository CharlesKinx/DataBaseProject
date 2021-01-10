package com.example.database.controller;

import com.example.database.dto.MyDynamicDTO;
import com.example.database.model.Blog;
import com.example.database.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Base64;

@Controller
public class DynamicController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/dynamic")
    public String index(){




        return "dynamic";
    }



}
