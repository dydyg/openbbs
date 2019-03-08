package com.hc.openbbs.service.impl;

import com.hc.openbbs.entity.Type;
import com.hc.openbbs.mapper.TypeMapper;
import com.hc.openbbs.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yg
 * @create 2018-01-10 13:27
 * @desc 实现分类管理业务逻辑
 **/
@Service(value = "typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public int addType(Type type) {
        //System.out.println("插入数据库，返回数字："+typeMapper.addType(type));
        return typeMapper.addType(type);
    }

    @Override
    public Type getTypeById(Long id) {
        return null;
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<Type> getTypeList(int pageNum, int pageSize) {
        return typeMapper.getTypeList();
}

    @Override
    public Type updateTypeById(Long id, String typeName) {
        return null;
    }

    @Override
    public int deleteTypeById(Long id) {
        return typeMapper.deleteTypeById(id);
    }

    @Override
    public List<Type>  getTypeDiaryList(int pageNum, int pageSize) {
        return typeMapper.getTypeDiaryList();
    }
}
