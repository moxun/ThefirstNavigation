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
import com.example.administrator.thefirstnavigation.bean.httpbane.ListCommentBean;


import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by lenovo on 2019/1/29.
 */

public class TopicListCommentAdapter extends RecyclerView.Adapter {
    public List<ListCommentBean.CommentListBean> mList;
    private Context mContext;

    public TopicListCommentAdapter(List<ListCommentBean.CommentListBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comm, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vo= (ViewHolder) holder;
        Glide.with(mContext).load(mList.get(position).getHeadImagePath()).into(vo.mHeadImage);
        vo.mName.setText(mList.get(position).getNickname());
        vo.mTime.setText(mList.get(position).getCommentTime());
        vo.mTitle.setText(mList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mHeadImage;
        private final TextView mFollow;
        private final TextView mName;
        private final TextView mTime;
        private final TextView mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mHeadImage = itemView.findViewById(R.id.item_topicComment_headImage);
            mFollow = itemView.findViewById(R.id.item_topicComment_follow);
            mName = itemView.findViewById(R.id.item_topicComment_name);
            mTime = itemView.findViewById(R.id.item_topicComment_time);
            mTitle = itemView.findViewById(R.id.item_topicComment_title);
        }
    }

    public void add(List<ListCommentBean.CommentListBean> list){
        this.mList=list;
        notifyDataSetChanged();
    }
}
