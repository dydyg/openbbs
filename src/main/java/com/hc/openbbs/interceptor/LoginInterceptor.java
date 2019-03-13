package com.hc.openbbs.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yg
 * @create 2018-01-10 11:10
 * @desc 登陆拦截器+WebConfig 共同控制
 **/
public class LoginInterceptor extends HandlerInterceptorAdapter{
//    /**
//     * 重写请求预处理
//     * @param request
//     * @param response
//     * @param handler
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        /**
//         * 用户是否登陆
//         */
//        if(request.getSession().getAttribute("user")==null){
//            response.sendRedirect("/admin");
//            return false;
//        }
//        return true;
//    }
}
