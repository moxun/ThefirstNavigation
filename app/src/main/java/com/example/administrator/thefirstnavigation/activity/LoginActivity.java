package com.example.administrator.thefirstnavigation.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.activity.SimpleActivity;
import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.example.administrator.thefirstnavigation.units.DaalogHelper;
import com.example.administrator.thefirstnavigation.units.DialogBuilder;
import com.example.administrator.thefirstnavigation.units.dbunits.LoginHelper;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/1/17.
 */

public class LoginActivity extends SimpleActivity {
    @BindView(R.id.image_tool)
    ImageView mImageTool;
    @BindView(R.id.activity_ed_phone)
    EditText mActivityEdPhone;
    @BindView(R.id.activity_ed_code)
    EditText mActivityEdCode;
    @BindView(R.id.activity_te_send)
    TextView mActivityTeSend;
    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.activity_check)
    CheckBox mActivityCheck;
    @BindView(R.id.activity_iv_wechat)
    ImageView mActivityIvWechat;
    @BindView(R.id.activity_iv_qq)
    ImageView mActivityIvQq;
    @BindView(R.id.activity_iv_sina)
    ImageView mActivityIvSina;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorccccc));
        if(LoginHelper.getInstance().queryLikeId()) {
            startActivity(new Intent(LoginActivity.this,InformationActivity.class));
        }
        mIv.setEnabled(false);
        mActivityEdPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                }else{
                    if(mActivityEdPhone.getText().toString().matches(Characterl.phone)){
                        
                    }else{

                        Toast.makeText(LoginActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mActivityEdCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                }else{
                    if(mActivityEdCode.getText().toString().matches(Characterl.code)){

                    }else{
                        Toast.makeText(LoginActivity.this, "请输入六位验证码", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mActivityEdPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(Characterl.code, "onTextChanged: ");
                changImagae();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mActivityEdCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                changImagae();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void changImagae() {
        if(mActivityEdPhone.getText().toString().matches(Characterl.phone)&&mActivityEdCode.getText().toString().matches(Characterl.code)){
            mIv.setImageResource(R.drawable.login);
            mIv.setEnabled(true);
        }else{
            mIv.setImageResource(R.drawable.denglu);
            mIv.setEnabled(false);
        }
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_login;
    }



    @OnClick({R.id.image_tool, R.id.activity_te_send, R.id.iv, R.id.activity_iv_wechat, R.id.activity_iv_qq, R.id.activity_iv_sina})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.image_tool:
                finish();
                break;
            case R.id.activity_te_send:
                setTvMsg();
                break;
            case R.id.iv:
                if(mActivityCheck.isChecked()){
//                    if(LoginHelper.getInstance().queryLikeId(mActivityEdPhone.getText().toString())){
//
//                    }

                        Intent intent = new Intent(this, HeadImageActivity.class);
                        intent.putExtra("phone",mActivityEdPhone.getText().toString());
                        startActivity(intent);

                }else{
                    final DialogBuilder dialogBuilder = new DialogBuilder(this);
                           dialogBuilder.title("警告！")
                            .message("请先阅读用户协议")
                            .sureText("确定")
                            .setSureOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })

                            .build().show();
                }
                break;
            case R.id.activity_iv_wechat:
                break;
            case R.id.activity_iv_qq:
                break;
            case R.id.activity_iv_sina:
                break;
        }

    }
    private void setTvMsg() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(10);
        }
        final String finalResult = result;
        DaalogHelper.showProgressDlg(this,"正在发送验证码");
        //延时一秒给TextView存值
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mActivityEdCode.setText(finalResult);
                DaalogHelper.stopProgressDlg();
            }
        }, 1000);
    }
}
