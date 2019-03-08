package com.hc.openbbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.hc.openbbs.mapper.UserMapper;
import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.UserService;
import com.hc.openbbs.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(User user) {

        return userMapper.addUser(user);
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public List<User> getAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.getAllUser();
    }

    /**
     *
     * 根据用户名和密码，查询用户
     * @param userLoginName
     * @param userLoginPassword
     * @return
     */
    @Override
    public User getByLoginNameAndPwd(String userLoginName,String userLoginPassword){
        return userMapper.getByLoginNameAndPwd(userLoginName, userLoginPassword);
    }

    /**
     * 根据用户名查询用户
     * @param LoginName
     * @return
     */
    @Override
    public User getByLoginName(String LoginName) {
        return userMapper.getByLoginName(LoginName);
    }
}
