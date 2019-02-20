package com.example.administrator.thefirstnavigation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.bean.httpbane.FollowBean;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.util.List;


/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：zhangxutong@imcoming.com
 * 时间： 2016/9/12.
 */

public class FullDelDemoAdapter extends RecyclerView.Adapter<FullDelDemoAdapter.FullDelDemoVH> {
    private Context mContext;
    private LayoutInflater mInfalter;
    private List<FollowBean.FollowListBean> mDatas;

    public FullDelDemoAdapter(Context context, List<FollowBean.FollowListBean> mDatas) {
        mContext = context;
        mInfalter = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }

    @Override
    public FullDelDemoVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FullDelDemoVH(mInfalter.inflate(R.layout.item_follow, parent, false));
    }

    @Override
    public void onBindViewHolder(final FullDelDemoVH holder, final int position) {

        FollowBean.FollowListBean followListBean=mDatas.get(position);
        if(followListBean.getNickname()!=null){
            holder.name.setText(followListBean.getNickname());
        }
        if(followListBean.getFollowTime()!=null){
            holder.time.setText(followListBean.getFollowTime());
        }
        if(followListBean.getPersonalProfile()!=null&&!followListBean.getPersonalProfile().equals("")){
            holder.title.setText(followListBean.getPersonalProfile());
        }

        if(!followListBean.getHeadImagePath().equals("http://39.107.254.232/firstga/imagesnull")){
            RequestOptions requestOptions1 = RequestOptions.circleCropTransform();
            Glide.with(mContext).load(followListBean.getHeadImagePath()).apply(requestOptions1).into(holder.head);
        }

        //验证长按
        holder.name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "longclig", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onLongClick() called with: v = [" + v + "]");
                return false;
            }
        });



        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnSwipeListener) {
                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
                    //((CstSwipeDelMenu) holder.itemView).quickClose();
                    mOnSwipeListener.onDel(holder.getAdapterPosition());
                }
            }
        });
        //注意事项，设置item点击，不能对整个holder.itemView设置咯，只能对第一个子View，即原来的content设置，这算是局限性吧。
//        (holder.name).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "onClick:" + mDatas.get(holder.getAdapterPosition()).name, Toast.LENGTH_SHORT).show();
//                Log.d("TAG", "onClick() called with: v = [" + v + "]");
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return null != mDatas ? mDatas.size() : 0;
    }

    /**
     * 和Activity通信的接口
     */
    public interface onSwipeListener {
        void onDel(int pos);

        void onTop(int pos);
    }

    private onSwipeListener mOnSwipeListener;

    public onSwipeListener getOnDelListener() {
        return mOnSwipeListener;
    }

    public void setOnDelListener(onSwipeListener mOnDelListener) {
        this.mOnSwipeListener = mOnDelListener;
    }

    class FullDelDemoVH extends RecyclerView.ViewHolder {
        TextView name;
        Button btnDelete;
        TextView title;
        TextView time;
        ImageView head;

        public FullDelDemoVH(View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.item_name);
            btnDelete =  itemView.findViewById(R.id.btnDelete);
            time=itemView.findViewById(R.id.item_time);
            title=itemView.findViewById(R.id.item_title);
            head=itemView.findViewById(R.id.image_head);


        }
    }
}

