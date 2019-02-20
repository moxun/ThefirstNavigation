package com.example.administrator.thefirstnavigation.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.adapter.BaseAdapter;
import com.example.administrator.thefirstnavigation.bean.httpbane.MoreFollowBean;

import java.util.List;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MoreFollowAdapter extends BaseAdapter<MoreFollowBean.MoreFollowListBean> {
    private final List<MoreFollowBean.MoreFollowListBean> mList;
    private final Context context;
    private setOnClickListener mSetOnClickListener1;
    private int mFollowers;

    public MoreFollowAdapter(List<MoreFollowBean.MoreFollowListBean> dataList, Context context) {
        super(dataList);
        this.mList=dataList;
        this.context=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_morefollow;
    }

    @Override
    public void addAll(List<MoreFollowBean.MoreFollowListBean> list, int page) {

    }

    @Override
    public void createHolder(final ViewHolder holder, final MoreFollowBean.MoreFollowListBean followListBean, int position) {
        if(followListBean.getNickname()!=null){
            holder.setText(R.id.item_name,followListBean.getNickname());
        }
        mFollowers = followListBean.getFollowers();
        holder.setText(R.id.item_guanzhu, mFollowers +"关注");
        final ImageView imageView=holder.itemView.findViewById(R.id.item_head);
        if(!followListBean.getHeadImagePath().equals("http://39.107.254.232/firstga/imagesnull")){

            Glide.with(context).load(followListBean.getHeadImagePath()).into(imageView);
        }
        final ImageView imageView1=holder.itemView.findViewById(R.id.add_follow);
        final TextView textView=holder.itemView.findViewById(R.id.item_guan);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!followListBean.isGuanzhu()){
                    mSetOnClickListener1.setOnClickListener(followListBean);
                    imageView1.setVisibility(View.GONE);
                    textView.setVisibility(View.VISIBLE);
                    followListBean.setGuanzhu(true);
                    mFollowers++;
                    holder.setText(R.id.item_guanzhu, mFollowers +"关注");
                }
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(followListBean.isGuanzhu()){
                    mSetOnClickListener1.setOnClickListener(followListBean);
                    imageView1.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.GONE);
                    followListBean.setGuanzhu(false);
                    mFollowers--;
                    holder.setText(R.id.item_guanzhu, mFollowers +"关注");
                }
            }
        });
    }
       public  interface  setOnClickListener{
               void setOnClickListener( MoreFollowBean.MoreFollowListBean followListBean);
           }

           public  void OnsetOnClickListener(setOnClickListener setOnClickListener){
               mSetOnClickListener1 = setOnClickListener;
           }
}
