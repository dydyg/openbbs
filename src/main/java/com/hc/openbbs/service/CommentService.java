package com.hc.openbbs.service;

import com.hc.openbbs.entity.Comment;

import java.util.List;

/**
 * @author yg
 * @create 2018-02-02 14:34
 * @desc 评论
 **/
public interface CommentService {
    //根据文章id获取评论列表
    List<Comment> listCommentByDiaryId(Long diaryId);
    //评论内容
    int saveComment(Comment comment);
}
