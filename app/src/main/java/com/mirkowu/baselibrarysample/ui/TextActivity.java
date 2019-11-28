package com.mirkowu.baselibrarysample.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.mirkowu.baselibrarysample.R;
import com.mirkowu.baselibrarysample.ui.webView.WebViewActivity;
import com.mirkowu.baselibrarysample.utils.ImageUtil;
import com.mirkowu.baselibrarysample.utils.UserUtil;
import com.softgarden.baselibrary.dialog.LoadingDialog;
import com.softgarden.baselibrary.dialog.LoadingDialogManager;

import butterknife.BindView;
import retrofit2.http.Url;


/**
 * Created by HAOJI on 2019/8/22.
 */

public class TextActivity extends Activity {
    private Context context =TextActivity.this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        WebViewActivity.start(context,"123","http://www.uc123.com/");
    }
}
