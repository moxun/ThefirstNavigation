package com.example.administrator.thefirstnavigation.adapter;


import android.view.View;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.adapter.BaseAdapter;
import com.example.administrator.thefirstnavigation.bean.GreenBean.HistoryBean;

import java.util.List;

/**
 * Created by Administrator on 2019/1/23.
 */

public class HistoryAdapter extends BaseAdapter<HistoryBean> {

    public List<HistoryBean> mList;
    private setOnClickListener mSetOnClickListener1;

    public HistoryAdapter(List<HistoryBean> dataList) {
        super(dataList);
        this.mList=dataList;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_history;
    }

    @Override
    public void addAll(List<HistoryBean> list, int page) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void createHolder(ViewHolder holder, final HistoryBean historyBean, int position) {
        holder.setText(R.id.item_text,historyBean.getHistory());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetOnClickListener1.setOnClickListener(historyBean);
            }
        });
    }
       public  interface  setOnClickListener{
               void setOnClickListener(HistoryBean newsListBean);
           }

           public  void OnsetOnClickListener(setOnClickListener setOnClickListener){
               mSetOnClickListener1 = setOnClickListener;
           }
}
