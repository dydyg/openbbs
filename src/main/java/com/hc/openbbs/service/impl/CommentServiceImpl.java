package com.hc.openbbs.service.impl;

import com.hc.openbbs.entity.Comment;
import com.hc.openbbs.mapper.CommentMapper;
import com.hc.openbbs.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yg
 * @create 2018-02-02 14:37
 * @desc 评论实现类
 **/
@Service(value = "CommentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    //实现接口两个方法

    /**
     * 获取评论列表
     * @param diaryId 文章id
     * @return
     */
    @Override
    public List<Comment> listCommentByDiaryId(Long diaryId) {

        List<Comment> comments = commentMapper.findCommentByDiaryId(diaryId);
        System.out.println("获取评论："+comments.toString());
        return eachComment(comments);
    }

    /**
     * 保存评论内容
     * @param comment
     * @return
     */
    @Override
    public int saveComment(Comment comment) {
        //获取父级评论id
        System.out.println("获得父级评论类id======================");
        Long parentCommentId = comment.getParentComment().getId();
        System.out.println("获得父级评论类id:"+parentCommentId);

        //获取父级评论id不为空，获取父级评论内容
        if (parentCommentId != -1) {
            comment.setParentComment(commentMapper.findCommentByParentId(parentCommentId));
            System.out.println("获得父级评论类:"+comment.getParentComment().toString());
        } else {
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        System.out.println("实现保存评论类:"+comment.toString());
        return commentMapper.addComment(comment);

    }


    /**
     * 实现其他方法
     */

    /**
     * 循环每个顶级的评论节点
     * @param comments
     * @return
     */
    private List<Comment> eachComment(List<Comment> comments) {
        List<Comment> commentsView = new ArrayList<>();
        for (Comment comment : comments) {
            Comment c = new Comment();
            BeanUtils.copyProperties(comment,c);
            commentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(commentsView);
        System.out.println("3合并评论的各层子代到第一级子代集合中："+commentsView.toString());
        return commentsView;
    }

    /**
     *
     * @param comments root根节点，blog不为空的对象集合
     * @return
     */
    private void combineChildren(List<Comment> comments) {

        for (Comment comment : comments) {
            List<Comment> replys1 = comment.getReplyComments();
            for(Comment reply1 : replys1) {
                //循环迭代，找出子代，存放在tempReplys中
                recursively(reply1);
            }
            //修改顶级节点的reply集合为迭代处理后的集合
            comment.setReplyComments(tempReplys);
            //清除临时存放区
            tempReplys = new ArrayList<>();
        }
    }


    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();
    /**
     * 递归迭代，剥洋葱
     * @param comment 被迭代的对象
     * @return
     */
    private void recursively(Comment comment) {
        tempReplys.add(comment);//顶节点添加到临时存放集合
        if (comment.getReplyComments().size()>0) {
            List<Comment> replys = comment.getReplyComments();
            for (Comment reply : replys) {
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0) {
                    recursively(reply);
                }
            }
        }
    }

}
