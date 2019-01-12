package com.linkingwin.education.studyonline.common.base.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.linkingwin.education.studyonline.R;
import com.linkingwin.education.studyonline.common.base.model.vo.SpinnerVO;

import java.util.List;


/**
 * @Desc
 * @Author Willowgao
 * @Version V1.0
 * @Date 2018/6/25
 */

public class SpinnerAdapter extends ArrayAdapter<SpinnerVO> {

    private List<SpinnerVO> data_list;

    private Spinner obj;

    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List objects, Spinner obj) {
        super(context, resource, objects);
        this.data_list = objects;
        this.obj = obj;
    }

}
