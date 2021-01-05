package com.example.database.service;

import com.example.database.mapper.UserMapper;
import com.example.database.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user){
        if(user.getId() == null){
            userMapper.create(user);
        }else {

        }
    }


}
