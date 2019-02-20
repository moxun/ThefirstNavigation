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
import com.example.administrator.thefirstnavigation.bean.httpbane.DownListNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 88888 on 2019/1/19.
 */

public class ShowNewListadapter extends XRecyclerView.Adapter {

    public List<UpdaterNewsBean.NewListBean> mData;
    private Context mContext;
    private setOnClickListener mSetOnClickListener1;

    public ShowNewListadapter(List<UpdaterNewsBean.NewListBean> data) {
        mData = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        if(viewType==0){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_information_one, null, false);
            return new MyViewHolder1(inflate);
        }else if(viewType==1){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_information_two, null, false);
            return new MyViewHolder2(inflate);
        }else if(viewType==2){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_information_three, null, false);
            return new MyViewHolder3(inflate);
        }else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_information_four, null, false);
            return new MyViewHolder4(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position)==0){
            MyViewHolder1 holder1 = (MyViewHolder1) holder;
            holder1.mTitle.setText(mData.get(position).getTitle());
            holder1.mTime.setText(mData.get(position).getPublishTime());
            if(position==0||position==1){
                holder1.mImageView.setVisibility(View.VISIBLE);
            }else{
                holder1.mImageView.setVisibility(View.GONE);
            }
        }else if(getItemViewType(position)==1){
            MyViewHolder2 holder2 = (MyViewHolder2) holder;
            holder2.mTitle.setText(mData.get(position).getTitle());
            holder2.mTime.setText(mData.get(position).getPublishTime());
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(holder2.mImage);
            if(position==0||position==1){
                holder2.mImageView.setVisibility(View.VISIBLE);
            }else{
                holder2.mImageView.setVisibility(View.GONE);
            }
        }else if(getItemViewType(position)==2){
            MyViewHolder3 holder3= (MyViewHolder3) holder;
            holder3.mTitle.setText(mData.get(position).getTitle());
            holder3.mTime.setText(mData.get(position).getPublishTime());
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(holder3.mImage1);
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(holder3.mImage2);
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(holder3.mImage3);
            if(position==0||position==1){
                holder3.mImageView.setVisibility(View.VISIBLE);
            }else{
                holder3.mImageView.setVisibility(View.GONE);
            }
        }else {
            MyViewHolder4 holder4= (MyViewHolder4) holder;
            holder4.mTitle.setText(mData.get(position).getTitle());
            holder4.mTime.setText(mData.get(position).getPublishTime());
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(holder4.mImage);
            if(position==0||position==1){
                holder4.mImageView.setVisibility(View.VISIBLE);
            }else{
                holder4.mImageView.setVisibility(View.GONE);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetOnClickListener1.setOnClickListener(mData.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).getLayoutType().contains("1")) {
            return 0;
        } else if (mData.get(position).getLayoutType().contains("2")) {
            return 1;
        } else if (mData.get(position).getLayoutType().contains("3")) {
            return 2;
        } else{
            return 3;
        }
    }

    public void setData(List<UpdaterNewsBean.NewListBean> data,String cur) {

        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void setSearch(List<UpdaterNewsBean.NewListBean> data) {

        mData.addAll(0,data);
        notifyDataSetChanged();
    }


    class MyViewHolder1 extends XRecyclerView.ViewHolder {

        private final TextView mTitle;
        private final TextView mTime;
        private final ImageView mImageView;
        public MyViewHolder1(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mTime = itemView.findViewById(R.id.time);
            mImageView=itemView.findViewById(R.id.image_top);
        }
    }

    class MyViewHolder2 extends XRecyclerView.ViewHolder {
        private final TextView mTitle;
        private final TextView mTime;
        private final ImageView mImage;
        private final ImageView mImageView;
        public MyViewHolder2(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mTime = itemView.findViewById(R.id.time);
            mImage = itemView.findViewById(R.id.image);
            mImageView=itemView.findViewById(R.id.image_top);
        }
    }

    class MyViewHolder3 extends XRecyclerView.ViewHolder {
        private final TextView mTitle;
        private final TextView mTime;
        private final ImageView mImage1;
        private final ImageView mImage2;
        private final ImageView mImage3;
        private final ImageView mImageView;
        public MyViewHolder3(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mTime = itemView.findViewById(R.id.time);
            mImage1 = itemView.findViewById(R.id.image1);
            mImage2 = itemView.findViewById(R.id.image2);
            mImage3 = itemView.findViewById(R.id.image3);
            mImageView=itemView.findViewById(R.id.image_top);
        }
    }

    class MyViewHolder4 extends XRecyclerView.ViewHolder {
        private final TextView mTitle;
        private final TextView mTime;
        private final ImageView mImage;
        private final ImageView mImageView;
        public MyViewHolder4(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mTime = itemView.findViewById(R.id.time);
            mImage = itemView.findViewById(R.id.image);
            mImageView=itemView.findViewById(R.id.image_top);
        }
    }
       public  interface  setOnClickListener{
               void setOnClickListener(UpdaterNewsBean.NewListBean newsListBean);
           }

           public  void OnsetOnClickListener(setOnClickListener setOnClickListener){
               mSetOnClickListener1 = setOnClickListener;
           }
}
