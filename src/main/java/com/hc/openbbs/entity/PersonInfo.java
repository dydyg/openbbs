package com.hc.openbbs.entity;

import java.util.Date;

/**
 * @author yg
 * @create 2018-02-22 15:57
 * @desc 个人详情
 **/
public class PersonInfo {
    //id
   private Long id;
   //姓名
   private String realname;
   //性别
   private String sex;
   //民族
   private String type;
   //年龄
   private int age;
   //职位
    private String position;
    //岗位
    private String post;
   //身份证号
    private String birthnum;
    //婚姻状况
    private String maritalstatus;
    //政治面貌
    private String politicallook;
    //学历
    private String education;
    //毕业院校
    private String university;
    //籍贯
    private String nativeplace;
    //现居住地址
    private String presentaddress;
    //个人联系电话
    private String phone;
    //qq
    private  String qq;
    //紧急联络人
    private String emergencyliaison;
    //紧急联络人联系电话
    private String emergencyphone;
    //关系
    private  String relationship;
    //入职日期
    private  Date entrydate;
    //离职日期
    private Date leavedate;
    //系统用户id
    private Long uid;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getBirthnum() {
        return birthnum;
    }

    public void setBirthnum(String birthnum) {
        this.birthnum = birthnum;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getPoliticallook() {
        return politicallook;
    }

    public void setPoliticallook(String politicallook) {
        this.politicallook = politicallook;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getPresentaddress() {
        return presentaddress;
    }

    public void setPresentaddress(String presentaddress) {
        this.presentaddress = presentaddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmergencyliaison() {
        return emergencyliaison;
    }

    public void setEmergencyliaison(String emergencyliaison) {
        this.emergencyliaison = emergencyliaison;
    }

    public String getEmergencyphone() {
        return emergencyphone;
    }

    public void setEmergencyphone(String emergencyphone) {
        this.emergencyphone = emergencyphone;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
