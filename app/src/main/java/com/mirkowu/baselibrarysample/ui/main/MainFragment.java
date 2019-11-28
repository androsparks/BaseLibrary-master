package com.mirkowu.baselibrarysample.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.mirkowu.baselibrarysample.R;
import com.mirkowu.baselibrarysample.base.ToolbarFragment;
import com.mirkowu.baselibrarysample.ble.BLEManager;
import com.mirkowu.baselibrarysample.ui.LanguageActivity;
import com.mirkowu.baselibrarysample.ui.ScreenAdapterActivity;
import com.mirkowu.baselibrarysample.ui.SocketTestActivity;
import com.mirkowu.baselibrarysample.ui.TestToolbarActivity;
import com.mirkowu.baselibrarysample.ui.bluetooth.BLEManagerActivity;
import com.mirkowu.baselibrarysample.ui.testMvp.TestMvpActivity;
import com.mirkowu.baselibrarysample.ui.testRefresh.TestRefreshActivity;
import com.mirkowu.baselibrarysample.ui.webView.WebViewActivity;
import com.mirkowu.basetoolbar.BaseToolbar;
import com.softgarden.baselibrary.utils.BaseSPManager;
import com.softgarden.baselibrary.utils.L;

import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author by DELL
 * @date on 2018/2/24
 * @describe
 */

public class MainFragment extends ToolbarFragment {

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.mBtnBLETest)
    Button mBtnBLETest;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Nullable
    @Override
    protected BaseToolbar.Builder setToolbar(@NonNull BaseToolbar.Builder builder) {
        return builder.addLeftImage(R.mipmap.menu, v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).openDrawer();
            }
        });
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        mBtnBLETest.setText(String.format("蓝牙测试%s", BLEManager.getInstance().isConnected() ? "已连接" : "未连接"));

    }

    @Override
    protected void lazyLoad() {

        L.d("系统语言=" + Locale.getDefault().getLanguage() + "  " + Locale.getDefault().getCountry());
        L.d("语言=" + BaseSPManager.getLanguage().getLanguage() + "  " + BaseSPManager.getLanguage().getCountry());


    }

    @OnClick({R.id.mBtnChangeDayNightMode, R.id.mBtnChangeLanguage, R.id.mBtnMvpTemp,
            R.id.mBtnRefreshTemp, R.id.mBtnToolbarTemp, R.id.mBtnDataBindingTemp,
            R.id.mBtnSocketTest, R.id.mBtnBLETest, R.id.mBtnWebView})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.mBtnChangeDayNightMode://切换日夜模式
                BaseSPManager.setNightMode(!BaseSPManager.isNightMode());
                getBaseActivity().reload();
                break;
            case R.id.mBtnChangeLanguage://切换语言
                LanguageActivity.start(getContext());
                break;
            case R.id.mBtnMvpTemp://MVP模板
                TestMvpActivity.start(getActivity());
                break;
            case R.id.mBtnRefreshTemp://刷新页面模板
                TestRefreshActivity.start(getActivity());
                break;
            case R.id.mBtnToolbarTemp://Toolbar页面模板
                TestToolbarActivity.start(getActivity());
                break;
            case R.id.mBtnDataBindingTemp://Toolbar页面模板
                ScreenAdapterActivity.start(getActivity());
                break;
            case R.id.mBtnSocketTest://Socket
                SocketTestActivity.start(getActivity());
                break;
            case R.id.mBtnBLETest://ble
                //需要和Activity绑定业务的BLE连接
                // BLESearchActivity.start(getActivity());
                //需要跨界面或者全局 业务的BLE连接
                BLEManagerActivity.start(getActivity());

                break;
            case R.id.mBtnWebView://WebView
                WebViewActivity.start(getActivity(), "这是标题", "http://www.baidu.com/");
                break;

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BLEManager.getInstance().close();
    }

    @Override
    public void onRefresh() {

    }
}
