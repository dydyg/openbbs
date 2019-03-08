package com.hc.openbbs.service;

import com.hc.openbbs.entity.Tag;

import java.util.List;

/**
 * @author yg
 * @create 2018-02-05 17:07
 * @desc 分类与标签
 **/
public interface DiaryTagService {
    /**
     * 根据ids 增加 文章与标签的关联-mybatis多条插入
     * @param id 文章id
     * @param ids 标签id字符集
     * @return
     */
void addDiaryTagByIds(Long id,String ids);

    /**
     * 根据ids 修改 文章与标签的关联-mybatis多条插入
     * @param id 文章id
     * @param ids 标签id字符集
     * @return
     */
void updateDiaryTagByIds(Long id,String ids);
}
