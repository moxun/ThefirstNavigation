package com.example.administrator.thefirstnavigation.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.thefirstnavigation.MvpInterface.TopicInFoMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.TopicListCommentAdapter;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.bean.httpbane.Follow;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListCommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicInfoBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.Comment;
import com.example.administrator.thefirstnavigation.bean.jsonbean.LikeBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.ListComment;
import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.example.administrator.thefirstnavigation.presenter.TopicInfoPresenter;
import com.example.administrator.thefirstnavigation.units.DialogBuilder;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/1/29.
 */

public class TopicAvtivity extends BaseActicity<TopicInFoMvp.TopicInFoView, TopicInfoPresenter<TopicInFoMvp.TopicInFoView>> implements TopicInFoMvp.TopicInFoView {

    @BindView(R.id.topicDetail_headImage)
    ImageView mTopicDetailHeadImage;
    @BindView(R.id.topicDetail_name)
    TextView mTopicDetailName;
    @BindView(R.id.topicDetail_time)
    TextView mTopicDetailTime;
    @BindView(R.id.topicDetail_follow)
    Button mTopicDetailFollow;
    @BindView(R.id.topicDetail_title)
    TextView mTopicDetailTitle;
    @BindView(R.id.topicDetail_image1)
    ImageView mTopicDetailImage1;
    @BindView(R.id.topicDetail_image2)
    ImageView mTopicDetailImage2;
    @BindView(R.id.topicDetail_image3)
    ImageView mTopicDetailImage3;
    @BindView(R.id.topicDetail_image4)
    ImageView mTopicDetailImage4;
    @BindView(R.id.topicDetail_image5)
    ImageView mTopicDetailImage5;
    @BindView(R.id.topicDetail_image6)
    ImageView mTopicDetailImage6;
    @BindView(R.id.topicDetail_image7)
    ImageView mTopicDetailImage7;
    @BindView(R.id.topicDetail_image8)
    ImageView mTopicDetailImage8;
    @BindView(R.id.topicDetail_image9)
    ImageView mTopicDetailImage9;

    @BindView(R.id.topicDetail_dianZanText)
    TextView mTopicDetailDianZanText;
    @BindView(R.id.topicDetail_commentLength)
    TextView mTopicDetailCommentLength;
    @BindView(R.id.topicDetail_reList)
    RecyclerView mTopicDetailReList;
    @BindView(R.id.topicDetail_dianZan)
    ImageView mTopicDetailDianZan;
    @BindView(R.id.pinglun)
    ImageView mPinglun;

