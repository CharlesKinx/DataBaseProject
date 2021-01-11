package com.example.database.dto;

import java.util.List;

public class AllBlogsDTO {
    private List<MyDynamicDTO> myDynamicDTOS;

    public List<MyDynamicDTO> getMyDynamicDTOS() {
        return myDynamicDTOS;
    }

    public void setMyDynamicDTOS(List<MyDynamicDTO> myDynamicDTOS) {
        this.myDynamicDTOS = myDynamicDTOS;
    }
}
