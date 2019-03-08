package com.hc.openbbs.service.impl;

import com.hc.openbbs.entity.Diary;
import com.hc.openbbs.mapper.BbsMapper;
import com.hc.openbbs.service.BbsService;
import com.hc.openbbs.util.MarkdownUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author yg
 * @create 2018-01-22 13:32
 * @desc 论坛列表
 **/
@Service(value = "BbsService")
public class BbsServiceImpl implements BbsService{
    @Autowired
    private BbsMapper bbsMapper;

    @Override
    public int addBbs(Diary diary) {
        diary.setCreateTime(new Date());
        diary.setUpdateTime(new Date());
        diary.setViews(0);
        return bbsMapper.addBbs(diary);
    }

    @Transactional
    @Override
    public Diary getBbsById(Long id) {
        Diary diary=bbsMapper.getBbsById(id);
        /*if(diary==null){
            throw new NotFoundException("该博客不存在");
        }*/
        //设置新对象存放转换成html的内容。
       // Diary d=new Diary();
        String content = diary.getContent();
        diary.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return diary;
    }

    @Override
    public Diary getBbsByIdandNoConvert(Long id) {
        return bbsMapper.getBbsById(id);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<Diary> getBbsList(int pageNum, int pageSize) {
        return bbsMapper.getBbsList();
    }

    @Override
    public List<Diary> getBbsListByUid(int pageNum, int pageSize,Long uid) {
        return bbsMapper.getBbsListByUid(uid);

    }

    @Override
    public int updateBbsById(Diary diary) {
        diary.setUpdateTime(new Date());
        return bbsMapper.updateBbsById(diary);
    }

    @Override
    public int deleteBbsById(Long id) {
        return bbsMapper.deleteBbsById(id);
    }

    /**
     * 获取最新推荐文章
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Diary> getRecommendBbsTop(int pageNum, int pageSize) {
        return bbsMapper.getRecommendBbsTop();
    }

    /**
     * 根据文章分了type_id 获取文章
     * @param pageNum 第几页
     * @param pageSize 每页条数
     * @return
     */
    @Override
    public List<Diary> getBbsListByTypeId(Long typeid,int pageNum, int pageSize) {
        return bbsMapper.getBbsByTypeId(typeid);
    }

    /**
     * 根据标签ID分页查询
     * @param tagid 标签id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Diary> getBbsListByTagId(Long tagid, int pageNum, int pageSize) {
        return bbsMapper.getBbsByTagId(tagid);
    }
    public void test(){}
}
