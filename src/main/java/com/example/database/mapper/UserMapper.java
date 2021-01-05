package com.example.database.mapper;

import com.example.database.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into user (account,name,telephone,password) values(#{account},#{name},#{telephone},#{password})")
    void create(User user);


}
