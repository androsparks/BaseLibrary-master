package com.mirkowu.baselibrarysample.utils;

import android.content.Context;

import com.softgarden.baselibrary.dialog.LoadingDialog;

/**
 * Created by HAOJI on 2019/8/27.
 */

public class UserUtil {
    /**
     *  加载圆形进度条
     */

    public static void createLoadingDialog(Context context){
        LoadingDialog loadingDialog =new LoadingDialog(context);
        loadingDialog.setMessage("加载中");
        loadingDialog.show();
    }

}
