package com.hc.openbbs.entity;

/**
 * @author yg
 * @create 2018-01-30 13:18
 * @desc 文章查找实体类
 **/
public class BbsQuery {
    //文章标题
    private String title;
    //文章分类id
    private Long typeId;
    //文章评论
    private boolean recommend;

    public BbsQuery() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }
}
