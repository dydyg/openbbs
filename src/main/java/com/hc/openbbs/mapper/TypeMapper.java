package com.hc.openbbs.mapper;

import com.hc.openbbs.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yg
 * @create 2018-01-10 13:48
 * @desc 分类管理操作接口
 **/
public interface TypeMapper {

    //根据分类名查询分类名称
    @Select("SELECT * FROM BBS_TYPE WHERE TYPE_NAME = #{typeName}")
   public Type getTypeByName(@Param("typeName") String typeName);

    //根据id获得分类
    @Select("SELECT * FROM BBS_TYPE WHERE ID=#{id}")
   public Type getTypeById(@Param("id") String id);

    // 分页查询-查询所有分类名称
     //@Select("SELECT id,type_name as typeName FROM BBS_TYPE")
    public List<Type> getTypeList();

   // 保存分类插入分类名称
    @Insert("INSERT INTO BBS_TYPE(TYPE_NAME) VALUES (#{typeName})")
    public int addType(Type type);

    //根据id更新分类
    @Update("UPDATE BBS_TYPE SET TYPE_NAME=#{typeName} WHERE ID=#{id}")
    int updateTypeById(@Param("id") String id);

    //根据id删除
    @Delete("DELETE FROM BBS_TYPE WHERE ID=#{id}")
     int deleteTypeById(@Param("id") Long id);
     //分页查询-包含对应文章
     public List<Type> getTypeDiaryList();
}
