package com.hc.openbbs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.openbbs.entity.Diary;
import com.hc.openbbs.entity.PersonInfo;
import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.BbsService;
import com.hc.openbbs.service.PersonInfoService;
import com.hc.openbbs.service.UserService;
import com.hc.openbbs.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yg
 * @create 2018-02-09 14:01
 * @desc 个人中心
 **/
@Controller
public class userInfoShowController {
    @Autowired
    private BbsService bbsService;
    @Autowired
    private UserService userService;
    @Autowired
    private PersonInfoService personInfoService;



    @GetMapping("/userinfo")
    public String archives(@RequestParam(required=true,defaultValue="1") int pageNum, @RequestParam(required=false,defaultValue="6") int pageSize, HttpSession session, Model model){
        //个人信息归档
        User user=(User)session.getAttribute("user");
        if(user!=null){
            //个人文章归档
            PageHelper.startPage(pageNum,pageSize);
            List<Diary> diarys=bbsService.getBbsListByUid(pageNum,pageSize,user.getId());
            PageInfo<Diary> p=new PageInfo<Diary>(diarys);
            model.addAttribute("user",user);
            model.addAttribute("archivediary",diarys);
            model.addAttribute("page",p);
            model.addAttribute("nickname", user.getUserNickname());
            return "/userinfo.html";
        }else{
            return "/userinfologin.html";
        }

    }
    @PostMapping("/userinfologin")
    public  String userinfologin(@RequestParam String username, @RequestParam String password, HttpSession session , RedirectAttributes attributes){
        User user =userService.getByLoginNameAndPwd(username, MD5Utils.code(password));
        if(user!=null){
            user.setUserLoginPassword(null);
            session.setAttribute("user",user);
            return "redirect:/userinfo";
        }else{
            attributes.addFlashAttribute("message","用户名或密码错误");
            //重定向到登陆页面
            return "redirect:/userinfologin.html";
        }
    }
    //个人详情
    @GetMapping("/personinfo")
    public String personalinfo(@RequestParam Long uid,HttpSession session,Model model){
        PersonInfo person=personInfoService.getPersonById(uid);
        //获得个人信息
        model.addAttribute("person",person);
        //获得登陆者
        User user=(User)session.getAttribute("user");
        String nickname=null;
        if(user!=null){
            nickname=user.getUserNickname();
        }
        model.addAttribute("nickname", nickname);
      return "/personalInfo.html";
    }
    @PostMapping("/saveperson")
    public String updatePersonInfo(@RequestParam Long uid,PersonInfo personInfo){
        //更新个人信息
        personInfoService.updatePerson(personInfo);
       //重定向到登陆页面
        return  "redirect:/personinfo?uid="+uid;
    }
    //貌似是用于初始化数据的时候，进行数据类型转换，吧String类型转为Date类型
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
