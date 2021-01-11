package com.example.database.service;

import com.example.database.mapper.SetBlogLabelMapper;
import com.example.database.model.Blog;
import com.example.database.model.SetBlogLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SetBlogLabelService {

    @Autowired
    private SetBlogLabelMapper setBlogLabelMapper;

    public List<Integer> spiltTag(String label){

        String[] labels = label.split(" ");
        List<Integer> labelList = new ArrayList<>();

        for(String tag:labels){
            if(tag.equals("Java") || tag.equals("JAVA")||tag.equals("java")){
                labelList.add(1);
                break;
            }
            if(tag.equals("Python") || tag.equals("PYTHON")|| tag.equals("python")){
                labelList.add(2);
                break;
            }
            if(tag.equals("Web开发") ){
                labelList.add(3);
                break;
            }
            if(tag.equals("计算机视觉")){
                labelList.add(4);
                break;
            }
            if(tag.equals("Android") || tag.equals("ANDROID")|| tag.equals("android")){
                labelList.add(5);
                break;
            }
            labelList.add(6);
        }

        return labelList;

    }

    public void createBlogTag(SetBlogLabel setBlogLabel){
        if(setBlogLabel.getBlogID() == null){
            setBlogLabelMapper.insertBlogLabel(setBlogLabel);
        }else{
            setBlogLabelMapper.deleteBlogTag(setBlogLabel);
            setBlogLabelMapper.insertBlogLabel(setBlogLabel);
        }
    }

    public void setBlogLabel(String label, int blogID){

        List<Integer> labelList = spiltTag(label);
        for(int tag:labelList){
            SetBlogLabel setBlogLabel =new SetBlogLabel();
            setBlogLabel.setBlogID(blogID);
            setBlogLabel.setLabelID(tag);
            createBlogTag(setBlogLabel);
        }

    }
}
