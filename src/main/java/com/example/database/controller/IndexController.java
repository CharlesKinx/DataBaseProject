package com.example.database.controller;

import com.example.database.model.User;
import com.example.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @GetMapping("/index")
    public String doIndex(HttpServletRequest httpServletRequest,
                          Model model){
        HttpSession session = httpServletRequest.getSession();
        User user = (User)session.getAttribute("user");
        model.addAttribute("user",user);
        return "/index";
    }

    @PostMapping("/index")
    public String changeInfo(
            HttpServletRequest httpServletRequest,
            Model model,
            @RequestParam(value = "telephone",required=false) String telephone,
            @RequestParam(value = "name",required=false) String name,
            @RequestParam(value = "age",required=false) String age,
            @RequestParam(value = "education",required=false) String education,
            @RequestParam(value = "statement",required=false) String statement,
            @RequestParam(value = "password",required=false) String password,
            @RequestParam(value = "password1",required=false) String password1){

        HttpSession session = httpServletRequest.getSession();
        User user = (User)session.getAttribute("user");

        model.addAttribute("user",user);
        model.addAttribute("telephone",telephone);
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("education",education);
        model.addAttribute("statement",statement);
        model.addAttribute("password",password);
        model.addAttribute("password1",password1);


        if(telephone !=null && telephone !=""){
            user.setTelephone(telephone);
        }
        if(name!= null&& name!=""){
            user.setName(name);
        }
        if(age!=null && age!=""){
            user.setAge(Integer.parseInt(age));
        }
        if(education!=null &&education!=""){
            user.setEducation(education);
        }
        if(statement!=null&&statement!=""){
            user.setStatement(statement);
        }

        if(!password.equals(password1)){
            model.addAttribute("error", "两次密码不一样！");
            return "/index";
        }else if(password!=null&&password!=""){
            user.setPassword(password);
        }
        userService.createOrUpdate(user);
        return "/index";
    }


}
