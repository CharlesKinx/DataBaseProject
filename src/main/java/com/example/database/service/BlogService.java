package com.example.database.service;


import com.example.database.dto.MyDynamicDTO;
import com.example.database.mapper.BlogMapper;
import com.example.database.model.Blog;
import com.example.database.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;

    public void createOrUpdateBlog(Blog blog){
        if(blog.getId()==null){
            blogMapper.createBlog(blog);
            System.out.println(blog.getId());
        }else{

        }
    }
    public List<MyDynamicDTO> blogList(User user){

        List<Blog> blogList = blogMapper.listByUserID(user.getId());
        List<MyDynamicDTO> myDynamicDTOS =new ArrayList<>();

        for(Blog blog : blogList){


        }

        return myDynamicDTOS;
    }

    public Blog findById(int id){
        Blog blog = blogMapper.findBlogByID(id);
        return blog;
    }

}
