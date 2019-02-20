package com.example.administrator.thefirstnavigation.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.activity.ClassifyActivity;
import com.example.administrator.thefirstnavigation.base.adapter.BaseAdapter;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by Administrator on 2019/1/31.
 */

public class HotAdapter extends BaseAdapter<HotBean.DataBean>{

    public List<HotBean.DataBean> mList;
    private final Context context;
    private  String mString="";
    public HotAdapter(List<HotBean.DataBean> dataList, Context activity) {
        super(dataList);
        this.mList=dataList;
        this.context=activity;

    }

    @Override
    public int getLayoutId() {
        return R.layout.item_hot;
    }
    @Override
    public void addAll(List<HotBean.DataBean> list, int page) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void createHolder(ViewHolder holder, final HotBean.DataBean dataBean, int position) {
        if(mString==null||mString.equals("")){
            holder.setText(R.id.item_hot,dataBean.getTag());
        }else {

            Log.d("moxun", "createHolder: ");
            TextView hot=holder.itemView.findViewById(R.id.item_hot);
            StringInterceptionChangeRed(hot,dataBean.getTag(),mString,mString);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ClassifyActivity.class);
                intent.putExtra("tag",dataBean.getTag());
                intent.putExtra("id",dataBean.getId());
                context.startActivity(intent);
            }
        });

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
    public void getString(String s) {
        this.mString=s;
    }
}
