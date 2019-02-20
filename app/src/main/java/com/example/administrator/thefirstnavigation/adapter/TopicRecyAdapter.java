package com.example.administrator.thefirstnavigation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.activity.TopicAvtivity;
import com.example.administrator.thefirstnavigation.app.MyApp;
import com.example.administrator.thefirstnavigation.base.adapter.BaseAdapter;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;

import java.util.List;

/**
 * Created by Administrator on 2019/1/28.
 */

public class TopicRecyAdapter extends BaseAdapter<TopicBean.TopicListBean> {
    public List<TopicBean.TopicListBean> mList;
    private final Context context;

    public TopicRecyAdapter(List<TopicBean.TopicListBean> dataList, Context context) {
        super(dataList);
        this.mList=dataList;
        this.context=context;
    }

    @Override
    public void addAll(List<TopicBean.TopicListBean> list, int page) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_topic_one;
    }


    public void setSearch(List<TopicBean.TopicListBean> data) {

        mList.addAll(0,data);
        notifyDataSetChanged();
    }

    @Override
    public void createHolder(ViewHolder holder, final TopicBean.TopicListBean topicBean, int position) {
        holder.setText(R.id.item_name,topicBean.getNickname());
        holder.setText(R.id.item_time,topicBean.getPublishTime());
        holder.setText(R.id.item_comment,topicBean.getTitle());
        holder.setText(R.id.item_read,topicBean.getPageviews()+"");
        holder.setText(R.id.item_ping,topicBean.getComments()+"");
        holder.setText(R.id.item_like,topicBean.getLikes()+"");
        ImageView imageView=holder.itemView.findViewById(R.id.item_image);
        final ImageView image=holder.itemView.findViewById(R.id.item_tu2);
        TextView textView=holder.itemView.findViewById(R.id.read);
        RequestOptions requestOptions1 = RequestOptions.circleCropTransform();

        Glide.with(MyApp.getMyApp()).load(topicBean.getHeadImagePath()).apply(requestOptions1).into(imageView);

        if(topicBean.getImageListThumb()!=null){

            if(topicBean.getImageListThumb().size()==3){
                holder.setPic(R.id.item_tu1,topicBean.getImageListThumb().get(0));
                holder.setPic(R.id.item_tu2,topicBean.getImageListThumb().get(1));
                holder.setPic(R.id.item_tu3,topicBean.getImageListThumb().get(2));

            }

            else{
                holder.setPic(R.id.item_tu2,topicBean.getImageListThumb().get(0));
            }
        }else{
            image.setImageResource(R.drawable.psb);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TopicAvtivity.class);
                intent.putExtra("id",topicBean.getTopicId());
                intent.putExtra("followid",topicBean.getUserId());
                context.startActivity(intent);
            }
        });

    }
}
