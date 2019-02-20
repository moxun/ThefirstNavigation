package com.example.administrator.thefirstnavigation.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.activity.FollowActivity;
import com.example.administrator.thefirstnavigation.base.adapter.BaseAdapter;
import com.example.administrator.thefirstnavigation.bean.httpbane.FollowBean;

import java.util.List;

/**
 * Created by Administrator on 2019/2/13.
 */

public class FollowAdapter extends BaseAdapter<FollowBean.FollowListBean> {
    private final Context context;
    public   List<FollowBean.FollowListBean> mList;
    private setOnClickListener mSetOnClickListener1;

    public FollowAdapter(List<FollowBean.FollowListBean> dataList, Context context) {
        super(dataList);
        this.mList=dataList;
        this.context=context;
    }



    @Override
    public int getLayoutId() {
        return R.layout.item_follow;
    }

    @Override
    public void addAll(List<FollowBean.FollowListBean> list, int page) {

    }

    @Override
    public void createHolder(ViewHolder holder, final FollowBean.FollowListBean followListBean, final int position) {
        if(followListBean.getNickname()!=null){
            holder.setText(R.id.item_name,followListBean.getNickname());
        }
        if(followListBean.getFollowTime()!=null){
            holder.setText(R.id.item_time,followListBean.getFollowTime());
        }
        if(followListBean.getPersonalProfile()!=null&&!followListBean.getPersonalProfile().equals("")){
            holder.setText(R.id.item_title,followListBean.getPersonalProfile());
        }
        ImageView imageView=holder.itemView.findViewById(R.id.image_head);
        if(!followListBean.getHeadImagePath().equals("http://39.107.254.232/firstga/imagesnull")){
            RequestOptions requestOptions1 = RequestOptions.circleCropTransform();
            Glide.with(context).load(followListBean.getHeadImagePath()).apply(requestOptions1).into(imageView);
        }
        Button button=holder.itemView.findViewById(R.id.btnDelete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mSetOnClickListener1.setOnClickListener(followListBean);
            }
        });

    }
       public  interface  setOnClickListener{
               void setOnClickListener(FollowBean.FollowListBean followListBean);
           }

           public  void OnsetOnClickListener(setOnClickListener setOnClickListener){
               mSetOnClickListener1 = setOnClickListener;
           }
}
