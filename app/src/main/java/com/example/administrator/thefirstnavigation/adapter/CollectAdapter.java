package com.example.administrator.thefirstnavigation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteNews;

import java.util.ArrayList;
import java.util.List;

public class CollectAdapter extends RecyclerView.Adapter {
    public List<FavouriteNews> mList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongListener mOnItemLongListener;
    private Boolean isShowDelete = false;
    private Boolean flag = true;
    private List<FavouriteNews> mDelete = new ArrayList<>();
    public List<FavouriteNews> mDelete1 = new ArrayList<>();
    private boolean isSelect=true;

    public CollectAdapter(List<FavouriteNews> list, Context context) {
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.collectitem, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder holder1 = (ViewHolder) holder;
        holder1.mTv.setText(mList.get(position).getTitle());
        holder1.mIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.OnItemClick(mList.get(position),holder1.mIv);
            }
        });
        if(isShowDelete){
            holder1.mIv.setVisibility(View.VISIBLE);//设置删除按钮是否显示
        }else {
            holder1.mIv.setVisibility(View.GONE);//设置删除按钮是否显示
        }
        if(isSelect){
            for(int i=0;i<mList.size();i++){
                holder1.mIv.setImageResource(R.mipmap.collect_unselectx);
            }
        }else {
            for(int i=0;i<mList.size();i++){
                holder1.mIv.setImageResource(R.mipmap.collect_selectx);
            }
        }

//        holder1.mIv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    for (int i = 0; i < mList.size(); i++) {
//                        if(holder1.mIv.isChecked()){
//                            FavouriteNews favouritNewsListBean = mList.get(position);
//                            mDelete.add(favouritNewsListBean);
//                        }else{
//                            mDelete1.clear();
//                            FavouriteNews favouritNewsListBean = mList.get(position);
//                            mDelete1.add(favouritNewsListBean);
//                            mList.clear();
//                            mList.addAll(mDelete1);
//                        }
//                    }
//                    flag = false;
//                }else{
//                    flag = true;
//                }
//            }
//        });

    }

    public void delect(){
        mList.removeAll(mDelete);
        notifyDataSetChanged();
    }

    public void setIsShowDelete(boolean isShowDelete){
        this.isShowDelete=isShowDelete;
        notifyDataSetChanged();
    }
    public void setisSelect(boolean isset){
        this.isSelect=isset;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTv;
        private ImageView mIv;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.tv);
            mIv = itemView.findViewById(R.id.iv);
        }
    }
    public interface OnItemClickListener{
        void OnItemClick(FavouriteNews favouriteNews,ImageView imageView);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }
    public interface OnItemLongListener{
        void OnItemLong(int position);
    }
    public void setOnItemLongClickLisenter(OnItemLongListener onItemLongClickLisenter){
        mOnItemLongListener = onItemLongClickLisenter;
    }
}
