package com.example.database.mapper;

import com.example.database.model.BlogLabel;
import com.example.database.model.SetBlogLabel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SetBlogLabelMapper {

    @Insert("insert into blable (blogID,labelID) values(#{blogID},#{labelID})")
    void insertBlogLabel(SetBlogLabel setBlogLabel);

    @Delete("delete from blable where blogID=#{blogID}")
    void deleteBlogTag(Integer blogID);

    @Select("select blogID from blable where labelID =#{id}")
    List<Integer> findByTagID(@Param("id") int id);

    @Select("select count(*) from blable where labelID =#{id}")
    int countTagBlog(@Param("id") int id);
}
