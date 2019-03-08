package com.hc.openbbs.mapper;

import com.hc.openbbs.entity.Tag;
import com.hc.openbbs.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yg
 * @create 2018-01-26 16:36
 * @desc 标签操作接口
 **/
public interface TagMapper {
    //根据分类名查询分类名称
    @Select("SELECT * FROM BBS_TAG WHERE TYPE_NAME = #{typeName}")
    public Tag getTypeByName(@Param("typeName") String typeName);

    //根据文章id获得分类
    public List<Tag> getTagsByBbsId(@Param("id") String id);

    // 分页查询-查询所有分类名称
    public List<Tag> getTagList();

    // 保存分类插入分类名称
    @Insert("INSERT INTO BBS_TYPE(NAME) VALUES (#{tagName})")
    public int addTag(Tag tag);

    //根据id更新分类
    @Update("UPDATE BBS_TAG(NAME) VALUES(#{tagName})")
    int updateTagById(@Param("id") String id);

    //根据id删除
    @Delete("DELETE FROM BBS_TAG WHERE ID=#{id}")
    int deleteTagById(@Param("id") Long id);

}
