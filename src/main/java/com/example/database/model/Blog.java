package com.example.database.model;

public class Blog {

    private String title;
    private Integer id;
    private String description;
    private Long time;
    private Integer creator;
    private String introduce;
    private int readnums;

    public int getReadnums() {
        return readnums;
    }

    public void setReadnums(int readnums) {
        this.readnums = readnums;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", gmtCreate=" + time +
                ", creator=" + creator +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
