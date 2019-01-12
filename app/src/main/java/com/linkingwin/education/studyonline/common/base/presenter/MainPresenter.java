package com.linkingwin.education.studyonline.common.base.presenter;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.linkingwin.education.studyonline.common.base.BasePresenter;
import com.linkingwin.education.studyonline.common.base.MyApplication;
import com.linkingwin.education.studyonline.common.base.consts.Constants;
import com.linkingwin.education.studyonline.common.base.interfaces.IMainView;
import com.linkingwin.education.studyonline.common.base.model.vo.LoginUserVO;
import com.linkingwin.education.studyonline.common.base.model.vo.SystemInfo;
import com.linkingwin.education.studyonline.common.http.IHttpService;
import com.linkingwin.education.studyonline.common.http.impl.HttpServiceImpl;

import org.xutils.common.Callback;

import java.util.List;

/**
 * @Desc
 * @Author Willowgao
 * @Version V1.0
 * @Date 2018/1/5
 */

public class MainPresenter extends BasePresenter {

    private IMainView mainView;
    private Context mContext;
    private IHttpService httpService;

    public MainPresenter(Context mContext, IMainView iMainView) {
        super(mContext);
        this.mainView = iMainView;
        this.mContext = mContext;
        this.httpService = new HttpServiceImpl(mContext);
    }


    /**
     * 检查用户是否有系统权限
     *
     * @param vo
     * @param systemid
     * @return
     */
    public static boolean checkSysRole(LoginUserVO vo, String systemid) {
        boolean bool = false;
        List<SystemInfo> systems = MyApplication.getInstance().getUserSys(vo.getUserName());
        for (SystemInfo system : systems) {
            if (system.getId().equals(systemid)) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    /**
     * 获取服务器端最新app版本信息
     */
    public void selectVersion() {
        JSONObject params = new JSONObject();
        params.put("sign", Constants.APP_SIGN);
        params.put("islatest", "1");
        try {
            httpService.post(Constants.SystemID.SAASPT, Constants.HttpConsts.URL_SELECT_VERSION, params, new IHttpService.RequestCallback() {
                @Override
                public void onSuccess(Object result) {
                    JSONObject obj = JSON.parseObject(result.toString());
                    JSONObject version = obj.getJSONObject("result");
                    if (version != null) {
                        if (version.getIntValue("vnum") > mainView.getAppVersionCode()) {
                            mainView.showVersionUpdate(version);
                        } else {
                            mainView.toMain();
                        }
                    }
                }

                @Override
                public void onFail(String errMsg) {
                    Log.e("查询版本信息出错 - 错误信息", errMsg);
                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {
                    Log.e("查询版本信息出错 - 错误信息", ex.getMessage());
                }

                @Override
                public void onCancelled(Callback.CancelledException cex) {

                }

                @Override
                public void onFinished() {
                    //MyApplication.getInstance().setShowUpdate(false);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
