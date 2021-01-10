package com.example.database.controller;

import com.example.database.model.Blog;
import com.example.database.model.User;
import com.example.database.service.BlogService;
import com.example.database.service.SetBlogLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller

public class PublishBlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private SetBlogLabelService setBlogLabelService;

    @RequestMapping("/publish")
    public String index(){
        return "publish";
    }


    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("introduce") String introduce,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model) {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空！");
            return "publish";
        }
        if (introduce == null || introduce == "") {
            model.addAttribute("error", "简介不能为空！");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "内容不能为空！");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空！");
            return "publish";
        }

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setDescription(description);
        blog.setIntroduce(introduce);
        blog.setGmtCreate(System.currentTimeMillis());
        blog.setCreator(user.getId());
        blogService.createOrUpdateBlog(blog);
        setBlogLabelService.setBlogLabel(tag,blog.getId());
        return "redirect:/publish";
    }
}
