package com.hc.openbbs.entity;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

/**
 * @author yg
 * @create 2018-01-10 12:04
 * @desc 分类管理
 **/
public class Type {
    private Long id;
    //@NotBlank(message = "分类名称不能为空")
    private String typeName;
    //文章个数
    private int diaryCount;
    //文章
    private List<Diary> diarys;
    //构造类
    public Type() {}
    public Type(String typeName) {
        this.typeName=typeName;
    }
    //get/set
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getDiaryCount() {
        return diaryCount;
    }

    public void setDiaryCount(int diaryCount) {
        this.diaryCount = diaryCount;
    }

    public List<Diary> getDiarys() {
        return diarys;
    }

    public void setDiarys(List<Diary> diarys) {
        this.diarys = diarys;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", diaryCount=" + diaryCount +
                ", diarys=" + diarys +
                '}';
    }
}
