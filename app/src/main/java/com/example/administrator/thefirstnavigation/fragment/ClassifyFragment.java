package com.example.administrator.thefirstnavigation.fragment;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.MvpInterface.ClassfiyMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.activity.ClassifyActivity;
import com.example.administrator.thefirstnavigation.adapter.HotAdapter;
import com.example.administrator.thefirstnavigation.adapter.TopicSearchAdapter;
import com.example.administrator.thefirstnavigation.base.fragment.BaseFragment;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.SearchBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.TopicSearch;
import com.example.administrator.thefirstnavigation.presenter.ClassfiyPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/1/28.
 */

public class ClassifyFragment extends BaseFragment<ClassfiyMvp.ClassfiyView, ClassfiyPresenter<ClassfiyMvp.ClassfiyView>> implements ClassfiyMvp.ClassfiyView {
    @BindView(R.id.item_search)
    EditText mItemSearch;
    @BindView(R.id.text_no)
    ImageView mTextNo;
    @BindView(R.id.item_sousuo)
    TextView mItemSousuo;
    @BindView(R.id.item_recy)
    RecyclerView mItemRecy;
    @BindView(R.id.item_searc)
    RecyclerView mItemSearc;
    private View view;
    private Unbinder unbinder;
    private List<HotBean.DataBean> mDataBeans = new ArrayList<>();
    private HotAdapter mHotAdapter;
    private int mInt = 0;
    private List<SearchBean.TagListBean> mTagListBeans = new ArrayList<>();
    private TopicSearch mTopicSearch;
    private TopicSearchAdapter mTopicSearchAdapter;

    @Override
    public int createLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initData() {
        mItemRecy.setLayoutManager(new LinearLayoutManager(mActivity));
        mHotAdapter = new HotAdapter(mDataBeans, mActivity);
        mItemRecy.setAdapter(mHotAdapter);
        presenter.getHot();


        mItemSearch.addTextChangedListener(new TextWatcher() {



            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if(s.length()==0){
                        mHotAdapter.mList.clear();
                        mHotAdapter.notifyDataSetChanged();
                        mHotAdapter.getString("");
                        presenter.getHot();
                    }else{
                        mHotAdapter.mList.clear();
                        mHotAdapter.notifyDataSetChanged();
                        mHotAdapter.getString(s.toString());
                        TopicSearch topicSearch = new TopicSearch(s.toString(), "0");
                        Gson gson = new Gson();
                        String json = gson.toJson(topicSearch);
                        presenter.getSearch(json);
                    }



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showHot(HotBean hotBean) {
        Log.d("moxun", "showHot: " + hotBean.getData().get(0).getId());

        mHotAdapter.addAll(hotBean.getData(), 0);
    }

    @Override
    public void showTopicSearch(SearchBean searchBean) {
        Log.d("moxun", "showTopicSearch: "+searchBean.getTagList().get(2).getId());
        List<SearchBean.TagListBean> tagList = searchBean.getTagList();
        List<HotBean.DataBean> list=new ArrayList<>();
        for(int i=0;i<tagList.size();i++){
            list.add(new HotBean.DataBean(tagList.get(i).getId(),tagList.get(i).getTag()));
        }
        mHotAdapter.addAll(list,0);
    }

    @Override
    protected ClassfiyPresenter<ClassfiyMvp.ClassfiyView> createPresenter() {
        return new ClassfiyPresenter<>();
    }


    @OnClick({R.id.text_no, R.id.item_sousuo})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.text_no:
                mItemSearch.setText("");
                break;
            case R.id.item_sousuo:

                break;
        }
    }


}
