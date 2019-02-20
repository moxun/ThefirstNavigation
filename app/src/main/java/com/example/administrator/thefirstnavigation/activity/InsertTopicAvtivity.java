package com.example.administrator.thefirstnavigation.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.MvpInterface.InsertMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.ImageAdapter;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.example.administrator.thefirstnavigation.presenter.InsertPresenter;
import com.example.administrator.thefirstnavigation.units.DialogBuilder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2019/2/1.
 */

public class InsertTopicAvtivity extends BaseActicity<InsertMvp.InsertView, InsertPresenter<InsertMvp.InsertView>> implements InsertMvp.InsertView {
    private static OnItemClick mItemClick;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.release_view1)
    View mReleaseView1;
    @BindView(R.id.release_select)
    TextView mReleaseSelect;
    @BindView(R.id.release_tag)
    ImageView mReleaseTag;
    @BindView(R.id.release_edit)
    EditText mReleaseEdit;
    @BindView(R.id.release_addimg)
    ImageView mReleaseAddimg;
    @BindView(R.id.release_addvideo)
    ImageView mReleaseAddvideo;
    @BindView(R.id.release_addshare)
    ImageView mReleaseAddshare;


    @BindView(R.id.insert_top)
    TextView mInsertTop;
    @BindView(R.id.image_recy)
    RecyclerView mImageRecy;
    private String taglist;
    private File mFile1;
    private File mFile;
    private ImageAdapter mImageAdapter;
    private ArrayList<File> mFiles=new ArrayList<>();

    @Override
    protected void initData() {
        setToolBar(mToolBar, "发表话题");
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(String messageEvent) {
        Log.d(TAG, "Event: " + messageEvent);
        taglist = messageEvent;
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_insert;
    }

    @Override
    protected InsertPresenter<InsertMvp.InsertView> createPresenter() {
        return new InsertPresenter<>();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mItemClick!=null){
            mItemClick.onItem();
        }

        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }



    public interface OnItemClick {
        void onItem();
    }

    public static void setOnItemClick(OnItemClick itemClick) {
        mItemClick = itemClick;
    }

    @OnClick({R.id.release_tag, R.id.release_addshare, R.id.release_addimg, R.id.insert_top})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.release_tag:
                startActivity(new Intent(this, MytopicActicity.class));
                break;
            case R.id.release_addshare:
                break;
            case R.id.release_addimg:
                MultiImageSelector.create(this).showCamera(true)
                        // 是否显示相机. 默认为显示
                        .count(9) // 最大选择图片数量, 默认为9. 只有在选择模式为多选时有效
                        .multi() // 多选模式, 默认模式;
                        .start(this, Characterl.REQUEST_CODE_TAKE_PICTURE);

                break;
            case R.id.insert_top:
                if (mReleaseEdit.getText().toString().isEmpty()) {
                    DialogBuilder dialogBuilder = new DialogBuilder(InsertTopicAvtivity.this);
                    dialogBuilder.title("警告！")
                            .message("请写入要发表的东西")
                            .sureText("确定")
                            .setSureOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })

                            .build().show();
                } else if(taglist==null) {
                    DialogBuilder dialogBuilder = new DialogBuilder(InsertTopicAvtivity.this);
                    dialogBuilder.title("警告！")
                            .message("请选择标签")
                            .sureText("确定")
                            .setSureOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })

                            .build().show();
                }else{
                    if (mFile == null) {
                        showDialo();
                    } else {
                        mPresentser.getInsert(mReleaseEdit.getText().toString(),taglist,mFiles,null);
                    }
                }

                break;
        }
    }

    public File getFile(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        File file = new File(Environment.getExternalStorageDirectory() + "/temp.jpg");
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            InputStream is = new ByteArrayInputStream(baos.toByteArray());
            int x = 0;
            byte[] b = new byte[1024 * 100];
            while ((x = is.read(b)) != -1) {
                fos.write(b, 0, x);
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Log.d(TAG, "onActivityResult: " + 1111);
            List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
            Log.d("phtot", path.size() + path.get(0));
            mFile = new File(path.get(0));
//            mFile1 = getFile(BitmapFactory.decodeFile(picturePath));
            Log.d("moxun", "onActivityResult: " + mFile.getPath());
            mImageAdapter = new ImageAdapter(path);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            mImageRecy.setLayoutManager(gridLayoutManager);
            mImageRecy.setAdapter(mImageAdapter);
            for (int i = 0; i <path.size() ; i++) {
                File file = new File(path.get(i));
                if(file.exists()){
                    mFiles.add(file);
                }
            }
        }
    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showInsert() {
        DialogBuilder dialogBuilder = new DialogBuilder(InsertTopicAvtivity.this);
        dialogBuilder.title("发布成功")

                .sureText("确定")
                .setSureOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                })

                .build().show();
    }

    private void showDialo() {
        View inflate = LayoutInflater.from(InsertTopicAvtivity.this).inflate(R.layout.imagepop, null);
        inflate.setAlpha(0.9f);
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
                mPresentser.getInsert(mReleaseEdit.getText().toString(),taglist,null,null);
                popupWin.dismiss();
            }
        });
        canleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MultiImageSelector.create(InsertTopicAvtivity.this).showCamera(true)
                        // 是否显示相机. 默认为显示
                        .count(9) // 最大选择图片数量, 默认为9. 只有在选择模式为多选时有效
                        .single() // 单选模式
                        .multi() // 多选模式, 默认模式;
                        .start(InsertTopicAvtivity.this, Characterl.REQUEST_CODE_TAKE_PICTURE);
                popupWin.dismiss();
            }
        });
    }
}
