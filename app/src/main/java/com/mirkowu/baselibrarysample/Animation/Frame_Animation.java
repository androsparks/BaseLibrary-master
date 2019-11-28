package com.mirkowu.baselibrarysample.Animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.mirkowu.baselibrarysample.R;

/**
 * Created by HAOJI on 2019/9/9.
 */

public class Frame_Animation extends Activity {
    private ImageView id_iv;
    private AnimationDrawable ad;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity);
        id_iv=findViewById(R.id.id_iv);
        id_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scale_tween();
            }
        });
    }


    // 帧动画，1.设置 drawable 资源文件 2.代码设置
    private void frame() {
        id_iv.setImageResource(R.drawable.frame_animation);
         ad = (AnimationDrawable) id_iv.getDrawable();
        //  开始动画  ad.start.
        //  暂停动画  ad.start.
    }

   private void alpha_tween(){
       // 补间动画：透明度
       AlphaAnimation apa =new AlphaAnimation(0,1);
       apa.setDuration(3000);
       apa.setFillAfter(true);
       apa.setRepeatCount(3);
       apa.setRepeatMode(Animation.REVERSE);
       id_iv.startAnimation(apa);
   }

   private void scale_tween(){
       //补间动画 ，缩放
       ScaleAnimation scaleAnimation =new ScaleAnimation
               (0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
       scaleAnimation.setDuration(3000);// 每次动画持续时间3秒
       scaleAnimation.setFillAfter(true);// 动画最后停留在终止的状态
       scaleAnimation.setRepeatCount(1);// 动画重复的次数
       id_iv.startAnimation(scaleAnimation);
   }

   private void rotate_tweem(){

       /**
        * 创建一个Animation类型的XML文件：
        */

//<?xml version="1.0" encoding="utf-8"?>
//<rotate xmlns:android="http://schemas.android.com/apk/res/android"
//       android:fromDegrees="0"
//       android:toDegrees="180"
//       android:duration="3000"
//       android:interpolator="@android:anim/overshoot_interpolator"
//       android:fillAfter="true"
//       android:repeatCount="2"
//       android:repeatMode="reverse"
//       android:pivotX="50%"
//       android:pivotY="50%"
//               >
//    <!--fromDegrees:起始的度数
//       toDegrees：终止的度数
//       infinite：无限次数
//       起始度数大于终止度数，则能逆时针旋转，否则顺时针
//       android:pivotX="50%":旋转围绕的轴心，x方向位置，相对于自己的宽度的一半
//       android:pivotX="50%p":相对于父控件宽度的一半
//               -->
//</rotate>
   }

}
