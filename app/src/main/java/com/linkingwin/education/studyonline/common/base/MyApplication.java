package com.linkingwin.education.studyonline.common.base;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.linkingwin.education.studyonline.common.base.model.vo.LoginUserVO;
import com.linkingwin.education.studyonline.common.base.model.vo.SysDicVO;
import com.linkingwin.education.studyonline.common.base.model.vo.SystemInfo;
import com.linkingwin.education.studyonline.common.utils.SharedPreUtil;
import org.xutils.BuildConfig;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述 继承Application
 * @作者 gsh
 * @时间 2017/3/29 9:16
 */

public class MyApplication extends Application {


    public LoginUserVO user;
    public List<SysDicVO> dicList;
    public List<SystemInfo> syss;

    public static Map<String, String> userMaps = new HashMap<>();
    /**
     * 打开的activity
     **/
    private List<Activity> activities = new ArrayList<Activity>();
    /**
     * 是否显示“app更新提示框”
     */
    public boolean showUpdate = true;

    public static volatile MyApplication instance;


    public static MyApplication getInstance() {
        // 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
        if (instance == null) {
            //同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
            synchronized (MyApplication.class) {
                //未初始化，则初始instance变量
                if (instance == null) {
                    instance = new MyApplication();
                }
            }
        }
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现

        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.

        SharedPreUtil.initSharedPreference(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
    }


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }


    /**
     * 新建了一个activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 结束指定的Activity
     *
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            this.activities.remove(activity);
            activity.finish();
            activity = null;
        }
    }


    /**
     * 应用退出，结束所有的activity
     */
    public void exit() {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
    }

    /**
     * 关闭Activity列表中的所有Activity
     */
    public void finishActivity() {
        for (Activity activity : activities) {
            if (null != activity) {
                activity.finish();
            }
        }
        //杀死该应用进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }


    public boolean isShowUpdate() {
        return showUpdate;
    }

    public void setShowUpdate(boolean showUpdate) {
        this.showUpdate = showUpdate;
    }


    public LoginUserVO getUser() {
        //if (user == null) {
        user = SharedPreUtil.getInstance().getUser();
        //}
        return user;
    }

    public void setUser(LoginUserVO user) {
        SharedPreUtil.getInstance().putUser(user);
        this.user = user;
    }


    public void setUserMap(JSONArray users) {
        for (Object user : users) {
            JSONObject userobj = JSONObject.parseObject(user.toString());
            userMaps.put(userobj.getString("id"), userobj.getString("uName"));
        }
    }


    public List<SysDicVO> getDicList(String systemId) {
        //if (dicList == null) {
        dicList = SharedPreUtil.getInstance().getDicList(systemId);
        //}
        return dicList;
    }

    public void setDicList(String systemId, List<SysDicVO> dicList) {
        SharedPreUtil.getInstance().putDicList(systemId, dicList);
        this.dicList = dicList;
    }

    public List<SystemInfo> getUserSys(String userCode) {
        if (syss == null) {
            syss = SharedPreUtil.getInstance().getUserSys(userCode);
        }
        return syss;
    }

    public void setSystemInfo(String userCode, List<SystemInfo> syss) {
        SharedPreUtil.getInstance().putUserSys(userCode, dicList);
        this.syss = syss;
    }


}
