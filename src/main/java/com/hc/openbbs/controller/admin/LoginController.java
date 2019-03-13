package com.hc.openbbs.controller.admin;

import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.UserService;
import com.hc.openbbs.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author yg
 * @create 2018-01-09 18:16
 * @desc 后台登陆控制api
 **/
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String loginHtml(){
        return "/admin/login.html";
    }
    @PostMapping("/login")
    public  String login(@RequestParam String username, @RequestParam String password, HttpSession session , RedirectAttributes attributes){
//        User user =userService.getByLoginNameAndPwd(username, MD5Utils.code(password));
//        if(user!=null){
//            user.setUserLoginPassword(null);
//            session.setAttribute("user",user);
//            System.out.print("user对象此时不为空!");
//            return "redirect:/admin/hcbbs";
//        }else{
//            System.out.print("user对象此时为空!");
//            attributes.addFlashAttribute("message","用户名或密码错误");
//             //重定向到登陆页面
//            return "redirect:/admin";
//        }

        /**
         * 使用Shiro编写认证操作
         */
        //1、获取Subject
        Subject subject= SecurityUtils.getSubject();
        //2、封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(username,MD5Utils.code(password));

        //3、执行登录方法
        try {
            subject.login(token);
            //登录成功、跳转test.html
            System.out.println("===========正常=====0=======");
            return "redirect:/admin/hcbbs";
        } catch (UnknownAccountException e) {
            //登录失败：用户名不存在
            attributes.addAttribute("msg","用户名不存在");
            System.out.println("用户名不存在");
            return "redirect:/admin";

        }catch (IncorrectCredentialsException e){
            attributes.addAttribute("msg","密码错误");
            System.out.println("密码错误");
            return "redirect:/admin";
        }
    }

    /**
     * 用户注销
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        System.out.println("用户注销!");
        return "redirect:/hcbbs";
    }
}
