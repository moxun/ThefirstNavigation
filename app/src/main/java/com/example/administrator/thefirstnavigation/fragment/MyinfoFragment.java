package com.example.administrator.thefirstnavigation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.thefirstnavigation.MvpInterface.UserInfoMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.activity.CommentActivity;
import com.example.administrator.thefirstnavigation.activity.ExitActivity;
import com.example.administrator.thefirstnavigation.activity.FavouriteActivity;
import com.example.administrator.thefirstnavigation.activity.FollowActivity;
import com.example.administrator.thefirstnavigation.activity.ListNotifyActivity;
import com.example.administrator.thefirstnavigation.activity.MineTopicActivity;
import com.example.administrator.thefirstnavigation.activity.UpdateInfoActivity;
import com.example.administrator.thefirstnavigation.base.fragment.BaseFragment;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserCenterBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserInfoBean;
import com.example.administrator.thefirstnavigation.presenter.UserInfoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/1/19.
 */

public class MyinfoFragment extends BaseFragment<UserInfoMvp.UserInfoView, UserInfoPresenter<UserInfoMvp.UserInfoView>> implements UserInfoMvp.UserInfoView, UpdateInfoActivity.OnItemClick {
    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.edit)
    TextView mEdit;
    @BindView(R.id.collect)
    TextView mCollect;
    @BindView(R.id.sc)
    LinearLayout mSc;
    @BindView(R.id.history)
    TextView mHistory;
    @BindView(R.id.ls)
    LinearLayout mLs;
    @BindView(R.id.imported)
    TextView mImported;
    @BindView(R.id.gz)
    LinearLayout mGz;
    @BindView(R.id.discuss)
    TextView mDiscuss;
    @BindView(R.id.pl)
    LinearLayout mPl;
    @BindView(R.id.message)
    TextView mMessage;

    @BindView(R.id.open)
    ImageView mOpen;
    @BindView(R.id.inform)
    LinearLayout mInform;
    @BindView(R.id.my_topic)
    TextView mMyTopic;
    @BindView(R.id.open1)
    ImageView mOpen1;
    @BindView(R.id.feedback)
    TextView mFeedback;
    @BindView(R.id.open3)
    ImageView mOpen3;
    @BindView(R.id.set)
    TextView mSet;
    @BindView(R.id.open4)
    ImageView mOpen4;
    @BindView(R.id.ll_set)
    LinearLayout mLlSet;
    @BindView(R.id.ll_favourite)
    LinearLayout mLlFavourite;
    @BindView(R.id.follow)
    LinearLayout mFollow;
    @BindView(R.id.ll_comment)
    LinearLayout mLlComment;
    @BindView(R.id.ma_topic)
    LinearLayout mMaTopic;
    private View view;
    private Unbinder unbinder;
    private String mHeadImagePath;
    private String mNickname;

    @Override
    public int createLayoutId() {
        return R.layout.myinfofragment;
    }

    @Override
    protected void initData() {
        presenter.getUserInfo();
        UpdateInfoActivity.setOnItemClick(this);
    }


    @Override
    public void hideProgressbar() {

    }


    @Override
    protected UserInfoPresenter<UserInfoMvp.UserInfoView> createPresenter() {
        return new UserInfoPresenter<>();
    }

    @Override
    public void showHot(UserCenterBean hotBean) {
        Log.d("moxun", hotBean.getNickname());
        RequestOptions options = new RequestOptions().circleCrop();
        mHeadImagePath = hotBean.getHeadImagePath();
        mNickname = hotBean.getNickname();
        Glide.with(getContext()).load(hotBean.getHeadImagePath()).apply(options).into(mIv);

        mName.setText(hotBean.getNickname());
        mCollect.setText(hotBean.getFavorites() + "");
        mHistory.setText(hotBean.getHistoryReads() + "");
        mImported.setText(hotBean.getFollowing() + "");
        mDiscuss.setText(hotBean.getComments() + "");
    }

    @Override
    public void showUpdateInfo() {

    }

    @Override
    public void showUserInfo(UserInfoBean userInfoBean) {

    }

    @Override
    public void showUploadHead(UploadHeadImageBean uploadHeadImageBean) {

    }


    @OnClick({R.id.edit, R.id.ll_set, R.id.ll_favourite, R.id.follow, R.id.ll_comment, R.id.inform, R.id.ma_topic})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.edit:
                startActivity(new Intent(mActivity, UpdateInfoActivity.class));
                break;
            case R.id.ll_set:
                startActivity(new Intent(mActivity, ExitActivity.class));
                break;
            case R.id.ll_favourite:
                startActivity(new Intent(mActivity, FavouriteActivity.class));
                break;
            case R.id.follow:
                startActivity(new Intent(mActivity, FollowActivity.class));
                break;
            case R.id.ll_comment:
                Intent intent = new Intent(mActivity, CommentActivity.class);
                intent.putExtra("head", mHeadImagePath);
                intent.putExtra("name", mNickname);
                startActivity(intent);
                break;
            case R.id.inform:
                startActivity(new Intent(mActivity, ListNotifyActivity.class));
                break;
            case R.id.ma_topic:
                startActivity(new Intent(mActivity, MineTopicActivity.class));
                break;
        }
    }


    @Override
    public void onItem() {
        presenter.getUserInfo();
    }



}
