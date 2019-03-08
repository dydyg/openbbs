package com.hc.openbbs.service.impl;

import com.hc.openbbs.entity.Tag;
import com.hc.openbbs.mapper.DiaryTagMapper;
import com.hc.openbbs.mapper.TagMapper;
import com.hc.openbbs.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yg
 * @create 2018-01-30 9:22
 * @desc 标签业务逻辑实现类
 **/
@Service(value = "TagService")
public class TagServiceImpl implements TagService{
    @Autowired
    private TagMapper tagMapper;

    private DiaryTagMapper diarytagmapper;
    @Override
    public int addTag(Tag tag) {
        //System.out.println("插入数据库，返回数字："+typeMapper.addType(type));
        return tagMapper.addTag(tag);
    }

    @Override
    public Tag getTagById(Long id) {
        return null;
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<Tag> getTagList(int pageNum, int pageSize) {
        return tagMapper.getTagList();
    }

    @Override
    public Tag updateTagById(Long id, String typeName) {
        return null;
    }

    @Override
    public int deleteTagById(Long id) {
        return tagMapper.deleteTagById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTypeByName(name);
    }

}
