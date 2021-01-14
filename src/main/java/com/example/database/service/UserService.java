package com.example.database.service;

import com.example.database.mapper.BlogMapper;
import com.example.database.mapper.UserMapper;
import com.example.database.model.Blog;
import com.example.database.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BlogMapper blogMapper;

    public void createOrUpdate(User user){
        if(user.getId() == null){
            userMapper.create(user);
        }else {
            userMapper.updateInfo(user);
        }
    }

    public User findByAccount(String account){
        User userInfo = userMapper.findByAccount(account);
        return userInfo;
    }

    public boolean isExitAccount(String account){
        List<User> userList= userMapper.findAllUser();
        for(User user:userList){
            if(user.getAccount().equals(account)){
                return true;
            }
        }
        return false;
    }

    public int getReadNums(int userID){
        List<Blog> blogList = userMapper.userBlogList();
        int userReadNums = 0;
        for(Blog blog:blogList){
            userReadNums += blog.getReadnums();
        }
        return userReadNums;
    }

}
