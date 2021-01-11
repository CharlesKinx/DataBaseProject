package com.example.database.service;


import com.example.database.dto.AllBlogsDTO;
import com.example.database.dto.MyDynamicDTO;
import com.example.database.mapper.BlogMapper;
import com.example.database.mapper.UserMapper;
import com.example.database.model.Blog;
import com.example.database.model.User;
import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdateBlog(Blog blog){
        if(blog.getId()==null){
            blogMapper.createBlog(blog);
        }else{
            blog.setTime(System.currentTimeMillis());
            blogMapper.updateBlog(blog);
        }
    }

    public List<MyDynamicDTO> blogList(){
        List<MyDynamicDTO> myDynamicDTOS = new ArrayList<>();
        List<Blog> blogList = blogMapper.list();

        for(Blog blog :blogList){
            User user = userMapper.findById(blog.getCreator());
            MyDynamicDTO myDynamicDTO = new MyDynamicDTO();
            myDynamicDTO.setUser(user);
            BeanUtils.copyProperties(blog,myDynamicDTO);
            myDynamicDTOS.add(myDynamicDTO);
        }

        return myDynamicDTOS;
    }

    public AllBlogsDTO allBlogsDTOList(){
        AllBlogsDTO allBlogsDTO = new AllBlogsDTO();
        allBlogsDTO.setMyDynamicDTOS(blogList());
        return allBlogsDTO;
    }

    public MyDynamicDTO findByID(int id){
        Blog blog =blogMapper.findBlogByID(id);
        MyDynamicDTO myDynamicDTO = new MyDynamicDTO();
        BeanUtils.copyProperties(blog,myDynamicDTO);
        User user = userMapper.findById(blog.getCreator());
        myDynamicDTO.setUser(user);
        return myDynamicDTO;
    }

    public Blog findById(int id){
        Blog blog = blogMapper.findBlogByID(id);
        return blog;
    }

}
