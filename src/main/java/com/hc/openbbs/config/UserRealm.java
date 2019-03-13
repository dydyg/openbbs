package com.hc.openbbs.config;

import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 */
public class UserRealm extends AuthorizingRealm {
    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    @Autowired
   private UserService userService;
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
        System.out.println("======执行认证逻辑开始=1==========="+token.getUsername());
        User user=userService.getByLoginName(token.getUsername());
        System.out.println("======执行认证逻辑开始=2===========");
        System.out.println("UserRealm:"+user);
        if (user==null){
            //用户名不存在
            return null;//shiro 底层会抛出UnKnowAccountException
        }
        //2、判断密码
        return new SimpleAuthenticationInfo("",user.getUserLoginPassword(),"");
    }
}
