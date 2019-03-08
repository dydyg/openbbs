package com.hc.openbbs.service;

import com.hc.openbbs.entity.Diary;

import java.util.List;
import java.util.Map;

/**
 * @author yg
 * @create 2018-01-22 11:34
 * @desc 论坛列表
 **/
public interface BbsService {
    /**
     * 保存论坛文章
     * @param diary
     * @return
     */
    int addBbs(Diary diary);

    /**
     * 根据id获得论坛文章,并且转换成html
     * @param id
     * @return
     */
    Diary getBbsById(Long id);

    /**
     * 根据id获得论坛文章,未转换成html
     * @param id
     * @return
     */
    Diary getBbsByIdandNoConvert(Long id);

    /**
     * 分页查询
     * @param pageNum 第几页
     * @param pageSize 每页条数
     * @return
     */
    List<Diary> getBbsList(int pageNum, int pageSize);
    List<Diary> getBbsListByUid(int pageNum, int pageSize,Long uid);
    /**
     * 根据主键 修改
     * @return
     */
    int updateBbsById(Diary diary);

    /**
     * 根据主键删除
     * @param id
     */
    int deleteBbsById(Long id);
    /**
     * 获取推荐文章
     */
    List<Diary> getRecommendBbsTop(int pageNum, int pageSize);

    /**
     * 根据分类id分页查询
     * @typeid 分类id
     * @param pageNum 第几页
     * @param pageSize 每页条数
     * @return
     */
    List<Diary> getBbsListByTypeId(Long typeid,int pageNum, int pageSize);

    /**
     * 根据标签ID分页查询
     * @param tagid 标签id
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Diary> getBbsListByTagId(Long tagid,int pageNum,int pageSize);


}
