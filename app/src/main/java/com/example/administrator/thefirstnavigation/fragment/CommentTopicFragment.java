package com.example.administrator.thefirstnavigation.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.thefirstnavigation.MvpInterface.MyCommentMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.MyCommentAdapter;
import com.example.administrator.thefirstnavigation.base.fragment.BaseFragment;
import com.example.administrator.thefirstnavigation.bean.httpbane.MyCommentBean;
import com.example.administrator.thefirstnavigation.presenter.MyCommentPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/2/13.
 */

public class CommentTopicFragment extends BaseFragment<MyCommentMvp.MyCommentView, MyCommentPresenter<MyCommentMvp.MyCommentView>> implements MyCommentMvp.MyCommentView {
    @BindView(R.id.recy_more)
    RecyclerView mRecyMore;
    private String mHead;
    private String mName;
    private View view;
    private Unbinder unbinder;
    private List<MyCommentBean.UserCommentListBean> mUserCommentListBeans=new ArrayList<>();

    @Override
    public int createLayoutId() {
        return R.layout.fragment_morefollow;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        mHead = arguments.getString("head");
        mName = arguments.getString("name");
        presenter.getMyComment();
    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showMyComment(MyCommentBean myCommentBean) {
        Log.d("mozun", "showMyComment: " + myCommentBean.getUserCommentList().size() + "topic");
        for (int i = 0; i < myCommentBean.getUserCommentList().size(); i++) {
            if (myCommentBean.getUserCommentList().get(i).getObjectType().equals("1")) {
                mUserCommentListBeans.add(myCommentBean.getUserCommentList().get(i));
            }
        }
        MyCommentAdapter myCommentAdapter = new MyCommentAdapter(mUserCommentListBeans, mHead, mName);
        mRecyMore.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyMore.setAdapter(myCommentAdapter);
    }

    @Override
    protected MyCommentPresenter<MyCommentMvp.MyCommentView> createPresenter() {
        return new MyCommentPresenter<>();
    }

}
