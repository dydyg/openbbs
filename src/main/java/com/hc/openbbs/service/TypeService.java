package com.hc.openbbs.service;
import com.hc.openbbs.entity.Type;

import java.util.List;

/**
 * @author yg
 * @create 2018-01-10 11:59
 * @desc 分类管理业务逻辑
 **/
public interface TypeService {
    /**
     * 保存分类
     * @param type
     * @return
     */
    int addType(Type type);

    /**
     * 根据id获得分类
     * @param id
     * @return
     */
    Type getTypeById(Long id);

    /**
     * 分页查询
     * @param pageNum 第几页
     * @param pageSize 每页条数
     * @return
     */
    List<Type> getTypeList(int pageNum, int pageSize);

    /**
     * 根据主键 修改
     * @param id
     * @param typeName 对象
     * @return
     */
    Type updateTypeById(Long id,String typeName);

    /**
     * 根据主键删除
     * @param id
     */
    int deleteTypeById(Long id);

    /**
     * 根据分类id获取文章
     * @param pageNum 第几页
     * @param pageSize 每页条数
     * @return
     */
    List<Type> getTypeDiaryList(int pageNum, int pageSize);
}

