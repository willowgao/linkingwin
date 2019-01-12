package com.linkingwin.education.studyonline.common.base.interfaces;


/**
 * @描述 用户登录view接口
 * @作者 gsh
 * @时间 2017/4/2 10:44
 */

public interface ILoginView extends IBaseView{
    //获取用户名
    String getUserName();
    //获取登录密码
    String getUserPwd();
    //是否记住密码
    Boolean isRememberPwd();
    //显示同步基础数据进度
    void showSyncSysDataProgress(String msg);
    //同步基础数据失败
    void syncSysDataFail();
    //跳转到主界面
    void toMainActivity();

}
