package com.hc.openbbs.service.impl;

import com.hc.openbbs.entity.Tag;
import com.hc.openbbs.mapper.DiaryTagMapper;
import com.hc.openbbs.service.DiaryTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yg
 * @create 2018-02-05 17:10
 * @desc 文章与标签
 **/
@Service(value = "DiaryTagService")
public class DiaryTagServiceImpl implements DiaryTagService {
    @Autowired
    DiaryTagMapper diarytagmapper;

    /**
     * 一对多，多条插入
     * @param id 文章id
     * @param ids 标签id字符集
     */
    @Override
    public void addDiaryTagByIds(Long id,String ids) {
       //批量保存
        for (Long sid : convertToList(ids)) {
             diarytagmapper.addDiaryTag(id,sid);
        }

    }

    /**
     * 一对多，多条修改
     * @param id 文章id
     * @param ids 标签id字符集
     */
    @Override
    public void updateDiaryTagByIds(Long id,String ids) {
        //批量保存
        for (Long sid : convertToList(ids)) {
            diarytagmapper.updateDiaryTag(id,sid);
        }

    }


    //字符集 id 转换成 long id
    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

}
