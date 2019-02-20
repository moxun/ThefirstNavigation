package com.example.administrator.thefirstnavigation.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.adapter.BaseAdapter;
import com.example.administrator.thefirstnavigation.bean.httpbane.SearchBean;

import java.util.List;

/**
 * Created by Administrator on 2019/1/31.
 */

public class TopicSearchAdapter extends BaseAdapter<SearchBean.TagListBean> {

    private final List<SearchBean.TagListBean> mList;
    private final Context context;


    public TopicSearchAdapter(List<SearchBean.TagListBean> dataList, Context context) {
        super(dataList);
        this.mList=dataList;
        this.context=context;

    }

    @Override
    public int getLayoutId() {
        return R.layout.item_hot;
    }

    @Override
    public void addAll(List<SearchBean.TagListBean> list, int page) {
        mList.addAll(list);
        Log.d("moxun", "addAll: "+list.size());
    }

    @Override
    public void createHolder(ViewHolder holder, SearchBean.TagListBean tagListBean, int position) {
        Log.d("lalal","jjjjj");
        TextView hot=holder.itemView.findViewById(R.id.item_hot);
        holder.setText(R.id.item_hot,tagListBean.getTag());
    }
    public static void StringInterceptionChangeRed(TextView numtext, String string, String string2, String string3) {
        int fstart = string.indexOf(string2);
        int fend = fstart + string2.length();
        SpannableStringBuilder style = new SpannableStringBuilder(string);
        if (!"".equals(string3) && string3 != null) {
            int bstart = string.indexOf(string3);
            int bend = bstart + string3.length();
            style.setSpan(new ForegroundColorSpan(Color.RED), bstart, bend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }
        style.setSpan(new ForegroundColorSpan(Color.RED), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        numtext.setText(style);
    }

}
