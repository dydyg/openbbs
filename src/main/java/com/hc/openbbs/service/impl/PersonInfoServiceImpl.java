package com.hc.openbbs.service.impl;

import com.hc.openbbs.entity.PersonInfo;
import com.hc.openbbs.mapper.PersonInfoMapper;
import com.hc.openbbs.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yg
 * @create 2018-02-22 16:43
 * @desc 个人信息实现类
 **/
@Service(value = "PersonInfoService")
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoMapper personMapper;
    @Override
    public int addPerson( PersonInfo person) {
        return personMapper.addPerson(person);
    }

    @Override
    public int updatePerson(PersonInfo person) {
        return personMapper.updatePerson(person);
    }

    @Override
    public PersonInfo getPersonById(Long uid) {
        return personMapper.getPersonById(uid);
    }

    @Override
    public List<PersonInfoService> getPersonList(int pageNum, int pageSize) {
        return null;
    }
}
