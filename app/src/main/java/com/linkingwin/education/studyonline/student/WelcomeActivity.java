package com.linkingwin.education.studyonline.student;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.linkingwin.education.studyonline.R;
import com.linkingwin.education.studyonline.common.base.BaseActivity;
import com.linkingwin.education.studyonline.common.base.interfaces.IMainView;
import com.linkingwin.education.studyonline.common.base.presenter.MainPresenter;
import com.linkingwin.education.studyonline.common.http.HttpManager;

import org.xutils.view.annotation.ContentView;


@ContentView(R.layout.activity_welcome)
public class WelcomeActivity extends BaseActivity implements IMainView {
    MainPresenter presenter = new MainPresenter(this, this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!HttpManager.isNetworkConnected(this)) {
            Toast.makeText(this, "网络未连接，请检查您的网络!", Toast.LENGTH_LONG).show();
            return;
        }
        presenter.selectVersion();
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
