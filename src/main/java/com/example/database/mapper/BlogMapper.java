package com.example.database.mapper;

import com.example.database.model.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface BlogMapper {

    @Insert("insert into blog (title,description,creator,time,introduce) values(#{title},#{description},#{creator},#{gmtCreate},#{introduce})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createBlog(Blog blog);

    @Select("select *from blog where id =#{id}" )
    Blog findBlogByID(@Param(value = "id") Integer id);

    @Select("select * from blog where creator =#{userId}")
    List<Blog> listByUserID(@Param(value = "userId") Integer userId);
}
