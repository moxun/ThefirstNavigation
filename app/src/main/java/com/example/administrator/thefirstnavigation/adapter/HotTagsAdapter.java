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

public class HotTagsAdapter extends BaseAdapter<HotBean.DataBean> {
    public List<HotBean.DataBean> mList;
    private setOnClickListener mSetOnClickListener1;
    private boolean mBoolean = true;

    public HotTagsAdapter(List<HotBean.DataBean> dataList) {
        super(dataList);
        this.mList = dataList;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_hottopic;
    }

    @Override
    public void addAll(List<HotBean.DataBean> list, int page) {

    }

    @Override
    public void createHolder(ViewHolder holder, final HotBean.DataBean dataBean, int position) {
        holder.setText(R.id.tag_lv_title, dataBean.getTag());
        final ImageView viewById = holder.itemView.findViewById(R.id.tag_lv_img);
        if(!dataBean.isSelect()){
            viewById.setImageResource(R.mipmap.topic_tag_unselectx);
        }else{
            viewById.setImageResource(R.mipmap.topic_tag_selectx);
        }
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetOnClickListener1.setOnClickListener(viewById, dataBean, mBoolean);
            }
        });

    }
    public interface setOnClickListener {
        void setOnClickListener(ImageView imageView, HotBean.DataBean hotBean, boolean isSelect);

    }

    public void OnsetOnClickListener(setOnClickListener setOnClickListener) {
        mSetOnClickListener1 = setOnClickListener;
    }
}
