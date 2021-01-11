package com.example.database.mapper;

import com.example.database.model.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface BlogMapper {

    @Insert("insert into blog (title,description,creator,time,introduce) values(#{title},#{description},#{creator},#{time},#{introduce})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createBlog(Blog blog);

    @Select("select *from blog where id =#{id}" )
    Blog findBlogByID(@Param(value = "id") Integer id);

    @Select("select * from blog")
    List<Blog> list();

    @Update("update blog set title = #{title}, description = #{description},introduce = #{introduce},time = #{time} where id=#{id}")
    void updateBlog(Blog blog);
}
