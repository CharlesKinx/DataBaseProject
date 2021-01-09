package com.example.database.controller;

import com.example.database.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println(user);
        return "index";
    }
}
