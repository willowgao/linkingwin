package com.linkingwin.education.studyonline.student;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.linkingwin.education.studyonline.R;
import com.linkingwin.education.studyonline.common.base.BaseActivity;
import com.linkingwin.education.studyonline.common.base.MainActivity;
import com.linkingwin.education.studyonline.common.base.interfaces.IMainView;
import com.linkingwin.education.studyonline.common.base.presenter.MainPresenter;
import com.linkingwin.education.studyonline.common.http.HttpManager;
import com.wrbug.timeline.TimeLineView;
import com.xyz.step.FlowViewHorizontal;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;


@ContentView(R.layout.activity_welcome)
public class WelcomeActivity extends BaseActivity implements IMainView {

   @ViewInject(R.id.hflowview4)
   FlowViewHorizontal mView;

    MainPresenter presenter = new MainPresenter(this, this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView.setProgress(3,4,new String[]{"申请面试","老师面试","开课考核","开课成功"},null);

    }


    @Override
    public void showVersionUpdate(final JSONObject version) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("发现新版本");
        builder.setMessage(version.getString("vdesc"));
        builder.setPositiveButton("更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Uri uri = Uri.parse(version.getString("url"));
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toMain();
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }


    @Override
    public int getAppVersionCode() {
        PackageManager packageManager = this.getPackageManager();
        PackageInfo packageInfo;
        int versionCode = 0;
        try {
            packageInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }



    @Override
    public void toMain() {

    }

}
