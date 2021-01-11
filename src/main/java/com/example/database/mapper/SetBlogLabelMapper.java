package com.example.database.mapper;

import com.example.database.model.BlogLabel;
import com.example.database.model.SetBlogLabel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SetBlogLabelMapper {

    @Insert("insert into blable (blogID,labelID) values(#{blogID},#{labelID})")
    void insertBlogLabel(SetBlogLabel setBlogLabel);

    @Delete("delete from blable where blogID=#{blogID}")
    void deleteBlogTag(SetBlogLabel setBlogLabel);
}
