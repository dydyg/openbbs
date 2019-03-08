package com.hc.openbbs.mapper;

import com.hc.openbbs.entity.Diary;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yg
 * @create 2018-01-10 13:35
 * @desc 论坛管理操作接口
 **/
public interface BbsMapper {
    //根据论坛文章标题名查询分类名称
    @Select("SELECT * FROM bbs_diary WHERE TITLE = #{title}")
    public Diary getBbsByName(@Param("title") String title);

    //根据id获得文章列表
    public Diary getBbsById(@Param("id")  Long id);

    // 分页查询-查询所有文章列表名称
    public List<Diary> getBbsList();

    // 分页查询-查询所有文章列表名称
    public List<Diary> getBbsListByUid(@Param("uid")  Long uid);

    // 保存分类插入分类名称
    //@Insert("INSERT INTO BBS_TYPE(TYPE_NAME) VALUES (#{typeName})")
    public int addBbs(Diary diary);

    //根据id更新分类
    int updateBbsById(Diary diary);

    //根据id删除
    @Delete("DELETE FROM bbs_diary WHERE ID=#{id}")
    int deleteBbsById(@Param("id") Long id);
    //获取最新推荐文章
    @Select("SELECT * FROM bbs_diary WHERE RECOMMEND = TRUE ORDER BY UPDATE_TIME DESC LIMIT 3")
    List<Diary> getRecommendBbsTop();

    //根据分类id获得文章列表
    public List<Diary> getBbsByTypeId(@Param("typeid")  Long typeid);

    //根据标签id获得文章列表
    public List<Diary> getBbsByTagId(@Param("tagid")  Long tagid);
}
