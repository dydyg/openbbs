package com.hc.openbbs.mapper;

import com.hc.openbbs.entity.DiaryTag;
import com.hc.openbbs.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author yg
 * @create 2018-02-05 16:31
 * @desc 文章与标签表
 **/
public interface DiaryTagMapper {
    //中间表：diary_tag插入操作
    @Insert("INSERT INTO BBS_DIARY_TAG(DIARY_id,TAG_ID) VALUES (#{diaryId},#{tagId})")
    public int addDiaryTag(@Param("diaryId") Long diaryId,@Param("tagId") Long tagId);

    //中间表：diary_tag修改操作
    @Insert("UPDATE BBS_DIARY_TAG SET DIARY_ID=#{diaryId},TAG_ID=#{tagId}")
    public int updateDiaryTag(@Param("diaryId") Long diaryId,@Param("tagId") Long tagId);
}
