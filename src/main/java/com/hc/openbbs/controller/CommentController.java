package com.hc.openbbs.controller;

import com.hc.openbbs.entity.Comment;
import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yg
 * @create 2018-02-02 14:33
 * @desc 评论
 **/
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     *
     * @param diaryId
     * @param model
     * @return
     */
    @GetMapping("/comment")
    public String comments(@RequestParam Long diaryId, Model model) {
        //System.out.println("输出diaryId："+diaryId);
        List<Comment> commments=commentService.listCommentByDiaryId(diaryId);
        System.out.println("输出："+commments.toString());
        model.addAttribute("commentlist",commments );
        return "diary :: commentListt";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session) {
       // System.out.println("保存前");
        //获取文章id
        Long diaryId = comment.getDiaryId();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getUserPhoto());
            comment.setAdminComment(true);
        } else {
        }
       // System.out.println("保存后："+);
        commentService.saveComment(comment);
        return "redirect:/comment?diaryId=" + diaryId;
    }
}
