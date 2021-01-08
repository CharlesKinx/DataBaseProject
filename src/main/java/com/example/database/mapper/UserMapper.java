package com.example.database.mapper;

import com.example.database.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user (account,name,telephone,password) values(#{account},#{name},#{telephone},#{password})")
    void create(User user);

    @Select("select * from user where account=#{account}")
    User findByAccount(@Param("account") String account);

}
