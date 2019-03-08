package com.hc.openbbs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.openbbs.entity.Diary;
import com.hc.openbbs.entity.Tag;
import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.BbsService;
import com.hc.openbbs.service.TagService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yg
 * @create 2018-02-08 16:21
 * @desc 标签展示
 **/
@Controller
public class TagShowController {
    @Autowired
    private TagService tagService;
    @Autowired
    private BbsService bbsService;
    @GetMapping("/tags")
    public String tags(@RequestParam(required = true,defaultValue = "-1") Long tagid,@RequestParam(required = true,defaultValue = "1") int pageNum,@RequestParam(required = true,defaultValue = "6") int pageSize,Model model,HttpSession session){
        //获取标签
        List<Tag> tags=tagService.getTagList(1,1000);
        //获取文章
        if(tagid==-1){
            tagid=tags.get(0).getId();
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Diary> diarys=bbsService.getBbsListByTagId(tagid,pageNum,pageSize);
        PageInfo<Diary> p=new PageInfo<Diary>(diarys);
        model.addAttribute("tags",tags);
        model.addAttribute("diarys",diarys);
        model.addAttribute("page",p);
        //传递标签id,若结果仍然为-1,所有分类出现。
        model.addAttribute("tagid",tagid);
        //获得登陆者
        User user=(User)session.getAttribute("user");
        String nickname=null;
        if(user!=null){
            nickname=user.getUserNickname();
        }
        model.addAttribute("nickname", nickname);
        return "/tags.html";
    }

}
