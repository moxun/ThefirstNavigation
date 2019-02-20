package com.example.administrator.thefirstnavigation.adapter;

import android.view.View;
import android.widget.ImageView;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.adapter.BaseAdapter;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;

import java.util.List;

/**
 * Created by Administrator on 2019/2/3.
 */

public class MyTopicAdapter extends BaseAdapter<HotBean.DataBean> {

    public List<HotBean.DataBean> mList;
    private setOnClickListener mSetOnClickListener1;

    public MyTopicAdapter(List<HotBean.DataBean> dataList) {
        super(dataList);
        this.mList=dataList;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_mytopic;
    }

    @Override
    public void addAll(List<HotBean.DataBean> list, int page) {

    }

    @Override
    public void createHolder(ViewHolder holder, final HotBean.DataBean dataBean, int position) {
        holder.setText(R.id.tag_lv_title,dataBean.getTag());
        final ImageView viewById = holder.itemView.findViewById(R.id.tag_lv_img);

        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetOnClickListener1.setOnClickListener(dataBean);
            }
        });
    }
    public  interface  setOnClickListener{
        void setOnClickListener(HotBean.DataBean hotBean);
    }

    public  void OnsetOnClickListener(setOnClickListener setOnClickListener){
        mSetOnClickListener1 = setOnClickListener;
    }
}
