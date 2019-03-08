package com.hc.openbbs.service;
import com.hc.openbbs.entity.Diary;
import com.hc.openbbs.entity.Tag;

import java.util.List;

/**
 * @author yg
 * @create 2018-01-30 9:12
 * @desc 标签业务逻辑
 **/
public interface TagService {
    /**
     * 保存分类
     * @param tag
     * @return
     */
    int addTag(Tag tag);

    /**
     * 根据id获得分类
     * @param id
     * @return
     */
    Tag getTagById(Long id);

    /**
     * 分页查询
     * @param pageNum 第几页
     * @param pageSize 每页条数
     * @return
     */
    List<Tag> getTagList(int pageNum, int pageSize);

    /**
     * 根据主键 修改
     * @param id
     * @param tagName 对象
     * @return
     */
    Tag updateTagById(Long id,String tagName);

    /**
     * 根据主键删除
     * @param id
     */
    int deleteTagById(Long id);

    /**
     * 根据分类名查询名称是否存在
     */
    Tag getTagByName(String name);

}
