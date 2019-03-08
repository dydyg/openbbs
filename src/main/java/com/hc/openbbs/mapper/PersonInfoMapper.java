package com.hc.openbbs.mapper;

import com.hc.openbbs.entity.PersonInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author yg
 * @create 2018-02-22 16:45
 * @desc 个人信息
 **/
public interface PersonInfoMapper {
    /**
     * 根据用户名查询用户
     * @return
     */
    // 保存分类插入分类名称
    @Insert("INSERT INTO bbs_person_info(realname,sex,type,age,birthnum,maritalstatus,politicallook,education,university,nativeplace,presentaddress,phone,qq,position,post,emergencyliaison,emergencyphone,relationship,leavedate,entrydate) VALUES(#{realname},#{sex},#{type},#{age},#{birthnum},#{maritalstatus},#{politicallook},#{education},#{university},#{nativeplace},#{presentaddress},#{phone},#{qq},#{position},#{post},#{emergencyliaison},#{emergencyphone},#{relationship},#{leavedate},#{entrydate})")
     int addPerson(PersonInfo personInfo);

    @Select({"select * from bbs_person_info where uid=#{uid}"})
    PersonInfo getPersonById(@Param("uid") Long uid);

    //根据id更新分类
    @Update("UPDATE bbs_person_info set realname=#{realname},sex=#{sex},type=#{type},age=#{age},birthnum=#{birthnum},maritalstatus=#{maritalstatus},politicallook=#{politicallook},education=#{education},university=#{university},nativeplace=#{nativeplace},presentaddress=#{presentaddress},phone=#{phone},qq=#{qq},position=#{position},post=#{post},emergencyliaison=#{emergencyliaison},emergencyphone=#{emergencyphone},relationship=#{relationship},leavedate=#{leavedate},entrydate=#{entrydate}")
    int updatePerson(PersonInfo personInfo);

}
