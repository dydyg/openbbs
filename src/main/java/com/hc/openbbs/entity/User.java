package com.hc.openbbs.entity;

import java.util.Date;

/**
 * 用户实体类
 */
public class User {
    private Long id;
    private String userLoginName; //用户名
    private String userRealName; //用户真实姓名
    private String userLoginPassword; //用户密码
    private String userEmail; //用户email
    private String userScore; //'积分'
    private String userLevel; //'积分换算成登记、新生、老生、班主任、教导主任、校长',
    private String userBanlance; //'积分余额'
    private String userCorp;
    private String userNickname; //'昵称'
    private String userType; //'用户类型'
    private String userPhoto; //'用户头像'
    private String userLoginIp; //'最后登陆ip'
    private Date userLoginDate; //最后登陆日期
    private String userLoginFlag; //是否可登陆
    private String remarks; //'备注'
    private String createbyid; //'创建者id'
    private String createbyname; //'创建者名称'
    private Date createdate; //''创建日期''
    private String updatebyid; //'更新者id'
    private String updatebyname; //'更新者名称'
    private Date updatedate; //'更新日期'
    private String delflag; //'删除标记'
    private String perms; //shiro授权字符串
    //构造函数
    public User() {}
    public User(String id) {

    }
    public User(String id,String userLoginName) {
        this.userLoginName = userLoginName;
    }

    //生成get/set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserLoginPassword() {
        return userLoginPassword;
    }

    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserBanlance() {
        return userBanlance;
    }

    public void setUserBanlance(String userBanlance) {
        this.userBanlance = userBanlance;
    }

    public String getUserCorp() {
        return userCorp;
    }

    public void setUserCorp(String userCorp) {
        this.userCorp = userCorp;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserLoginIp() {
        return userLoginIp;
    }

    public void setUserLoginIp(String userLoginIp) {
        this.userLoginIp = userLoginIp;
    }

    public Date getUserLoginDate() {
        return userLoginDate;
    }

    public void setUserLoginDate(Date userLoginDate) {
        this.userLoginDate = userLoginDate;
    }

    public String getUserLoginFlag() {
        return userLoginFlag;
    }

    public void setUserLoginFlag(String userLoginFlag) {
        this.userLoginFlag = userLoginFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreatebyid() {
        return createbyid;
    }

    public void setCreatebyid(String createbyid) {
        this.createbyid = createbyid;
    }

    public String getCreatebyname() {
        return createbyname;
    }

    public void setCreatebyname(String createbyname) {
        this.createbyname = createbyname;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUpdatebyid() {
        return updatebyid;
    }

    public void setUpdatebyid(String updatebyid) {
        this.updatebyid = updatebyid;
    }

    public String getUpdatebyname() {
        return updatebyname;
    }

    public void setUpdatebyname(String updatebyname) {
        this.updatebyname = updatebyname;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public String getPerms() {
        return perms;
    }
    public void setPerms(String perms) {
        this.perms = perms;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userLoginName='" + userLoginName + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userLoginPassword='" + userLoginPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userScore='" + userScore + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", userBanlance='" + userBanlance + '\'' +
                ", userCorp='" + userCorp + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userType='" + userType + '\'' +
               // ", userPhoto='" + userPhoto + '\'' +
                ", userLoginIp='" + userLoginIp + '\'' +
                ", userLoginDate=" + userLoginDate +
                ", userLoginFlag='" + userLoginFlag + '\'' +
                ", remarks='" + remarks + '\'' +
                ", createbyid='" + createbyid + '\'' +
                ", createbyname='" + createbyname + '\'' +
                ", createdate=" + createdate +
                ", updatebyid='" + updatebyid + '\'' +
                ", updatebyname='" + updatebyname + '\'' +
                ", updatedate=" + updatedate +
                ", delflag='" + delflag + '\'' +
                ", perms='" + perms + '\'' +
                '}';
    }
}




