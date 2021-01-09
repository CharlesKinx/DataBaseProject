package com.example.database.mapper;

import com.example.database.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user (account,name,telephone,password) values(#{account},#{name},#{telephone},#{password})")
    void create(User user);

    @Select("select * from user where account=#{account}")
    User findByAccount(@Param("account") String account);

    @Update("update user set telephone=#{telephone},name=#{name},age =#{age},education =#{education},statement=#{statement},password = #{password} where id =#{id}")
    void updateInfo(User user);

}
