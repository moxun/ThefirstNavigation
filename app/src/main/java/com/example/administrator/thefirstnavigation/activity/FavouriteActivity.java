package com.example.administrator.thefirstnavigation.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.MvpInterface.FavouriteNewsMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.CollectAdapter;
import com.example.administrator.thefirstnavigation.adapter.TopicLoveAdapter;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteNews;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteTopicBean;
import com.example.administrator.thefirstnavigation.presenter.FavouriteNewsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/2/12.
 */

public class FavouriteActivity extends BaseActicity<FavouriteNewsMvp.FavouriteNewsView, FavouriteNewsPresenter<FavouriteNewsMvp.FavouriteNewsView>> implements FavouriteNewsMvp.FavouriteNewsView {
    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.button_fr)
    ImageView mButtonFr;
    @BindView(R.id.cancel)
    TextView mCancel;
    @BindView(R.id.ll)
    LinearLayout mLl;
    @BindView(R.id.recy_far)
    RecyclerView mRecyFar;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.delect)
    LinearLayout mDelect;
    @BindView(R.id.recy_topic)
    RecyclerView mRecyTopic;
    private CollectAdapter mCollectAdapter;
    private boolean flag = true;
    private boolean isNews = true;
    private int count = 0;
    private ArrayList<FavouriteNews> mFavouriteNews = new ArrayList<>();
    private TopicLoveAdapter mTopicLoveAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.red));
        mPresentser.getFavouriteNews("0");
        mPresentser.getFavouriteTopic("0");
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_favourite;
    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showFavouriteNews(FavouriteNewsBean favouriteNewsBean) {
        Log.d("moxun", "showFavouriteNews: " + favouriteNewsBean.getFavouritNewsList().size());
        List<FavouriteNews> newsList = new ArrayList<FavouriteNews>();
        for (int i = 0; i < favouriteNewsBean.getFavouritNewsList().size(); i++) {
            FavouriteNewsBean.FavouritNewsListBean favouritNewsListBean = favouriteNewsBean.getFavouritNewsList().get(i);

            FavouriteNews favouriteNews = new FavouriteNews(favouritNewsListBean.getFavouritId(), favouritNewsListBean.getNewsId(), favouritNewsListBean.getTitle(), true);
            newsList.add(favouriteNews);
        }
        mRecyFar.setLayoutManager(new LinearLayoutManager(this));
        mCollectAdapter = new CollectAdapter(newsList, this);
        mRecyFar.setAdapter(mCollectAdapter);
        mCollectAdapter.setOnItemClickListener(new CollectAdapter.OnItemClickListener() {

            private boolean mSelect;

            @Override
            public void OnItemClick(FavouriteNews favouriteNews, ImageView imageView) {
                mSelect = favouriteNews.isSelect();
                if (mSelect) {
                    imageView.setImageResource(R.mipmap.collect_selectx);
                    favouriteNews.setSelect(false);
                    count++;
                    mTv.setText("删除(" + count + ")");
                    mFavouriteNews.add(favouriteNews);
                } else {
                    imageView.setImageResource(R.mipmap.collect_unselectx);
                    favouriteNews.setSelect(true);
                    count--;
                    mTv.setText("删除(" + count + ")");
                    mFavouriteNews.remove(favouriteNews);
                }

            }
        });
    }

    @Override
    public void showFavouriteTopic(FavouriteTopicBean favouriteTopicBean) {
        Log.d("moxun", "showFavouriteTopic: "+favouriteTopicBean.getFavouritTopicList().size());
        mTopicLoveAdapter = new TopicLoveAdapter(favouriteTopicBean.getFavouritTopicList(), this);
        mRecyTopic.setLayoutManager(new LinearLayoutManager(this));
        mRecyTopic.setAdapter(mTopicLoveAdapter);
    }

    @Override
    protected FavouriteNewsPresenter<FavouriteNewsMvp.FavouriteNewsView> createPresenter() {
        return new FavouriteNewsPresenter<>();
    }


    @OnClick({R.id.iv, R.id.button_fr, R.id.cancel, R.id.delect, R.id.recy_topic})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv:
                finish();
                break;
            case R.id.button_fr:

                if (isNews) {
                    mRecyFar.setVisibility(View.GONE);
                    mRecyTopic.setVisibility(View.VISIBLE);
                    mButtonFr.setImageResource(R.mipmap.wenzhang);
                    mCancel.setVisibility(View.GONE);
                    mDelect.setVisibility(View.GONE);
                    isNews=false;
                } else {
                    mRecyFar.setVisibility(View.VISIBLE);
                    mRecyTopic.setVisibility(View.GONE);
                    mButtonFr.setImageResource(R.mipmap.topic);
                    mCancel.setVisibility(View.VISIBLE);
                    mDelect.setVisibility(View.VISIBLE);
                    isNews=true;
                }
                break;
            case R.id.cancel:
                if (flag) {
                    mCollectAdapter.setIsShowDelete(true);
                    mCancel.setText("取消");

                    flag = false;
                } else {
                    mCollectAdapter.setIsShowDelete(false);
                    mCancel.setText("编辑");
                    mTv.setText("删除(" + 0 + ")");
                    if(mFavouriteNews.size()!=0){
                        for(int i=0;i<mFavouriteNews.size();i++){
                            mFavouriteNews.get(i).setSelect(true);
                        }
                    }
                    count=0;
                    flag = true;
                }
                mCollectAdapter.notifyDataSetChanged();
                break;
            case R.id.delect:
                showDialo();
                break;
            case R.id.recy_topic:
                break;
        }
    }

    private void showDialo() {
        View inflate = LayoutInflater.from(FavouriteActivity.this).inflate(R.layout.popdelete, null);

        TextView textView = inflate.findViewById(R.id.dialog_title);
        TextView name = inflate.findViewById(R.id.dialog_content);
        final PopupWindow popupWin = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWin.showAsDropDown(textView, 0, 0);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                popupWin.dismiss();
            }
        });


        Button canleButton = inflate.findViewById(R.id.dialog_btn_cancel);

        final Button sureButton = inflate.findViewById(R.id.dialog_btn_sure);

        sureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mFavouriteNews.size(); i++) {
                    mCollectAdapter.mList.remove(mFavouriteNews.get(i));
                    Log.d("lalalal", mFavouriteNews.get(i).getFavouritId());
                }
                mFavouriteNews.clear();
                for (int i = 0; i <mCollectAdapter.mList.size() ; i++) {
                    Log.d("======================", "onClick: "+i);
                    mCollectAdapter.mList.get(i).setSelect(true);
                }
                mCollectAdapter.setIsShowDelete(true);
                mCollectAdapter.notifyDataSetChanged();
                popupWin.dismiss();
            }
        });
        canleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupWin.dismiss();
            }
        });
    }


}
