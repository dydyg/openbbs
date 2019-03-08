package com.hc.openbbs.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.UserService;
import com.hc.openbbs.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String addUser(User user, RedirectAttributes attributes){
        user.setUserLoginPassword(MD5Utils.code(user.getUserLoginPassword()));
        System.out.println("++++++++++++++++++添加用户+++++++++++++"+user.toString());
        int b=userService.addUser(user);
        if (b>=1){
            //attributes.addFlashAttribute("message","注册成功");
            return "/userinfologin.html";
        }else{
            attributes.addFlashAttribute("message","注册失败");
            return "redirect:/register";
        }
    }

    /**
     * 查询所有用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/all")
    public Object getAllUser(@RequestParam(required=true,defaultValue="1") int pageNum, @RequestParam(required=false,defaultValue="10") int pageSize, Model model){
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> UserList=userService.getAllUser(pageNum,pageSize);
        PageInfo<User> p=new PageInfo<User>(UserList);
        model.addAttribute("page",p);
        model.addAttribute("UserList",UserList);
        return "/personalInfo.html";
    }
    /**
     * 根据登陆名，密码，查询用户
     */
    @ResponseBody
    @RequestMapping(value = "/login/{LoginName}/{LoginPassword}", produces = {"application/json;charset=UTF-8"})
    public Object getByLoginName(@PathVariable("LoginName") String LoginName, @PathVariable("LoginPassword") String LoginPassword){
        return  userService.getByLoginNameAndPwd(LoginName,LoginPassword);
    }
}
