package com.linkingwin.education.studyonline.common.base.model.vo;

import com.alibaba.fastjson.JSONArray;

import java.io.Serializable;

/**
 * @描述 登录用户实体类
 * @作者 gsh
 * @时间 2017/4/2 10:39
 */

public class LoginUserVO implements Serializable {

    private Integer id;
    //用户名【体验版】
    private String userNameTest;
    //密码【体验版】
    private String userPwdTest;
    //用户名
    private String userName;
    //密码
    private String userPwd;
    //token
    private String token;
    //用户真实姓名
    private String userNick;
    //服务
    private JSONArray services;

    public String getUserNameTest() {
        return userNameTest;
    }

    public void setUserNameTest(String userNameTest) {
        this.userNameTest = userNameTest;
    }

    public String getUserPwdTest() {
        return userPwdTest;
    }

    public void setUserPwdTest(String userPwdTest) {
        this.userPwdTest = userPwdTest;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public JSONArray getServices() {
        return services;
    }

    public void setServices(JSONArray services) {
        this.services = services;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
