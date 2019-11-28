package com.mirkowu.baselibrarysample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by HAOJI on 2019/9/4.
 */

public class MVideoView extends VideoView{
        public MVideoView(Context context) {
            super(context);
        }

        public MVideoView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            //此处设置的默认值可随意,因为getDefaultSize中的size是有值的
            int width = getDefaultSize(0,widthMeasureSpec);
            int height = getDefaultSize(0,heightMeasureSpec);
            setMeasuredDimension(width,height);
            System.out.println("======onMeasure===width==="+width);
            System.out.println("======onMeasure===height==="+height);
        }

}
