package com.hc.openbbs.config;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置类
 * @author  yg
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建三个bean ShirofilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
         ShiroFilterFactoryBean shiroFilterFactoryBean =new ShiroFilterFactoryBean();
         //设置安全管理器
         shiroFilterFactoryBean.setSecurityManager(securityManager);
         //添加Shiro内置过滤器
         /**
          * Shiro内置过滤器，可以实现权限相关的拦截器
          * 常用的过滤器：
          *     anon:无需认证（登录）可以访问
          *     authc:必须认证才可以访问
          *     user:如果使用rememberMe的功能可以直接访问
          *
          *     perms:该资源必须授予权限才可以访问
          *     role:该资源必须得到角色权限才可以访问
          */
         Map<String,String> filterMap=new LinkedHashMap<String,String>();
//         资源放行
         filterMap.put("/hcbbs","anon");
         filterMap.put("/admin","anon");

         //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
         filterMap.put("/diarybyid","perms[user:diarybyid]");
        filterMap.put("/update","perms[user:update]");
//         资源拦截
         filterMap.put("/*","authc");

//         修改调整登录页
         shiroFilterFactoryBean.setLoginUrl("/admin");
         //设置未授权提示页面
         shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
         shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
         return  shiroFilterFactoryBean;
     }
    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
   public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
       DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
       //关联realm
       securityManager.setRealm(userRealm);
       return securityManager;
   }
    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
}
