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

    @Select("select * from blog where creator = #{creator}")
    List<Blog> userBlogsList(@Param(value ="creator") Integer creator);

    @Select("select * from blog where id=#{id} and creator = #{creator}")
    Blog userBlogList(@Param(value = "id") Integer id,@Param(value = "creator") Integer creator);

    @Delete("delete from blog where id=#{blogID}")
    void deleteBlogByID(@Param(value = "blogID") Integer blogID);


    @Update("update blog set title = #{title}, description = #{description},introduce = #{introduce},time = #{time} where id=#{id}")
    void updateBlog(Blog blog);

    @Update("update blog set readnums = #{readnums} where id=#{id}")
    void updateBlogReadNums(Blog blog);
}
