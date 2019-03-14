package com.hc.openbbs.config;

import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    /**
     * 执行授权逻辑
     * @param arg0
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        System.out.println("====执行授权逻辑==开始=====");
        //给资源进行授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        //info.addStringPermission("user:diarybyid");

        //到数据库查询当前用户的授权字符串
        //获取当前登录用户
        Subject subject= SecurityUtils.getSubject();
        User user=(User)subject.getPrincipal();
//        System.out.println("元素："+user.toString());
        User dbuser=userService.getByLoginId(user.getId());
        //添加资源的授权字符串
        System.out.println("Perms参数D："+user.getPerms());
        info.addStringPermission(dbuser.getPerms());
        System.out.println("====执行授权逻辑==结束=====");
        return info;
    }


    /**
     * 执行认证逻辑
     * @param arg0
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        System.out.println("======执行认证逻辑开始============");
//        编写shiro判断逻辑，判断用户名或密码
//        1、判断用户名
        UsernamePasswordToken token=(UsernamePasswordToken)arg0;
        User user=userService.getByLoginName(token.getUsername());
        if (user==null){
            //用户名不存在
            return null;//shiro 底层会抛出UnKnowAccountException
        }
        //2、判断密码
        return new SimpleAuthenticationInfo(user,user.getUserLoginPassword(),"");
    }
}
