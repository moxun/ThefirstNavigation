package com.example.administrator.thefirstnavigation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class ChannleAdapter extends RecyclerView.Adapter {
    public List<SeclectorBean> mList;
    private boolean mBoolean;
    private setOnClickListener mSetOnClickListener1;

    public ChannleAdapter(List<SeclectorBean> cannle) {
        this.mList=cannle;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(MyApp.getMyApp()).inflate(R.layout.item_mychannel, null, false);

        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder holder1= (MyViewHolder) holder;

        holder1.mTitle.setText(mList.get(position).getChannelName());
        if(mBoolean){
            if(position==0){
                holder1.mTime.setVisibility(View.GONE);
                holder1.itemView.setEnabled(false);
            }else{

                holder1.mTime.setVisibility(View.VISIBLE);
                holder1.itemView.setEnabled(true);
            }

            holder1.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(mOnItemLongClickListener!=null){
                        mOnItemLongClickListener.OnItemLongClick(v, holder1,position);
                    }
                    return false;
                }
            });
        }else{
            holder1.mTime.setVisibility(View.GONE);
            holder1.itemView.setEnabled(false);
        }
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeclectorBean seclectorBean = mList.get(position);
               seclectorBean.setIsShow(false);
                SelectorHelper.getInstance().update(seclectorBean);
                mSetOnClickListener1.setOnClickListener(mList.get(position));
            }
        });
        holder1.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mOnItemLongClickListener!=null){
                    mOnItemLongClickListener.OnItemLongClick(v, holder1,position);
                }
                return false;
            }
        });

    }

    public void show(boolean b){
        Log.d("lol", "show: "+b);
        this.mBoolean=b;
        notifyDataSetChanged();
    }
    public void addAll(List<SeclectorBean> list){
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public class MyViewHolder extends XRecyclerView.ViewHolder {

        private final TextView mTitle;
        private final ImageView mTime;
        private final ImageView mImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.item_my_text);
            mTime = itemView.findViewById(R.id.item_my_delete);
            mImageView=itemView.findViewById(R.id.item_my_image);
        }
    }
    public  interface  setOnClickListener{
        void setOnClickListener(SeclectorBean seclectorBean);

    }

    public  void OnsetOnClickListener(setOnClickListener setOnClickListener){
        mSetOnClickListener1 = setOnClickListener;
    }

    private OnItemLongClickListener mOnItemLongClickListener;

    public interface OnItemLongClickListener {
        void OnItemLongClick(View v,MyViewHolder holder, int position);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }
}
