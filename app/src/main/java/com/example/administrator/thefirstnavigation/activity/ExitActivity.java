package com.example.administrator.thefirstnavigation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.activity.SimpleActivity;
import com.example.administrator.thefirstnavigation.units.dbunits.LoginHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/2/11.
 */

public class ExitActivity extends SimpleActivity {
    @BindView(R.id.img_finsh)
    ImageView mImgFinsh;
    @BindView(R.id.img_xiao)
    ImageView mImgXiao;
    @BindView(R.id.tv_qing)
    TextView mTvQing;
    @BindView(R.id.img_xiao2)
    ImageView mImgXiao2;
    @BindView(R.id.qingchuhuanc)
    RelativeLayout mQingchuhuanc;
    @BindView(R.id.img_xiao3)
    ImageView mImgXiao3;
    @BindView(R.id.img_switch)
    SwitchCompat mImgSwitch;
    @BindView(R.id.img_xiao4)
    ImageView mImgXiao4;
    @BindView(R.id.btu_tui)
    Button mBtuTui;

    @Override
    protected void initData() {


    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_exit;
    }



    @OnClick({R.id.img_finsh, R.id.img_xiao, R.id.btu_tui})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img_finsh:
                finish();
                break;
            case R.id.img_xiao:
                break;
            case R.id.btu_tui:
                LoginHelper.getInstance().deleteAll();
                startActivity(new Intent(this,LoginActivity.class));
                break;
        }
    }
}
