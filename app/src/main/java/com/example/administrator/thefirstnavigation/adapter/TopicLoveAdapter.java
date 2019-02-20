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
import com.example.administrator.thefirstnavigation.activity.FavouriteActivity;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteTopicBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by Administrator on 2019/2/13.
 */

public class TopicLoveAdapter  extends RecyclerView.Adapter {
    private final List<FavouriteTopicBean.FavouritTopicListBean> mList;
    private final Context context;

    public TopicLoveAdapter(List<FavouriteTopicBean.FavouritTopicListBean> favouritTopicList, Context context) {
        this.mList=favouritTopicList;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_collectiontopictwo, null, false);
            return new MyViewHolder1(inflate);
        }else if(viewType==2){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_collectiontopicthree, null, false);
            return new MyViewHolder2(inflate);
        }else{
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_collectiontopic, null, false);
            return new MyViewHolder3(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==1){
            MyViewHolder1 myViewHolder1= (MyViewHolder1) holder;
            FavouriteTopicBean.FavouritTopicListBean bean = mList.get(position);
            if(bean.getComment()!=null){
                myViewHolder1.mComment.setText((String) bean.getComment());
            }
            if(bean.getNickname()!=null){
                myViewHolder1.mName.setText(bean.getNickname());
            }
            if(!bean.getHeadImagePath().equals("http://39.107.254.232/firstga/imagesnull")){
                RequestOptions requestOptions1 = RequestOptions.circleCropTransform();
                Glide.with(context).load(bean.getHeadImagePath()).apply(requestOptions1).into(myViewHolder1.mImageView);
            }
            if(bean.getPublishTime()!=null){
                myViewHolder1.mTime.setText(bean.getPublishTime());
            }
            if(bean.getShareLink()!=null){
                myViewHolder1.mShare.setText((String) bean.getShareLink());
            }
            if(bean.getTitle()!=null){
                myViewHolder1.mTitle.setText(bean.getTitle());
            }
        }else if(getItemViewType(position)==2){
            MyViewHolder2 myViewHolder2= (MyViewHolder2) holder;
            FavouriteTopicBean.FavouritTopicListBean bean = mList.get(position);
            if(bean.getComment()!=null){
                myViewHolder2.mComment.setText((String) bean.getComment());
            }
            if(bean.getNickname()!=null){
                myViewHolder2.mName.setText(bean.getNickname());
            }
            if(!bean.getHeadImagePath().equals("http://39.107.254.232/firstga/imagesnull")){
                RequestOptions requestOptions1 = RequestOptions.circleCropTransform();
                Glide.with(context).load(bean.getHeadImagePath()).apply(requestOptions1).into(myViewHolder2.mImageView);
            }
            if(bean.getPublishTime()!=null){
                myViewHolder2.mTime.setText(bean.getPublishTime());
            }
            if(bean.getTitle()!=null){
                myViewHolder2.mTitle.setText(bean.getTitle());
            }
            Glide.with(context).load(bean.getImageListThumb().get(0)).into(myViewHolder2.mImage_1);
        }else{
            MyViewHolder3 myViewHolder3= (MyViewHolder3) holder;
            FavouriteTopicBean.FavouritTopicListBean bean = mList.get(position);
            if(bean.getComment()!=null){
                myViewHolder3.mComment.setText((String) bean.getComment());
            }
            if(bean.getNickname()!=null){
                myViewHolder3.mName.setText(bean.getNickname());
            }
            if(bean.getHeadImagePath()!=null){
                RequestOptions requestOptions1 = RequestOptions.circleCropTransform();
                Glide.with(context).load(bean.getHeadImagePath()).apply(requestOptions1).into(myViewHolder3.mImageView);
            }
            if(bean.getPublishTime()!=null){
                myViewHolder3.mTime.setText(bean.getPublishTime());
            }
            if(bean.getTitle()!=null){
                myViewHolder3.mTitle.setText(bean.getTitle());
            }
            Glide.with(context).load(bean.getImageListThumb().get(0)).into(myViewHolder3.mImage_1);
            Glide.with(context).load(bean.getImageListThumb().get(1)).into(myViewHolder3.mImage_2);
            Glide.with(context).load(bean.getImageListThumb().get(2)).into(myViewHolder3.mImage_3);

        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(mList.get(position).getImageListThumb()!=null){
            if(mList.get(position).getImageListThumb().size()<3){
                return 2;
            }else{
                return 3;
            }
        }else{
            return 1;
        }
    }
    class MyViewHolder1 extends XRecyclerView.ViewHolder {

        private final TextView mTitle;
        private final TextView mTime;
        private final ImageView mImageView;
        private final TextView mName;
        private final TextView mShare;
        private final TextView mComment;
        public MyViewHolder1(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.item_title);
            mTime = itemView.findViewById(R.id.item_time);
            mImageView=itemView.findViewById(R.id.item_head);
            mName=itemView.findViewById(R.id.item_name);
            mShare=itemView.findViewById(R.id.item_share);
            mComment=itemView.findViewById(R.id.item_comment);
        }
    }

    class MyViewHolder2 extends XRecyclerView.ViewHolder {
        private final TextView mTitle;
        private final TextView mTime;
        private final ImageView mImageView;
        private final TextView mName;

        private final TextView mComment;
        private final ImageView mImage_1;
        public MyViewHolder2(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.item_title);
            mTime = itemView.findViewById(R.id.item_time);
            mImageView=itemView.findViewById(R.id.item_head);
            mName=itemView.findViewById(R.id.item_name);

            mComment=itemView.findViewById(R.id.item_comment);
            mImage_1=itemView.findViewById(R.id.item_image_1);
        }
    }

    class MyViewHolder3 extends XRecyclerView.ViewHolder {
        private final TextView mTitle;
        private final TextView mTime;
        private final ImageView mImageView;
        private final TextView mName;

        private final TextView mComment;
        private final ImageView mImage_1;
        private final ImageView mImage_2;
        private final ImageView mImage_3;
        public MyViewHolder3(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.item_title);
            mTime = itemView.findViewById(R.id.item_time);
            mImageView=itemView.findViewById(R.id.item_image);
            mName=itemView.findViewById(R.id.item_name);

            mComment=itemView.findViewById(R.id.item_comment);
            mImage_1=itemView.findViewById(R.id.item_image_1);
            mImage_2=itemView.findViewById(R.id.item_image_2);
            mImage_3=itemView.findViewById(R.id.item_image_3);
        }
    }
}
