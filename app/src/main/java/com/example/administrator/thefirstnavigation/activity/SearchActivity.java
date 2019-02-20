package com.example.administrator.thefirstnavigation.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.HistoryAdapter;
import com.example.administrator.thefirstnavigation.adapter.Searchadapter;
import com.example.administrator.thefirstnavigation.base.activity.SimpleActivity;
import com.example.administrator.thefirstnavigation.bean.GreenBean.HistoryBean;
import com.example.administrator.thefirstnavigation.fragment.ArticleFragment;
import com.example.administrator.thefirstnavigation.fragment.ConversationFragment;
import com.example.administrator.thefirstnavigation.units.dbunits.HistoryHelper;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/1/23.
 */

public class SearchActivity extends SimpleActivity {
    @BindView(R.id.search_edit)
    EditText mSearchEdit;
    @BindView(R.id.search_text_quxiao)
    TextView mSearchTextQuxiao;
    @BindView(R.id.search_toolbar)
    Toolbar mSearchToolbar;
    @BindView(R.id.search_qingkong)
    TextView mSearchQingkong;
    @BindView(R.id.search_text_clearHistory)
    TextView mSearchTextClearHistory;
    @BindView(R.id.search_list_history)
    RecyclerView mSearchListHistory;
    @BindView(R.id.search_hot_one)
    TextView mSearchHotOne;
    @BindView(R.id.search_hot_two)
    TextView mSearchHotTwo;
    @BindView(R.id.search_hot_three)
    TextView mSearchHotThree;
    @BindView(R.id.search_hot_four)
    TextView mSearchHotFour;
    @BindView(R.id.search_hot_five)
    TextView mSearchHotFive;
    @BindView(R.id.search_one)
    RelativeLayout mSearchOne;
    @BindView(R.id.TabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.ViewPager)
    ViewPager mViewPager;
    @BindView(R.id.search_two)
    LinearLayout mSearchTwo;
    private List<HistoryBean> mQuery;
    private HistoryAdapter mHistoryAdapter;
    private boolean isChick = true;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));


        mSearchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("moxun", "onTextChanged: ");
                if (!mSearchEdit.getText().toString().isEmpty()) {
                    mSearchTextQuxiao.setText("搜索");
                    mSearchQingkong.setVisibility(View.VISIBLE);

                } else {
                    mSearchTextQuxiao.setText("取消");
                    mSearchQingkong.setVisibility(View.GONE);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mSearchListHistory.setLayoutManager(gridLayoutManager);
        mQuery = HistoryHelper.getInstance().query();
        Log.d("jjjjjjjjjj", "initData: " + mQuery.size());
        mHistoryAdapter = new HistoryAdapter(mQuery);
        mSearchListHistory.setAdapter(mHistoryAdapter);
        mHistoryAdapter.OnsetOnClickListener(new HistoryAdapter.setOnClickListener() {
            @Override
            public void setOnClickListener(HistoryBean newsListBean) {
                mSearchOne.setVisibility(View.GONE);
                mSearchTwo.setVisibility(View.VISIBLE);

                EventBus.getDefault().postSticky(newsListBean.getHistory());
            }
        });
        ArrayList<String> title = new ArrayList<>();
        title.add("文章");
        title.add("话题");
        ArticleFragment articleFragment = new ArticleFragment();
        ConversationFragment conversationFragment = new ConversationFragment();
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(articleFragment);
        fragments.add(conversationFragment);
        Searchadapter searchadapter = new Searchadapter(getSupportFragmentManager(), title, fragments);
        mViewPager.setAdapter(searchadapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_search2;
    }


    @OnClick({R.id.search_qingkong, R.id.search_text_quxiao, R.id.search_text_clearHistory, R.id.search_hot_one, R.id.search_hot_two, R.id.search_hot_three, R.id.search_hot_four, R.id.search_hot_five})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.search_qingkong:
                mSearchEdit.setText("");
                break;

            case R.id.search_text_quxiao:
                if (mSearchTextQuxiao.getText().toString().equals("取消")) {

                    if(isChick){
                        mSearchOne.setVisibility(View.VISIBLE);
                        mSearchTwo.setVisibility(View.GONE);
                        isChick=false;
                    }else{
                        finish();
                    }
                } else {

                    String search = mSearchEdit.getText().toString();
                    if(!HistoryHelper.getInstance().queryLikeId(search)){
                        HistoryHelper.getInstance().insert(new HistoryBean(null, search));
                    }

                    List<HistoryBean> query = HistoryHelper.getInstance().query();
                    mHistoryAdapter.mList.clear();
                    mHistoryAdapter.addAll(query, 0);
                    mSearchOne.setVisibility(View.GONE);
                    mSearchTwo.setVisibility(View.VISIBLE);

                    EventBus.getDefault().postSticky(mSearchEdit.getText().toString());

                    mSearchEdit.setText("");
                }
                break;

            case R.id.search_text_clearHistory:
                HistoryHelper.getInstance().deleteAll();
                mHistoryAdapter.mList.clear();
                mHistoryAdapter.notifyDataSetChanged();
                break;
            case R.id.search_hot_one:
                mSearchOne.setVisibility(View.GONE);
                mSearchTwo.setVisibility(View.VISIBLE);

                EventBus.getDefault().postSticky("无人机");
                break;
            case R.id.search_hot_two:
                mSearchOne.setVisibility(View.GONE);
                mSearchTwo.setVisibility(View.VISIBLE);

                EventBus.getDefault().postSticky("机场");
                break;
            case R.id.search_hot_three:
                mSearchOne.setVisibility(View.GONE);
                mSearchTwo.setVisibility(View.VISIBLE);

                EventBus.getDefault().postSticky("飞机");
                break;
            case R.id.search_hot_four:
                mSearchOne.setVisibility(View.GONE);
                mSearchTwo.setVisibility(View.VISIBLE);

                EventBus.getDefault().postSticky("中国造");
                break;
            case R.id.search_hot_five:
                mSearchOne.setVisibility(View.GONE);
                mSearchTwo.setVisibility(View.VISIBLE);

                EventBus.getDefault().postSticky("无");

                break;
        }
    }



}
