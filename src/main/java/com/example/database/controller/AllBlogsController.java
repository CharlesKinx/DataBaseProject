package com.example.database.controller;

import com.example.database.dto.AllBlogsDTO;
import com.example.database.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllBlogsController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/allBlogs")
    public String allBlogs(Model model){

        AllBlogsDTO allBlogsDTO = blogService.allBlogsDTOList();

        model.addAttribute("allBlogsList",allBlogsDTO);
        return "/allBlogs";
    }

}
