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
                continue;
            }
            if(tag.equals("Python") || tag.equals("PYTHON")|| tag.equals("python")){
                labelList.add(2);
                continue;
            }
            if(tag.equals("Web开发") || tag.equals("web")){
                labelList.add(3);
                continue;
            }
            if(tag.equals("计算机视觉")|| tag.equals("cv")|| tag.equals("CV")){
                labelList.add(4);
                continue;
            }
            if(tag.equals("Android") || tag.equals("ANDROID")|| tag.equals("android")){
                labelList.add(5);
                continue;
            }
            labelList.add(6);
        }
        return labelList;

    }

    public List<Integer> findByTagID(Integer id){
        List<Integer> tagList = setBlogLabelMapper.findByTagID(id);
        return tagList;
    }


    public void updateSetBlogTags(List<SetBlogLabel> setBlogLabels){
        for(SetBlogLabel setBlogLabel:setBlogLabels){
            setBlogLabelMapper.insertBlogLabel(setBlogLabel);
        }
    }

    public void setBlogLabel(String label, Integer blogID){
        List<Integer> labelList = spiltTag(label);
        List<SetBlogLabel> setBlogLabels = new ArrayList<>();
        for(int tag:labelList){
            SetBlogLabel setBlogLabel =new SetBlogLabel();
            setBlogLabel.setBlogID(blogID);
            setBlogLabel.setLabelID(tag);
            setBlogLabels.add(setBlogLabel);
        }

        if(blogID == null){
            updateSetBlogTags(setBlogLabels);
        }else {
            setBlogLabelMapper.deleteBlogTag(blogID);
            updateSetBlogTags(setBlogLabels);
        }
    }



}
