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
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.activity.MineTopicActivity;
import com.example.administrator.thefirstnavigation.bean.httpbane.MineTopicBean;

import java.util.List;

/**
 * Created by Administrator on 2019/2/15.
 */

public class MineTopicAdapter extends RecyclerView.Adapter{
    private final List<MineTopicBean.FavouritTopicListBean> mList;
    private final Context context;
    private setOnClickListener mSetOnClickListener1;

    public MineTopicAdapter(List<MineTopicBean.FavouritTopicListBean> favouritTopicList, Context mineTopicActivity) {
        this.mList=favouritTopicList;
        this.context=mineTopicActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_usertopic, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        final MineTopicBean.FavouritTopicListBean bean = mList.get(position);
        viewHolder.time.setText(bean.getPublishTime());
        viewHolder.title.setText(bean.getTitle());
        viewHolder.read.setText(bean.getPageviews()+"");
        viewHolder.comment.setText(bean.getComments()+"");
        viewHolder.like.setText(bean.getLikes()+"");
        if(bean.getImageListThumb()!=null){
            Glide.with(context).load(bean.getImageListThumb().get(0)).into(viewHolder.mIv);
        }
        viewHolder.bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetOnClickListener1.setOnClickListener(bean);
            }
        });
    }
       public  interface  setOnClickListener{
               void setOnClickListener(MineTopicBean.FavouritTopicListBean favouritTopicListBean);
           }

           public  void OnsetOnClickListener(setOnClickListener setOnClickListener){
               mSetOnClickListener1 = setOnClickListener;
           }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView time,bianji,title,read,comment,like;
        private ImageView mIv;

        public ViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.item_userTopic_time);
            bianji = itemView.findViewById(R.id.item_userTopic_bianJi);
            title=itemView.findViewById(R.id.item_userTopic_title);
            read=itemView.findViewById(R.id.item_userTopic_readSize);
            comment=itemView.findViewById(R.id.item_userTopic_commentSize);
            like=itemView.findViewById(R.id.item_userTopic_likeSize);
            mIv=itemView.findViewById(R.id.item_userTopic_image);
        }
    }
}
