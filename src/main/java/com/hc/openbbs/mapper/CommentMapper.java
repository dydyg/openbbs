package com.hc.openbbs.mapper;

import com.hc.openbbs.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yg
 * @create 2018-02-02 15:00
 * @desc 评论
 **/
public interface CommentMapper {

    @Select("SELECT id,avatar,content,create_time as createTime,email,nickname,admin_comment as adminComment,diary_id as diaryId FROM BBS_COMMENT WHERE DIARY_ID = #{diaryId} ORDER BY CREATE_TIME DESC")
    List<Comment> findCommentByDiaryId(@Param("diaryId") Long diaryId);

    // 保存插入评论
    @Insert("INSERT INTO BBS_COMMENT(avatar,content,create_time,email,nickname,admin_comment,diary_id,parent_comment_id) VALUES (#{avatar},#{content},#{createTime},#{email},#{nickname},#{adminComment},#{diaryId},#{parentCommentId})")
    public int addComment(Comment comment);

    //根据父级评论内容id，获取内容
    @Select("SELECT id,avatar,content,create_time as createTime,email,nickname,admin_comment as adminComment,diary_id as diaryId FROM BBS_COMMENT WHERE parent_comment_id = #{parentId} ORDER BY CREATE_TIME DESC")
    Comment findCommentByParentId(@Param("parentId") Long parentId);
}
