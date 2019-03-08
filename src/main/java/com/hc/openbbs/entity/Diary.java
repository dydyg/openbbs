package com.hc.openbbs.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yg
 * @create 2018-01-10 13:10
 * @desc 论坛管理实体类
 **/
public class Diary {
    //id
    private Long id;
    //文章标题
    private String title;
    //文章描述
    private String description;
    //文章内容
    private String content;
    //首图
    private String firstPicture;
    //标记（原创、转载）
    private String flag;
    //浏览次数
    private Integer views;
    //赞赏是否开启
    private boolean appreciation;
    //转载声明是否开启
    private boolean shareStatement;
    //评论是否开启
    private boolean commentabled;
    //是否发布，还是草稿
    private boolean published;
    //是否推荐
    private boolean recommend;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //分类id
    private  Long typeId;
    //用户Id
    private  Long userId;

    //文章与分类、标签、用户、评论实体关系
    //分类：一篇文章对应一个分类
    private Type type;
    //标签:一篇文章对应多个标签
    private List<Tag> tags;
    //用户：一篇文章对应一个用户
    private User user;
    //评论：一篇文章对应多个评论
    private List<Comment> comments;
   //获取标签ids
    private String tagIds;
    public Diary(){

    }

    //生成get/set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
   //实体生成get/set
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        //mybatis赋值tags
        this.tags = tags;
        //在实体类中将tags赋值给tagIds
        this.tagIds = tagsToIds(this.getTags());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }


    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    //类初始化----初始化没起作用
    /*public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }*/
    //1,2,3-获取tags
    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;

        }
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", typeId='" + typeId + '\'' +
                ", userId='" + userId + '\'' +
                ", type=" + type +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                ", tagIds='" + tagIds + '\'' +
                '}';
    }
}
