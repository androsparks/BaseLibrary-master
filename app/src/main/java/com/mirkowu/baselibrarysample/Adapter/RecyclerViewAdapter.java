package com.mirkowu.baselibrarysample.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mirkowu.baselibrarysample.R;
import com.mirkowu.baselibrarysample.bean.WheatherBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOJI on 2019/8/2.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public Context mContext;
    public List<WheatherBean> mList=new ArrayList<>();

    public RecyclerViewAdapter(List<WheatherBean> list, Context context) {
        this.mList = list;
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView,textView2;
        public ImageView imageView;
        public LinearLayout ll;

        public ViewHolder(View view) {
            super(view);
//            imageView = view.findViewById(R.id.id_iv);
            textView = view.findViewById(R.id.id_Tv);
            textView2 = view.findViewById(R.id.id_Tv2);
//            ll = view.findViewById(R.id.id_ll);
        }
    }

    @NonNull
    @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        Log.e("llll","-onCreateViewHolder--");
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        WheatherBean wheatherBean =mList.get(position);

          holder.textView.setText(wheatherBean.getName());
          holder.textView2.setText(String.valueOf(wheatherBean.getId()));
//          holder.imageView.setBackgroundResource(itemBean.getImageId());
//        Log.e("llll","-onBindViewHolder--");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}