    private String mId;
    private int mIsLiked;
    private int mLikes;
    private TopicListCommentAdapter mTopicListCommentAdapter;
    private int mComments;
    private String mFollowid;
    private int mIsFollowed;
    private String mUserId;
    private int isSucces = 0;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mId = intent.getStringExtra("id");
        mFollowid = intent.getStringExtra("followid");
        Log.d("moxun", "initData: " + mId);
        ListComment listComment = new ListComment(mId, "1", "0");
        Gson gson = new Gson();
        String json = gson.toJson(listComment);
        List<ListCommentBean.CommentListBean> listBeans = new ArrayList<>();
        mTopicDetailReList.setLayoutManager(new LinearLayoutManager(this));
        mTopicListCommentAdapter = new TopicListCommentAdapter(listBeans, this);
        mTopicDetailReList.setAdapter(mTopicListCommentAdapter);
        mPresentser.getTopicInfo(mId);
        mPresentser.getListComment(json);
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_topic_detail;
    }

    @Override
    public void hideProgressbar() {

    }


    @Override
    protected TopicInfoPresenter<TopicInFoMvp.TopicInFoView> createPresenter() {
        return new TopicInfoPresenter<>();
    }

    @Override
    public void showTopicInFo(final TopicInfoBean uploadHeadImageBean) {
        Log.d("moxun", "showTopicInFo: " + uploadHeadImageBean.getHeadImagePath());
        RequestOptions requestOptions1 = RequestOptions.circleCropTransform();
        Glide.with(this).load(uploadHeadImageBean.getHeadImagePath()).apply(requestOptions1).into(mTopicDetailHeadImage);
        mTopicDetailName.setText(uploadHeadImageBean.getNickname());
        mTopicDetailTime.setText(uploadHeadImageBean.getPublishTime());
        mTopicDetailTitle.setText(uploadHeadImageBean.getTitle());
        List<String> imageListThumb = uploadHeadImageBean.getImageListThumb();
        if (imageListThumb.size() == 1) {
            Glide.with(this).load(imageListThumb.get(0)).into(mTopicDetailImage5);
        } else if (imageListThumb.size() == 2) {
            Glide.with(this).load(imageListThumb.get(0)).into(mTopicDetailImage1);
            Glide.with(this).load(imageListThumb.get(1)).into(mTopicDetailImage2);
        } else if (imageListThumb.size() == 3) {
            Glide.with(this).load(imageListThumb.get(0)).into(mTopicDetailImage1);
            Glide.with(this).load(imageListThumb.get(1)).into(mTopicDetailImage2);
            Glide.with(this).load(imageListThumb.get(2)).into(mTopicDetailImage3);
        } else if (imageListThumb.size() == 4) {
            Glide.with(this).load(imageListThumb.get(0)).into(mTopicDetailImage1);
            Glide.with(this).load(imageListThumb.get(1)).into(mTopicDetailImage2);
            Glide.with(this).load(imageListThumb.get(2)).into(mTopicDetailImage3);
            Glide.with(this).load(imageListThumb.get(3)).into(mTopicDetailImage4);
        } else if (imageListThumb.size() == 5) {
            Glide.with(this).load(imageListThumb.get(0)).into(mTopicDetailImage1);
            Glide.with(this).load(imageListThumb.get(1)).into(mTopicDetailImage2);
            Glide.with(this).load(imageListThumb.get(2)).into(mTopicDetailImage3);
            Glide.with(this).load(imageListThumb.get(3)).into(mTopicDetailImage4);
            Glide.with(this).load(imageListThumb.get(4)).into(mTopicDetailImage5);
        } else if (imageListThumb.size() == 6) {
            Glide.with(this).load(imageListThumb.get(0)).into(mTopicDetailImage1);
            Glide.with(this).load(imageListThumb.get(1)).into(mTopicDetailImage2);
            Glide.with(this).load(imageListThumb.get(2)).into(mTopicDetailImage3);
            Glide.with(this).load(imageListThumb.get(3)).into(mTopicDetailImage4);
            Glide.with(this).load(imageListThumb.get(4)).into(mTopicDetailImage5);
            Glide.with(this).load(imageListThumb.get(5)).into(mTopicDetailImage6);
        } else if (imageListThumb.size() == 7) {
            Glide.with(this).load(imageListThumb.get(0)).into(mTopicDetailImage1);
            Glide.with(this).load(imageListThumb.get(1)).into(mTopicDetailImage2);
            Glide.with(this).load(imageListThumb.get(2)).into(mTopicDetailImage3);
            Glide.with(this).load(imageListThumb.get(3)).into(mTopicDetailImage4);
            Glide.with(this).load(imageListThumb.get(4)).into(mTopicDetailImage5);
            Glide.with(this).load(imageListThumb.get(5)).into(mTopicDetailImage6);
            Glide.with(this).load(imageListThumb.get(6)).into(mTopicDetailImage7);
        } else if (imageListThumb.size() == 8) {
            Glide.with(this).load(imageListThumb.get(0)).into(mTopicDetailImage1);
            Glide.with(this).load(imageListThumb.get(1)).into(mTopicDetailImage2);
            Glide.with(this).load(imageListThumb.get(2)).into(mTopicDetailImage3);
            Glide.with(this).load(imageListThumb.get(3)).into(mTopicDetailImage4);
            Glide.with(this).load(imageListThumb.get(4)).into(mTopicDetailImage5);
            Glide.with(this).load(imageListThumb.get(5)).into(mTopicDetailImage6);
            Glide.with(this).load(imageListThumb.get(6)).into(mTopicDetailImage7);
            Glide.with(this).load(imageListThumb.get(7)).into(mTopicDetailImage8);
        } else if (imageListThumb.size() >= 9) {
            Glide.with(this).load(imageListThumb.get(0)).into(mTopicDetailImage1);
            Glide.with(this).load(imageListThumb.get(1)).into(mTopicDetailImage2);
            Glide.with(this).load(imageListThumb.get(2)).into(mTopicDetailImage3);
            Glide.with(this).load(imageListThumb.get(3)).into(mTopicDetailImage4);
            Glide.with(this).load(imageListThumb.get(4)).into(mTopicDetailImage5);
            Glide.with(this).load(imageListThumb.get(5)).into(mTopicDetailImage6);
            Glide.with(this).load(imageListThumb.get(6)).into(mTopicDetailImage7);
            Glide.with(this).load(imageListThumb.get(7)).into(mTopicDetailImage8);
            Glide.with(this).load(imageListThumb.get(8)).into(mTopicDetailImage9);

        } else {
            mTopicDetailImage5.setImageResource(R.drawable.psb);
        }
        mIsLiked = uploadHeadImageBean.getIsLiked();


        if (mIsLiked == 0) {
//
            mTopicDetailDianZan.setImageResource(R.drawable.topic_praise);
        } else {
            mTopicDetailDianZan.setImageResource(R.drawable.topic_praise_high);
        }
        mLikes = uploadHeadImageBean.getLikes();
        mTopicDetailDianZanText.setText(mLikes + "");
        mComments = uploadHeadImageBean.getComments();

        mTopicDetailCommentLength.setText(mComments + "");
        mIsFollowed = uploadHeadImageBean.getIsFollowed();
        mUserId = uploadHeadImageBean.getUserId();

        if (mIsFollowed == 0) {
            mTopicDetailFollow.setText("关注");
        } else {
            mTopicDetailFollow.setText("取消关注");
        }
    }


    @Override
    public void showListComment(ListCommentBean listCommentBean) {
        Log.d("moxun", "showListComment: " + listCommentBean.getCommentList().size());
        mTopicListCommentAdapter.add(listCommentBean.getCommentList());
    }

    @Override
    public void showLike() {
        Log.d("moxun", "showLike: " + 222);
    }

    @Override
    public void showFavourite() {

    }

    @Override
    public void showFollow() {
        Log.d("moxun", "showFollow: ");
        isSucces = 1;
    }

    @Override
    public void showDiscuss() {
        Log.d("moxun", "showDiscuss: ");
        mTopicListCommentAdapter.mList.clear();
        ListComment listComment = new ListComment(mId, "1", "0");
        Gson gson = new Gson();
        String json = gson.toJson(listComment);
        mPresentser.getListComment(json);
    }


    @OnClick({R.id.topicDetail_dianZan, R.id.topicDetail_follow, R.id.pinglun})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.topicDetail_dianZan:
                if (mIsLiked == 0) {
                    LikeBean likeBean = new LikeBean(Characterl.newsid, mId, "1", "0");
                    Gson gson = new Gson();
                    String json = gson.toJson(likeBean);
                    mPresentser.getLike(json);
                    mIsLiked = 1;
                    mTopicDetailDianZan.setImageResource(R.drawable.topic_praise_high);
                    mLikes = mLikes + 1;
                    mTopicDetailDianZanText.setText(mLikes + "");
                } else {
                    LikeBean likeBean = new LikeBean(Characterl.newsid, mId, "1", "1");
                    Gson gson = new Gson();
                    String json = gson.toJson(likeBean);
                    mPresentser.getLike(json);
                    mIsLiked = 0;
                    mTopicDetailDianZan.setImageResource(R.drawable.topic_praise);
                    mLikes = mLikes - 1;
                    mTopicDetailDianZanText.setText(mLikes + "");
                }
                break;
            case R.id.topicDetail_follow:
                if (mIsFollowed == 0 && isSucces == 1) {
                    Log.d("moxun", "onClick: " + mUserId);
                    Follow follow = new Follow(Characterl.newsid, mUserId, "0");
                    Gson gson = new Gson();
                    String json = gson.toJson(follow);
                    mPresentser.getFlollow(json);
                    mTopicDetailFollow.setText("取消关注");
                    mIsFollowed = 1;
                } else {
                    Follow follow = new Follow(Characterl.newsid, mUserId, "1");
                    Gson gson = new Gson();
                    String json = gson.toJson(follow);
                    mPresentser.getFlollow(json);
                    mTopicDetailFollow.setText("关注");
                    mIsFollowed = 0;
                }
                break;
            case R.id.pinglun:
                showPop();
                break;
        }
    }

    @SuppressLint("WrongConstant")
    private void showPop() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.commentpop, null);
        TextView faBu = inflate.findViewById(R.id.fabu);
        final EditText neiRong = inflate.findViewById(R.id.neiRong);
        final TextView length = inflate.findViewById(R.id.length);
        final PopupWindow pop = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        pop.showAsDropDown(faBu, 0, 0);
        pop.setFocusable(true);
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        final InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE); //这里给它设置了弹出的时间，
        imm.toggleSoftInput(1000, InputMethodManager.HIDE_NOT_ALWAYS);
        TextView quXiao = inflate.findViewById(R.id.quXiao);
        neiRong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TopicAvtivity.this, "11111", Toast.LENGTH_SHORT).show();
                pop.dismiss();
            }
        });
        quXiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                imm.hideSoftInputFromWindow(neiRong.getWindowToken(), 0);
            }
        });
        neiRong.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 150) {
                    length.setText(s.length() + "");
                } else {
                    DialogBuilder dialogBuilder = new DialogBuilder(TopicAvtivity.this);
                    dialogBuilder.title("警告！")
                            .message("字符不能超过150")
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
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                imm.hideSoftInputFromWindow(neiRong.getWindowToken(), 0);
            }
        });
        faBu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comment comment = new Comment(Characterl.newsid, mId, "0", neiRong.getText().toString());
                Gson gson = new Gson();
                String json = gson.toJson(comment);
                mPresentser.getDiscuss(json);
                imm.hideSoftInputFromWindow(neiRong.getWindowToken(), 0);
                pop.dismiss();
            }
        });

    }


}
