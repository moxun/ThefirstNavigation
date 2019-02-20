package com.example.administrator.thefirstnavigation.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.thefirstnavigation.MvpInterface.UserInfoMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserCenterBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserInfoBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.UpdataSet;
import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.example.administrator.thefirstnavigation.presenter.UserInfoPresenter;
import com.google.gson.Gson;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2019/2/11.
 */

public class UpdateInfoActivity extends BaseActicity<UserInfoMvp.UserInfoView, UserInfoPresenter<UserInfoMvp.UserInfoView>> implements UserInfoMvp.UserInfoView, DatePicker.OnDateChangedListener {

    private static OnItemClick mItemClick;
    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.edit1)
    TextView mEdit1;
    @BindView(R.id.head)
    ImageView mHead;
    @BindView(R.id.iv2)
    ImageView mIv2;
    @BindView(R.id.name)
    EditText mName;
    @BindView(R.id.iv3)
    ImageView mIv3;
    @BindView(R.id.sex)
    EditText mSex;
    @BindView(R.id.iv4)
    ImageView mIv4;
    @BindView(R.id.day)
    EditText mDay;
    @BindView(R.id.iv5)
    ImageView mIv5;
    @BindView(R.id.person)
    EditText mPerson;
    @BindView(R.id.iv_job)
    ImageView mIv6;
    @BindView(R.id.xinxi)
    TextView mXinxi;
    @BindView(R.id.bt)
    Button mBt;
    @BindView(R.id.iv_jianjie)
    ImageView mIvJianjie;
    private File mFile;
    private int year, month, day;
    private StringBuffer date = new StringBuffer();
    private String mResult_value=null;

    @Override
    protected void initData() {
        mPresentser.getInfo();
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);

    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_updateinfo;
    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showHot(UserCenterBean hotBean) {

    }

    @Override
    public void showUpdateInfo() {

    }

    @Override
    public void showUserInfo(UserInfoBean userInfoBean) {
        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(this).load(userInfoBean.getHeadImagePath()).apply(options).into(mHead);

        mName.setText(userInfoBean.getNickname());

        mSex.setText(userInfoBean.getSex() + "");
        mDay.setText(userInfoBean.getBirthday() + "");
        mPerson.setText(userInfoBean.getProfessionName() + "");
    }

    @Override
    public void showUploadHead(UploadHeadImageBean uploadHeadImageBean) {
        Log.d(TAG, "showUploadHead: " + "lalalal");
        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(this).load(uploadHeadImageBean.getHeadImagePath()).apply(options).into(mHead);
    }

    @Override
    protected UserInfoPresenter<UserInfoMvp.UserInfoView> createPresenter() {
        return new UserInfoPresenter<>();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1001){
            mResult_value = data.getStringExtra("result");
            Log.d(TAG, "onActivityResult: "+ mResult_value);
        }else{
            if (data != null) {
                Log.d(TAG, "onActivityResult: " + 1111);
                List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                Log.d("phtot", path.size() + path.get(0));
                mFile = new File(path.get(0));
//            mFile1 = getFile(BitmapFactory.decodeFile(picturePath));
                Log.d("moxun", "onActivityResult: " + mFile.getPath());
                mPresentser.getUploadHead(mFile);
            }
        }

    }

    @OnClick({R.id.iv, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv_job, R.id.bt, R.id.iv_jianjie})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv:
                finish();
                mItemClick.onItem();
                break;
            case R.id.iv2:
                MultiImageSelector.create(UpdateInfoActivity.this).showCamera(true)
                        // 是否显示相机. 默认为显示
                        .single() // 单选模式
                        .start(UpdateInfoActivity.this, Characterl.REQUEST_CODE_TAKE_PICTURE);
                break;
            case R.id.iv3:
                mName.setEnabled(true);

                break;
            case R.id.iv4:
                mSex.setEnabled(true);
                break;
            case R.id.iv5:
                mDay.setEnabled(true);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mDay.setText(date.append(String.valueOf(year)).append("-").append(String.valueOf(month)).append("-").append(day));

                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                final AlertDialog dialog = builder.create();
                View dialogView = View.inflate(this, R.layout.dialog_date, null);
                final DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.datePicker);
                dialog.setTitle("设置日期");
                dialog.setView(dialogView);
                dialog.show();
                //初始化日期监听事件
                datePicker.init(year, month - 1, day, this);
                break;
            case R.id.iv_job:
                mPerson.setEnabled(true);
                break;
            case R.id.bt:
                String name = mName.getText().toString();
                String sex = mSex.getText().toString();
                String day = mDay.getText().toString();
                String person = mPerson.getText().toString();
                if(mResult_value==null){
                    Gson gson = new Gson();
                    String json = gson.toJson(new UpdataSet(Characterl.newsid, day, name, "", person, sex));
                    Log.e("---JSON------", json.toString());
                    mPresentser.getUpdateInfo(json);
                }else{
                    Gson gson = new Gson();
                    String json = gson.toJson(new UpdataSet(Characterl.newsid, day, name, mResult_value, person, sex));
                    Log.e("---JSON------", json.toString());
                    mPresentser.getUpdateInfo(json);
                }

                Toast.makeText(this, "上传成功", Toast.LENGTH_SHORT).show();
                mName.setEnabled(false);
                mDay.setEnabled(false);
                mSex.setEnabled(false);
                mPerson.setEnabled(false);
                break;
            case R.id.iv_jianjie:
                Intent intent = new Intent(this,IntroActivity.class);
                startActivityForResult(intent,1001);
                break;
        }
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        this.year = year;
        this.month = monthOfYear;
        this.day = dayOfMonth;
    }


    public interface OnItemClick {
        void onItem();
    }

    public static void setOnItemClick(OnItemClick itemClick) {
        mItemClick = itemClick;
    }



}
