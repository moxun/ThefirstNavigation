package com.example.administrator.thefirstnavigation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.activity.SimpleActivity;
import com.example.administrator.thefirstnavigation.units.DialogBuilder;
import com.umeng.commonsdk.debug.I;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/2/12.
 */

public class IntroActivity extends SimpleActivity {
    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.edit1)
    TextView mEdit1;
    @BindView(R.id.ok)
    TextView mOk;
    @BindView(R.id.release_edit)
    EditText mReleaseEdit;
    @BindView(R.id.length)
    TextView mLength;
    @BindView(R.id.text)
    TextView mText;

    @Override
    protected void initData() {
        mReleaseEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() <= 30) {

                    mLength.setText(s.length() + "");

                } else {
                    DialogBuilder dialogBuilder = new DialogBuilder(IntroActivity.this);
                    dialogBuilder.title("警告！")
                            .message("字符不能超过30")
                            .sureText("确定")
                            .setSureOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })

                            .build().show();

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_intro;
    }


    @OnClick({R.id.iv, R.id.ok})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv:
                finish();
                break;
            case R.id.ok:
                String result = mReleaseEdit.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("result", result);
                /*
                 * 调用setResult方法表示我将Intent对象返回给之前的那个Activity，这样就可以在onActivityResult方法中得到Intent对象，
                 */
                setResult(1001, intent);
                //    结束当前这个Activity对象的生命
                finish();
                break;
        }
    }
}
