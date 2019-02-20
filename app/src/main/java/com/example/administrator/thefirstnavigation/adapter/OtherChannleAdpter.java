package com.example.administrator.thefirstnavigation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.app.MyApp;
import com.example.administrator.thefirstnavigation.bean.GreenBean.SeclectorBean;
import com.example.administrator.thefirstnavigation.units.dbunits.SelectorHelper;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by Administrator on 2019/1/22.
 */

public class OtherChannleAdpter extends RecyclerView.Adapter {


    public  List<SeclectorBean> mList;
    private setOnClickListener mSetOnClickListener1;

    public OtherChannleAdpter(List<SeclectorBean> othercannle) {
        this.mList=othercannle;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(MyApp.getMyApp()).inflate(R.layout.item_otherchannel, null, false);

        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1= (MyViewHolder) holder;
        holder1.mTitle.setText(mList.get(position).getChannelName());
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeclectorBean seclectorBean = mList.get(position);
                seclectorBean.setIsShow(true);
                SelectorHelper.getInstance().update(seclectorBean);
                mSetOnClickListener1.setOnClickListener(mList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends XRecyclerView.ViewHolder {

        private final TextView mTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.item_other_text);

        }
    }
       public  interface  setOnClickListener{
               void setOnClickListener(SeclectorBean seclectorBean);
               void setLongClickListener(View v ,int position);
           }

           public  void OnsetOnClickListener(setOnClickListener setOnClickListener){
               mSetOnClickListener1 = setOnClickListener;
           }
}
