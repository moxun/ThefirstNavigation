package com.example.administrator.thefirstnavigation.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.thefirstnavigation.MainActivity;
import com.example.administrator.thefirstnavigation.MvpInterface.MineTopicMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.TopicInFoMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.MineTopicAdapter;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.base.activity.SimpleActivity;
import com.example.administrator.thefirstnavigation.bean.httpbane.MineTopicBean;
import com.example.administrator.thefirstnavigation.presenter.MineTopicPresenter;
import com.example.administrator.thefirstnavigation.presenter.TopicInfoPresenter;
import com.example.administrator.thefirstnavigation.units.manager.IDialog;
import com.example.administrator.thefirstnavigation.units.manager.SYDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/2/15.
 */

public class MineTopicActivity extends BaseActicity<MineTopicMvp.MineTopicView, MineTopicPresenter<MineTopicMvp.MineTopicView>> implements MineTopicMvp.MineTopicView {
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.topic_ll)
    LinearLayout mTopicLl;
    @BindView(R.id.recy_topic)
    RecyclerView mRecyTopic;
    private MineTopicAdapter mMineTopicAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
        setToolBar(mToolBar,"我的话题");
        mPresentser.getMineTopic("0");
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_minetopic;
    }



    @OnClick(R.id.topic_ll)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.topic_ll:
                startActivity(new Intent(this, InsertTopicAvtivity.class));
                break;
        }
    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showMineTopic(final MineTopicBean topicBean) {
        Log.d("moxun", "showMineTopic: "+topicBean.getFavouritTopicList().size());
        mMineTopicAdapter = new MineTopicAdapter(topicBean.getFavouritTopicList(), this);
        mRecyTopic.setLayoutManager(new LinearLayoutManager(this));
        mRecyTopic.setAdapter(mMineTopicAdapter);
        mMineTopicAdapter.OnsetOnClickListener(new MineTopicAdapter.setOnClickListener() {
            @Override
            public void setOnClickListener(MineTopicBean.FavouritTopicListBean favouritTopicListBean) {
                showPop(topicBean);
            }
        });
    }

    private void showPop(MineTopicBean topicBean) {
        new SYDialog.Builder(this)
                .setDialogView(R.layout.layout_bottom_up)
                .setWindowBackgroundP(0.5f)
                .setAnimStyle(R.style.AnimUp)
                .setCancelableOutSide(true)
                .setCancelableOutSide(true)
                .setBuildChildListener(new IDialog.OnBuildListener() {
                    @Override
                    public void onBuildChildView(final IDialog dialog, View view, int layoutRes) {
                        Button btn_take_photo = view.findViewById(R.id.btn_take_photo);
                        btn_take_photo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                dialog.dismiss();
                            }
                        });

                        Button btn_select_photo = view.findViewById(R.id.btn_select_photo);
                        btn_select_photo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                dialog.dismiss();
                            }
                        });

                        Button btn_cancel_dialog = view.findViewById(R.id.btn_cancel_dialog);
                        btn_cancel_dialog.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setScreenWidthP(1.0f)
                .setGravity(Gravity.BOTTOM).show();
    }

    @Override
    protected MineTopicPresenter<MineTopicMvp.MineTopicView> createPresenter() {
        return new MineTopicPresenter<>();
    }
}
