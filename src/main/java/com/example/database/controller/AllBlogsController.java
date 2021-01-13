package com.example.database.controller;

import com.example.database.dto.AllBlogsDTO;
import com.example.database.model.User;
import com.example.database.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;

@Controller
public class AllBlogsController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/allBlogs/{action}")
    public String allBlogs(Model model,
                           @PathVariable(name = "action") String action,
                           HttpServletRequest request){

        HttpSession httpSession = request.getSession();
        User user = (User)httpSession.getAttribute("user");

        if("java".equals(action)){
            AllBlogsDTO allBlogsDTO = blogService.categoryBlogsList(1, user.getId());
            model.addAttribute("section", "java");
            model.addAttribute("sectionName","我的Java类型相关博客");
            model.addAttribute("allBlogsList",allBlogsDTO);

        }
        if("web".equals(action)){
            AllBlogsDTO allBlogsDTO = blogService.categoryBlogsList(3, user.getId());
            model.addAttribute("section", "web");
            model.addAttribute("sectionName","我的Web开发类型相关博客");
            model.addAttribute("allBlogsList",allBlogsDTO);

        }
        if("python".equals(action)){
            AllBlogsDTO allBlogsDTO = blogService.categoryBlogsList(2, user.getId());
            model.addAttribute("section", "python");
            model.addAttribute("sectionName","我的Python类型相关博客");
            model.addAttribute("allBlogsList",allBlogsDTO);

        }
        if("android".equals(action)){
            AllBlogsDTO allBlogsDTO = blogService.categoryBlogsList(5, user.getId());
            model.addAttribute("section", "android");
            model.addAttribute("sectionName","我的Android类型相关博客");
            model.addAttribute("allBlogsList",allBlogsDTO);

        }
        if("cv".equals(action)){
            AllBlogsDTO allBlogsDTO = blogService.categoryBlogsList(4, user.getId());
            model.addAttribute("section", "cv");
            model.addAttribute("sectionName","我的计算机视觉类型相关博客");
            model.addAttribute("allBlogsList",allBlogsDTO);

        }
        if("others".equals(action)){
            AllBlogsDTO allBlogsDTO = blogService.categoryBlogsList(6, user.getId());
            model.addAttribute("section", "others");
            model.addAttribute("sectionName","我的其他博客");
            model.addAttribute("allBlogsList",allBlogsDTO);

        }
        if("all".equals(action)){
            model.addAttribute("section", "all");
            model.addAttribute("sectionName","博客主页");
            AllBlogsDTO allBlogsDTO = blogService.allBlogsDTOList();
            model.addAttribute("allBlogsList",allBlogsDTO);
        }

        return "allBlogs";
    }

}
