package com.hc.openbbs.service;


import com.hc.openbbs.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 查询所有用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<User> getAllUser(int pageNum, int pageSize);
    /**
     * 根据用户名和密码，查询用户
     */
    User getByLoginNameAndPwd(String LoginName,String LoginPassword);

    /**
     * 根据用户名查询用户
     * @param LoginName
     * @return
     */
    User getByLoginName(String LoginName);
}
