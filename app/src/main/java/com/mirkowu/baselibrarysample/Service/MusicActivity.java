package com.mirkowu.baselibrarysample.Service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.mirkowu.baselibrarysample.R;

/**
 * Created by HAOJI on 2019/9/7.
 */

public class MusicActivity extends Activity {

    private MusicServices services;


    private ServiceConnection con =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicServices.MyBinder binder= (MusicServices.MyBinder) iBinder;
            MusicServices service = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
