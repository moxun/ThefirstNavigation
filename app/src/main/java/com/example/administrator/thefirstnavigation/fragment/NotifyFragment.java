package com.example.administrator.thefirstnavigation.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.thefirstnavigation.MvpInterface.NotifyMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.SystemAdapter;
import com.example.administrator.thefirstnavigation.base.fragment.BaseFragment;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListNoiftyBean;
import com.example.administrator.thefirstnavigation.presenter.NotifyPresenter;
import com.example.administrator.thefirstnavigation.units.swipe_menu.MyDividerDecoration;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/2/14.
 */

public class NotifyFragment extends BaseFragment<NotifyMvp.NotifyView, NotifyPresenter<NotifyMvp.NotifyView>> implements NotifyMvp.NotifyView {
    @BindView(R.id.reList)
    SwipeMenuRecyclerView mRecyMore;

    @BindView(R.id.ll_read)
    LinearLayout mLlRead;

    private ArrayList<ListNoiftyBean.DataBean> mDataBeans = new ArrayList<>();
    private String mType;
    private SystemAdapter mSystemAdapter;

    @Override
    public int createLayoutId() {
        return R.layout.fragment_notify;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        mType = arguments.getString("type");
        presenter.getNotify();
    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showNotify(ListNoiftyBean listNoiftyBean) {

        for (int i = 0; i < listNoiftyBean.getData().size(); i++) {

            if (listNoiftyBean.getData().get(i).getNotifyType().equals(mType)) {
                mDataBeans.add(listNoiftyBean.getData().get(i));
            }
        }
        if(mDataBeans.size()==0){
            mRecyMore.setVisibility(View.GONE);
            mLlRead.setVisibility(View.VISIBLE);
        }
        Log.d("moxun", "showNotify: " + mDataBeans.size());
        mSystemAdapter = new SystemAdapter(mDataBeans, context);
        mRecyMore.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyMore.setSwipeMenuCreator(mMSwipeMenuCreator);
        mRecyMore.setSwipeMenuItemClickListener(mEnuItemClickListener);
        mRecyMore.addItemDecoration(new MyDividerDecoration());
        mRecyMore.setAdapter(mSystemAdapter);
    }

    public SwipeMenuCreator mMSwipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            int width = getResources().getDimensionPixelSize(R.dimen.dp_70);
            SwipeMenuItem deleteItem = new SwipeMenuItem(getActivity())
                    .setBackground(R.color.colorRed)
                    .setWidth(width)
                    .setHeight(height)
                    .setTextColor(Color.WHITE)
                    .setText("删除");
            swipeRightMenu.addMenuItem(deleteItem);
        }
    };

    public SwipeMenuItemClickListener mEnuItemClickListener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {
            menuBridge.closeMenu();
            int position1 = menuBridge.getAdapterPosition();
            mSystemAdapter.mList.remove(position1);
            mSystemAdapter.notifyDataSetChanged();
        }
    };

    @Override
    protected NotifyPresenter<NotifyMvp.NotifyView> createPresenter() {
        return new NotifyPresenter<>();
    }


}
