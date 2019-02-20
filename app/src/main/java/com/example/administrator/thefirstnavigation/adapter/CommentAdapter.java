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
import com.example.administrator.thefirstnavigation.bean.httpbane.CommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.InfoBean;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyHolder>{
    private Context context;
    public List<InfoBean> list;


    public CommentAdapter(Context context, List<InfoBean> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public CommentAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment, null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }
    public  void  addAll(List<InfoBean> list){
        list.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.MyHolder holder, final int position) {
       holder.news_tv_time.setText(list.get(position).getCommentTime());
        holder.news_content.setText(list.get(position).getNickname());
        holder.news_tv_username.setText(list.get(position).getContent());
        RequestOptions requestOptions1 = RequestOptions.circleCropTransform();
        Glide.with(context).load(list.get(position).getHeadImagePath()).apply(requestOptions1).into(holder.news_img_head);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView news_img_head;
        private TextView news_tv_username;
        private TextView news_tv_time;
        private ImageView news_img_praise;
        private TextView news_content;
        public MyHolder(View itemView) {
            super(itemView);
            news_img_head = itemView.findViewById(R.id.news_img_head);
            news_tv_username = itemView.findViewById(R.id.news_tv_username);
            news_tv_time = itemView.findViewById(R.id.news_tv_time);
            news_img_praise = itemView.findViewById(R.id.news_img_praise);
            news_content=itemView.findViewById(R.id.textView4);
        }
    }
}
