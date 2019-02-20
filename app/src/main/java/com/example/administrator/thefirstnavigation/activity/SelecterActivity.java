package com.example.administrator.thefirstnavigation.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.ChannleAdapter;
import com.example.administrator.thefirstnavigation.adapter.OtherChannleAdpter;
import com.example.administrator.thefirstnavigation.base.activity.SimpleActivity;
import com.example.administrator.thefirstnavigation.bean.GreenBean.SeclectorBean;
import com.example.administrator.thefirstnavigation.units.DefaultItemTouchHelpCallback;
import com.example.administrator.thefirstnavigation.units.dbunits.SelectorHelper;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/1/21.
 */

public class SelecterActivity extends SimpleActivity {
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.item_myHeader_text)
    TextView mItemMyHeaderText;
    @BindView(R.id.item_myHeader_image)
    ImageView mItemMyHeaderImage;
    @BindView(R.id.myChannel_oneList)
    RecyclerView mMyChannelOneList;
    @BindView(R.id.myChannel_twoList)
    RecyclerView mMyChannelTwoList;
    private boolean ischeck = true;
    private ChannleAdapter mChannleAdapter;
    private OtherChannleAdpter mOtherChannleAdpter;
    private DefaultItemTouchHelpCallback mCallback;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
        final List<SeclectorBean> cannle = new ArrayList<>();
        List<SeclectorBean> othercannle = new ArrayList<>();
        setToolBar(mToolBar, "我的频道");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        mChannleAdapter = new ChannleAdapter(cannle);
        mMyChannelOneList.setLayoutManager(gridLayoutManager);
        mMyChannelOneList.setAdapter(mChannleAdapter);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mMyChannelTwoList.setLayoutManager(manager);
        mOtherChannleAdpter = new OtherChannleAdpter(othercannle);
        mMyChannelTwoList.setAdapter(mOtherChannleAdpter);
        mChannleAdapter.OnsetOnClickListener(new ChannleAdapter.setOnClickListener() {


            @Override
            public void setOnClickListener(SeclectorBean seclectorBean) {
                mChannleAdapter.mList.remove(seclectorBean);
                mOtherChannleAdpter.mList.add(seclectorBean);
                mChannleAdapter.notifyDataSetChanged();
                mOtherChannleAdpter.notifyDataSetChanged();
                Log.d("mpxun", "setOnClickListener: " + seclectorBean.getChannelName());
            }

        });
        mOtherChannleAdpter.OnsetOnClickListener(new OtherChannleAdpter.setOnClickListener() {
            @Override
            public void setOnClickListener(SeclectorBean seclectorBean) {
                mChannleAdapter.mList.add(seclectorBean);
                mOtherChannleAdpter.mList.remove(seclectorBean);
                mChannleAdapter.notifyDataSetChanged();
                mOtherChannleAdpter.notifyDataSetChanged();

            }

            @Override
            public void setLongClickListener(View v, int position) {

            }
        });
        List<SeclectorBean> query = SelectorHelper.getInstance().query();
        for (int i = 0; i < query.size(); i++) {
            if (query.get(i).getIsShow()) {
                cannle.add(query.get(i));
            } else {
                othercannle.add(query.get(i));
            }
        }
//        final ItemTouchHelper itemTouchHelper1 = new ItemTouchHelper(new ItemTouchHelper.Callback() {
//            @Override
//            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//                if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
//                    int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | //代表支持哪个方向的拖拽
//                            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
//                    int swipeFlags = 0;//滑动删除的方向
//                    return makeMovementFlags(dragFlags, swipeFlags);
//                }
//                return 0;
//            }
//
//            @Override
//            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
//                //得到希望被替换掉的viewHolder的Position
//                int fromPosition = viewHolder.getAdapterPosition();
//                //拿到当前拖起的item的viewHolder
//                int toPosition = target.getAdapterPosition();
//                if (target.getAdapterPosition() != 0) {
//                    if (fromPosition < toPosition) {
//                        for (int i = fromPosition; i < toPosition; i++) {
//                            Collections.swap(cannle, i, i + 1);//交换位置
//
//                        }
//                    } else {
//                        for (int i = fromPosition; i > toPosition; i--) {
//                            Collections.swap(cannle, i, i - 1);
//                        }
//                    }
//                }
//
//                if (target.getAdapterPosition() == 0) { //如果是第一个，不能被其他的替换和移动
//                    return false;
//                }
//
//                mChannleAdapter.notifyItemMoved(fromPosition, toPosition);//刷新适配器
//                return true;
//            }
//
//            @Override
//            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//
//            }
//
//            @Override
//            public boolean isLongPressDragEnabled() {
//                return false;
//            }
//        });
//        mChannleAdapter.setOnItemLongClickListener(new ChannleAdapter.OnItemLongClickListener() {
//            @Override
//            public void OnItemLongClick(View v, ChannleAdapter.MyViewHolder holder, int position) {
//                if (position != 0) { //如果不是第一个，才可以移动
//                    itemTouchHelper1.startDrag(holder);
//                }
//            }
//        });
//        itemTouchHelper1.attachToRecyclerView(mMyChannelOneList);//把这个条目移动绑定recyclerview

        mCallback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {

            }

            @Override
            public boolean onMove(int srcPosition, int targetPosition) {
                if (cannle != null) {
                    Collections.swap(cannle, srcPosition, targetPosition);
                    mChannleAdapter.notifyItemMoved(srcPosition, targetPosition);

                    return true;
                }
                return false;
            }

            @Override
            public void clearView() {
                mChannleAdapter.notifyDataSetChanged();
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(mMyChannelOneList);
        mCallback.setDragEnable(true);
        mCallback.setSwipeEnable(false);

    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_selector;
    }


    @OnClick(R.id.item_myHeader_image)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.item_myHeader_image:
                if (ischeck) {
                    mItemMyHeaderImage.setImageResource(R.mipmap.wancheng);
                    mItemMyHeaderText.setText("编辑可进行删减或排序");
                    mChannleAdapter.show(true);
                    ischeck = false;
                } else {
                    mItemMyHeaderImage.setImageResource(R.mipmap.pianji);
                    mItemMyHeaderText.setText("长按可拖动排序");
                    mChannleAdapter.show(false);
                    ischeck = true;
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        List<SeclectorBean> showList = mChannleAdapter.mList;
        List<SeclectorBean> hideList = mOtherChannleAdpter.mList;
        SelectorHelper.getInstance().deleteAll();
        for(int i=0;i<showList.size();i++){
            SelectorHelper.getInstance().insert(new SeclectorBean(null,showList.get(i).getChannelName(),showList.get(i).getChannelId(),showList.get(i).getIsShow()));
        }
        for(int i=0;i<hideList.size();i++){
            SelectorHelper.getInstance().insert(new SeclectorBean(null,hideList.get(i).getChannelName(),hideList.get(i).getChannelId(),hideList.get(i).getIsShow()));
        }
        List<SeclectorBean> query = SelectorHelper.getInstance().query();
        EventBus.getDefault().post(query);
    }
}
