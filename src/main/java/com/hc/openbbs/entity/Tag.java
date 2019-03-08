package com.hc.openbbs.entity;

import java.util.List;

/**
 * Created by limi on 2017/10/14.
 */
public class Tag {

    private Long id;
    private String name;
    //实体关系
   // private List<Diary> diary;
    //文章数量
    private  int diaryCount;
    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiaryCount() {
        return diaryCount;
    }

    public void setDiaryCount(int diaryCount) {
        this.diaryCount = diaryCount;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
