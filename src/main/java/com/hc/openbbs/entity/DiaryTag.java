package com.hc.openbbs.entity;

/**
 * @author yg
 * @create 2018-02-05 16:32
 * @desc 文章与标签
 **/
public class DiaryTag {
    private Long id;
    private Long  diaryId;
    private Long  tagId;
    private String extras;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiaryTag() {
    }

    public Long getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Long diaryId) {
        this.diaryId = diaryId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "DiaryTagService{" +
                "diaryId=" + diaryId +
                ", tagId=" + tagId +
                ", extras='" + extras + '\'' +
                '}';
    }
}
