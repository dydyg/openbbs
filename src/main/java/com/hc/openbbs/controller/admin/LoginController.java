package com.hc.openbbs.controller.admin;

import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.UserService;
import com.hc.openbbs.util.MD5Utils;
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
        User user =userService.getByLoginNameAndPwd(username, MD5Utils.code(password));
        //System.out.print("真实名称:"+user.getUserRealName());
        if(user!=null){
            user.setUserLoginPassword(null);
            session.setAttribute("user",user);
            System.out.print("user对象此时不为空!");
            return "redirect:/admin/hcbbs";
        }else{
            System.out.print("user对象此时为空!");
            attributes.addFlashAttribute("message","用户名或密码错误");
             //重定向到登陆页面
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
