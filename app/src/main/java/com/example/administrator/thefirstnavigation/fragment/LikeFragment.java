package com.example.administrator.thefirstnavigation.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.thefirstnavigation.MvpInterface.NotifyMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.CommentNotiftAdapter;
import com.example.administrator.thefirstnavigation.adapter.LikeAdapter;
import com.example.administrator.thefirstnavigation.base.fragment.BaseFragment;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListNoiftyBean;
import com.example.administrator.thefirstnavigation.presenter.NotifyPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/2/14.
 */

public class LikeFragment extends BaseFragment<NotifyMvp.NotifyView, NotifyPresenter<NotifyMvp.NotifyView>> implements NotifyMvp.NotifyView {
    @BindView(R.id.recy_more)
    RecyclerView mRecyMore;
    private View view;
    private Unbinder unbinder;
    private ArrayList<ListNoiftyBean.DataBean> mDataBeans = new ArrayList<>();
    private LikeAdapter mSystemAdapter;

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showNotify(ListNoiftyBean listNoiftyBean) {
        Log.d("moxun", "showNotify: " + listNoiftyBean.getData().size());
        for (int i = 0; i < listNoiftyBean.getData().size(); i++) {

            if (listNoiftyBean.getData().get(i).getNotifyType().equals("2")) {
                mDataBeans.add(listNoiftyBean.getData().get(i));
            }
        }

        Log.d("moxun", "showNotify: " + mDataBeans.size());
        mSystemAdapter = new LikeAdapter(mDataBeans, context);
        mRecyMore.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyMore.setAdapter(mSystemAdapter);
    }

    @Override
    protected NotifyPresenter<NotifyMvp.NotifyView> createPresenter() {
        return new NotifyPresenter<>();
    }

    @Override
    public int createLayoutId() {
        return R.layout.fragment_morefollow;
    }

    @Override
    protected void initData() {
        presenter.getNotify();
    }


}
