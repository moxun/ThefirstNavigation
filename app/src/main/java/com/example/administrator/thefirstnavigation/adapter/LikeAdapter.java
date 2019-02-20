package com.example.administrator.thefirstnavigation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListNoiftyBean;
import com.example.administrator.thefirstnavigation.units.QQPoint.QQBezierView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/2/14.
 */

public class LikeAdapter extends RecyclerView.Adapter {
    public ArrayList<ListNoiftyBean.DataBean> mList;
    private final Context context;

    public LikeAdapter(ArrayList<ListNoiftyBean.DataBean> dataBeans, Context context) {
        this.mList=dataBeans;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_likenotify, parent, false);
        return new SwipeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        ListNoiftyBean.DataBean dataBean = mList.get(position);
        SwipeHolder swipeHolder= (SwipeHolder) holder;
        swipeHolder.setIsRecyclable(false);
        if(position>3){
            swipeHolder.qq_point.setVisibility(View.GONE);
        }
        RequestOptions requestOptions = RequestOptions.circleCropTransform();

        Glide.with(context).load(mList.get(position).getHeadImagePath()).apply(requestOptions).into(swipeHolder.head);
        swipeHolder.tv_name.setText(mList.get(position).getNickname());
        swipeHolder.tv_time.setText(mList.get(position).getNotifyTime());
        swipeHolder.tv_to_content.setText(dataBean.getFromTitle());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class SwipeHolder extends RecyclerView.ViewHolder {
        private TextView tv_to_content, tv_name, tv_to_delete, tv_content,tv_time;

        private QQBezierView qq_point;
        private ImageView head;
        public SwipeHolder(View itemView) {
            super(itemView);
            tv_to_content=itemView.findViewById(R.id.content);
//            tv_to_top = (TextView) itemView.findViewById(R.id.tv_to_top);
            head=itemView.findViewById(R.id.item_notify_image);
//            tv_to_delete = (TextView) itemView.findViewById(R.id.tv_to_delete);
            tv_name=itemView.findViewById(R.id.item_notify_name);
            qq_point = (QQBezierView) itemView.findViewById(R.id.qq_point);

            tv_time=itemView.findViewById(R.id.item_notify_time);
        }
    }
}
