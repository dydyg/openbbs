package com.hc.openbbs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.openbbs.entity.Comment;
import com.hc.openbbs.entity.Diary;
import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.BbsService;
import com.hc.openbbs.service.CommentService;
import com.hc.openbbs.service.TagService;
import com.hc.openbbs.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 进入bbs首页
 */
@Controller
public class IndexController {
    @Autowired
    private BbsService bbsService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CommentService commentService;
    /*@RequestMapping("/hcbbs")
    public ModelAndView  index(){
        ModelAndView view = new ModelAndView("/index.html");
        System.out.print("--------------进入首页-------");
        return view;
    }*/
    @GetMapping("/hcbbs")
    public String index(@RequestParam(required=true,defaultValue="1") int pageNum, @RequestParam(required=false,defaultValue="6") int pageSize, Model model,HttpSession session) {
                    PageHelper.startPage(pageNum, pageSize);
                    List<Diary> diaryList =bbsService.getBbsList(pageNum,pageSize);
                    PageInfo<Diary> p=new PageInfo<Diary>(diaryList);
                    //页码细信息
                    model.addAttribute("page",p);
                    //文章信息
                    model.addAttribute("bbsList", diaryList);
                    //分类信息
                    //model.addAttribute("types",typeService.getTypeList(1,50));
                    //标签信息
                    //model.addAttribute("tags", tagService.getTagList(1,50));
                    //推荐文章信息
                    model.addAttribute("recommendBbs", bbsService.getRecommendBbsTop(1,3));
                    //获得登陆者
                    User user=(User)session.getAttribute("user");
                    String nickname=null;
                    if(user!=null){
                        nickname=user.getUserNickname();
                    }
                    model.addAttribute("nickname", nickname);
                    return "/index.html";

    }

    @GetMapping("/diarybyid")
    public String diary(@RequestParam Long id, Model model) {
        Diary diary= bbsService.getBbsById(id);
        //文章
        model.addAttribute("diary", diary);
        //评论
        List<Comment> commments=commentService.listCommentByDiaryId(id);
        //System.out.println("输出zzzz："+commments);
        //model.addAttribute("commentlist",commments );
        return "/diary.html";
    }
    @GetMapping("/register")
    public String register(){
        return "/register.html";
    }
}
