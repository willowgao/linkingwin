package com.linkingwin.education.studyonline.common.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.linkingwin.education.studyonline.R;
import com.linkingwin.education.studyonline.common.base.interfaces.IBaseView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * @描述 基础activity
 * @作者 gsh
 * @时间 2017/3/29 14:04
 */

@ContentView(R.layout.toolbar)
public class BaseActivity extends AppCompatActivity implements IBaseView {

    public static final int CHOICE_RESULT_CODE = 500;
    public static final String RESULT_KEY = "msg";


    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.tv_title)
    private TextView tv_title;
    @ViewInject(R.id.tv_subtitle)
    private TextView tv_subtitle;
    //进度条
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getInstance().addActivity(this);
        x.view().inject(this);
        init();
    }

    private void init() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        initToolbar();
    }

    private void initToolbar(){
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {//点击左上角返回键
                @Override
                public void onClick(View v) {
                    MyApplication.getInstance().finishActivity(BaseActivity.this);
                }
            });
        }

    }

    public void setToolbar(int resId, String title, String cusTitle, String subTitle){
        if (toolbar == null) return;
        if(resId==-1)
            toolbar.setNavigationIcon(null);
        else
            toolbar.setNavigationIcon(resId);
        toolbar.setTitle(title);
        tv_title.setText(cusTitle);
        tv_subtitle.setText(subTitle);
    }

    @Override
    public void showToast(String message, int time) {
        Toast.makeText(this, message, time).show();
    }

    @Override
    public void showLoading(String message) {
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    @Override
    public void showLoading(String title, String message) {
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            MyApplication.getInstance().finishActivity(this);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 监听Back键按下事件,方法1:
     * 注意:
     * super.onBackPressed()会自动调用finish()方法,关闭
     * 当前Activity.
     * 若要屏蔽Back键盘,注释该行代码即可
     */


}
