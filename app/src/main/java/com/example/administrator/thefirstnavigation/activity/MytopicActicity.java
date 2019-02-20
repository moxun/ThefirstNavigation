package com.example.administrator.thefirstnavigation.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.MvpInterface.MyTopicMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.HotTagsAdapter;
import com.example.administrator.thefirstnavigation.adapter.MyTopicAdapter;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.presenter.MyTopicPresenter;
import com.example.administrator.thefirstnavigation.units.DialogBuilder;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Administrator on 2019/2/1.
 */

public class MytopicActicity extends BaseActicity<MyTopicMvp.MyTopicView, MyTopicPresenter<MyTopicMvp.MyTopicView>> implements MyTopicMvp.MyTopicView {
    @BindView(R.id.about_toolbar)
    Toolbar mAboutToolbar;
    @BindView(R.id.about_appbar)
    AppBarLayout mAboutAppbar;
    @BindView(R.id.tag_defined)
    TextView mTagDefined;
    @BindView(R.id.tag_relative1)
    RelativeLayout mTagRelative1;
    @BindView(R.id.tag_se)
    TextView mTagSe;
    @BindView(R.id.tag_v1)
    View mTagV1;
    @BindView(R.id.tag_select)
    TextView mTagSelect;
    @BindView(R.id.tag_xuan)
    RecyclerView mTagXuan;
    @BindView(R.id.tag_relative2)
    RelativeLayout mTagRelative2;
    @BindView(R.id.tag_hot)
    TextView mTagHot;
    @BindView(R.id.tag_lv)
    RecyclerView mTagLv;
    @BindView(R.id.add_topic)
    ImageView mAddTopic;
    @BindView(R.id.editText)
    EditText mEditText;
    @BindView(R.id.topic_ok)
    TextView mTopicOk;
    @BindView(R.id.okk)
    TextView mOkk;
    private HotTagsAdapter mHotTagsAdapter;
    private boolean mIsselecter;
    List<HotBean.DataBean> mDataBeans = new ArrayList<>();
    private MyTopicAdapter mMyTopicAdapter;
    private ImageView mImageView1;

    @Override
    protected void initData() {

        mTagXuan.setLayoutManager(new LinearLayoutManager(this));
        mMyTopicAdapter = new MyTopicAdapter(mDataBeans);
        mTagXuan.setAdapter(mMyTopicAdapter);
        mMyTopicAdapter.OnsetOnClickListener(new MyTopicAdapter.setOnClickListener() {
            @Override
            public void setOnClickListener(HotBean.DataBean hotBean) {
                mMyTopicAdapter.mList.remove(hotBean);
                mMyTopicAdapter.notifyDataSetChanged();
//                for (int i = 0; i <mHotTagsAdapter.mList.size() ; i++) {
//                    if (mHotTagsAdapter.mList.get(i).equals(hotBean)) {
//                        mHotTagsAdapter.mList.get(i).setSelect(false);
//                    }
//                }
                hotBean.setSelect(false);
                mHotTagsAdapter.notifyDataSetChanged();

                if (mMyTopicAdapter.mList.size() > 0) {
                    mTagXuan.setVisibility(View.VISIBLE);
                    mTagSelect.setVisibility(View.GONE);
                } else {
                    mTagXuan.setVisibility(View.GONE);
                    mTagSelect.setVisibility(View.VISIBLE);
                }
            }
        });
        mPresentser.getHot();
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_mytopic;
    }


    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showHot(HotBean hotBean) {
        Log.d("moxun", "showHot: " + hotBean.getData().size());
        mTagLv.setLayoutManager(new LinearLayoutManager(this));
        mHotTagsAdapter = new HotTagsAdapter(hotBean.getData());
        mTagLv.setAdapter(mHotTagsAdapter);

        mHotTagsAdapter.OnsetOnClickListener(new HotTagsAdapter.setOnClickListener() {
            @Override
            public void setOnClickListener(ImageView imageView, HotBean.DataBean hotBean, boolean isSelect) {

                    mIsselecter=hotBean.isSelect();
                    if(mIsselecter){
                        mImageView1 = imageView;
                        imageView.setImageResource(R.mipmap.topic_tag_unselectx);
                        mMyTopicAdapter.mList.remove(hotBean);
                        mMyTopicAdapter.notifyDataSetChanged();
                        hotBean.setSelect(false);
                    }else{

                        mImageView1 = imageView;
                        imageView.setImageResource(R.mipmap.topic_tag_selectx);
                        mMyTopicAdapter.mList.add(hotBean);
                        mMyTopicAdapter.notifyDataSetChanged();
                        hotBean.setSelect(true);
                    }


                if (mMyTopicAdapter.mList.size() > 0) {
                    mTagXuan.setVisibility(View.VISIBLE);
                    mTagSelect.setVisibility(View.GONE);
                } else {
                    mTagXuan.setVisibility(View.GONE);
                    mTagSelect.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected MyTopicPresenter<MyTopicMvp.MyTopicView> createPresenter() {
        return new MyTopicPresenter<>();
    }


    @OnClick({R.id.add_topic, R.id.topic_ok, R.id.okk})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.add_topic:
                mTagDefined.setVisibility(View.GONE);
                mAddTopic.setVisibility(View.GONE);
                mEditText.setVisibility(View.VISIBLE);
                mTopicOk.setVisibility(View.VISIBLE);
                break;
            case R.id.topic_ok:
                mTagDefined.setVisibility(View.VISIBLE);
                mAddTopic.setVisibility(View.VISIBLE);
                mEditText.setVisibility(View.GONE);
                mTopicOk.setVisibility(View.GONE);

                if (mEditText.getText().toString().isEmpty()) {
                    DialogBuilder dialogBuilder = new DialogBuilder(this);
                    dialogBuilder.title("警告！")
                            .message("标签名称不得为空")
                            .sureText("确定")
                            .setSureOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })

                            .build().show();
                } else {


                        mTagXuan.setVisibility(View.VISIBLE);
                        mTagSelect.setVisibility(View.GONE);

                        mMyTopicAdapter.mList.add(new HotBean.DataBean(null, mEditText.getText().toString(),false));
                        mMyTopicAdapter.notifyDataSetChanged();

                }
                mEditText.setText("");
                break;
            case R.id.okk:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       StringBuffer strings=new StringBuffer();
        for(int i=0;i<mMyTopicAdapter.mList.size();i++){
            String format = String.format("%s,", mMyTopicAdapter.mList.get(i).getTag());
            strings.append(format);
        }
        Log.d("mxoun", "onDestroy: "+strings.toString());
        EventBus.getDefault().post(strings.toString());
    }
}
