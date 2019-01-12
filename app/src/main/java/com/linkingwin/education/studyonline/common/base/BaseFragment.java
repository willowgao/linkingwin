package com.linkingwin.education.studyonline.common.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.linkingwin.education.studyonline.common.base.interfaces.IBaseView;


/**
 * @描述
 * @作者 gsh
 * @时间 2017/5/26 16:51
 */

public class BaseFragment extends Fragment implements IBaseView {
    //进度条
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setCanceledOnTouchOutside(false);
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
    public void showToast(String message, int time) {
        Toast.makeText(this.getContext(),message,time).show();
    }

}
