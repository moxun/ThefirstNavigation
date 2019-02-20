package com.example.administrator.thefirstnavigation.adapter;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.adapter.BaseAdapter;
import com.example.administrator.thefirstnavigation.bean.httpbane.MyCommentBean;

import java.util.List;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MyCommentAdapter extends BaseAdapter<MyCommentBean.UserCommentListBean> {

    private final List<MyCommentBean.UserCommentListBean> mList;
    private final String head;
    private final String name;

    public MyCommentAdapter(List<MyCommentBean.UserCommentListBean> dataList,String head, String nam) {
        super(dataList);
        this.mList=dataList;
        this.head=head;
        this.name=nam;
    }



    @Override
    public int getLayoutId() {
        return R.layout.item_usercomment;
    }

    @Override
    public void addAll(List<MyCommentBean.UserCommentListBean> list, int page) {

    }

    @Override
    public void createHolder(ViewHolder holder, MyCommentBean.UserCommentListBean userCommentListBean, int position) {
        holder.setText(R.id.item_userComment_name,name);
        holder.setPic(R.id.item_userComment_headImage,head);
        holder.setText(R.id.item_userComment_time,userCommentListBean.getCommentTime());
        holder.setText(R.id.item_userComment_content,userCommentListBean.getContent());
        holder.setText(R.id.item_twoTopic_title,userCommentListBean.getTitle());
    }
}
