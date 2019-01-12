package com.linkingwin.education.studyonline.common.base.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import com.linkingwin.education.studyonline.R;
import com.linkingwin.education.studyonline.common.base.MyApplication;
import com.linkingwin.education.studyonline.common.base.interfaces.ILoginView;
import com.linkingwin.education.studyonline.common.base.model.vo.LoginUserVO;
import com.linkingwin.education.studyonline.common.base.presenter.LoginPresenter;
import com.linkingwin.education.studyonline.common.utils.PermissionHelper;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 登录页
 */
@ContentView(R.layout.login_activity)
public class LoginActivity extends AppCompatActivity implements ILoginView {


    //用户登录处理类
    private LoginPresenter loginPresenter = new LoginPresenter(this,this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getInstance().addActivity(this);
        x.view().inject(this);
        PermissionHelper.checkLocationPermission(this);
        PermissionHelper.cameraPermission(this);
    }


    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getUserPwd() {
        return null;
    }

    @Override
    public Boolean isRememberPwd() {
        return null;
    }

    @Override
    public void showSyncSysDataProgress(String msg) {

    }

    @Override
    public void syncSysDataFail() {
        AlertDialog.Builder Builder=new AlertDialog.Builder(this).setMessage("同步基础数据失败,请重试!").setNegativeButton("重试", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // loginPresenter.syncSysData();
            }
        }).setPositiveButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyApplication.getInstance().finishActivity();
            }
        });
        Builder.create().show();
    }
    @Override
    public void toMainActivity() {
        MyApplication.getInstance().finishActivity(LoginActivity.this);
    }


    public String getAppVersionName() {
        PackageManager packageManager = this.getPackageManager();
        PackageInfo packageInfo;
        String versionName = "1.0.0";
        try {
            packageInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    @Override
    public void showToast(String message, int time) {

    }

    @Override
    public void showLoading(String message) {

    }

    @Override
    public void showLoading(String title, String message) {

    }

    @Override
    public void hideLoading() {

    }
}
