package com.example.database.controller;

import com.example.database.dto.MyDynamicDTO;
import com.example.database.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable(name = "id") Integer id,
                       Model model){

        MyDynamicDTO myDynamicDTO = blogService.findByID(id);
        model.addAttribute("myBlog",myDynamicDTO);

        return "blog";
    }
}
