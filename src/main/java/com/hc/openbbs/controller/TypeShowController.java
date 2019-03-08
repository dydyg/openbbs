package com.hc.openbbs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.openbbs.entity.Diary;
import com.hc.openbbs.entity.Type;
import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.BbsService;
import com.hc.openbbs.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yg
 * @create 2018-01-30 13:12
 * @desc 文章分类展示页面
 **/
@Controller
public class TypeShowController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private BbsService BbsService;

    @GetMapping("/types")
    public String types(@RequestParam(required=true,defaultValue="-1") Long typeid,@RequestParam(required=true,defaultValue="1") int pageNum, @RequestParam(required=false,defaultValue="6") int pageSize, Model model,HttpSession session) {
        //获取分类
        List<Type> types=typeService.getTypeList(1,1000);
        model.addAttribute("types", types);
        //获取分类id查询文章内容
        if(typeid==-1){
            typeid=types.get(0).getId();
        }
        //页码细信息
        PageHelper.startPage(pageNum, pageSize);
        //获取文章
        List<Diary> diarys = BbsService.getBbsListByTypeId(typeid,pageNum,pageSize);
        PageInfo<Diary> p=new PageInfo<Diary>(diarys);
        model.addAttribute("diarys", diarys);
        //System.out.println(diarys.toString());
        model.addAttribute("page",p);
        //传递分类id,若结果仍然为-1,所有分类出现。
        model.addAttribute("typeid",typeid);
        //获得登陆者
        User user=(User)session.getAttribute("user");
        String nickname=null;
        if(user!=null){
            nickname=user.getUserNickname();
        }
        model.addAttribute("nickname", nickname);
        return "/types.html";
    }
}
