package com.hc.openbbs.mapper;

import com.hc.openbbs.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUser();

    /**
     *
     * @param LoginName  登陆用户名
     * @param LoginPassword   登陆密码
     * @return
     */
     User  getByLoginNameAndPwd(@Param("LoginName") String LoginName, @Param("LoginPassword") String LoginPassword);

    /**
     * 根据用户名查询用户
     * @param LoginName
     * @return
     */
     User  getByLoginName(@Param("LoginName") String LoginName);

    /**
     * 根据用户Id查询用户
     * @param LoginId
     * @return
     */
     User  getByLoginId(@Param("LoginId") Long LoginId);

    /**
     * 更新用户信息
     * @param userId 用户主键
     * @param head 用户头像
     * @return
     */
    @Update({"update bbs_user set user_photo = #{head} where id=#{userId}"})
    int updateHead(@Param("userId") int userId, @Param("head") byte[] head);

    /**
     * 新增用户
     * @param user 用户实体对象
     * @return
     */
    public int addUser(User user);


}