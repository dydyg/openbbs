package com.hc.openbbs.service;

import com.hc.openbbs.entity.PersonInfo;

import java.util.List;

/**
 * @author yg
 * @create 2018-02-22 15:43
 * @desc 个人详情
 **/
public interface PersonInfoService {
    /**
     * 增加个人信息
     * @param person
     * @return
     */
    int addPerson(PersonInfo person);

    /**
     * 修改信息
     * @param person
     * @return
     */
    int updatePerson(PersonInfo person);

    /**
     * 根据用户账号id,获取个人信息
     * @param uid
     * @return
     */
    PersonInfo getPersonById(Long uid);

    /**
     * 获取所有个人信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PersonInfoService> getPersonList(int pageNum, int pageSize);
}
