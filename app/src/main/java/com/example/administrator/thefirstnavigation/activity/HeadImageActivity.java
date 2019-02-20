package com.example.administrator.thefirstnavigation.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.thefirstnavigation.MvpInterface.UploadHeadImageMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.bean.GreenBean.LoginBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.UpdataSet;
import com.example.administrator.thefirstnavigation.bean.jsonbean.UpdateInfo;
import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.example.administrator.thefirstnavigation.presenter.UploadHeadPresenterIml;
import com.example.administrator.thefirstnavigation.units.DialogBuilder;
import com.example.administrator.thefirstnavigation.units.dbunits.LoginHelper;
import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/1/18.
 */

public class HeadImageActivity extends BaseActicity<UploadHeadImageMvp.UploadHeadView, UploadHeadPresenterIml<UploadHeadImageMvp.UploadHeadView>> implements UploadHeadImageMvp.UploadHeadView {
    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.back1)
    ImageView mBack1;
    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.et)
    EditText mEt;
    @BindView(R.id.iv2)
    ImageView mIv2;
    @BindView(R.id.tv2)
    TextView mTv2;

    private Uri uriForFile;

    private String mFilePath;
    private String mPhone;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mPhone = intent.getStringExtra("phone");

    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_headimage;
    }

    @OnClick({R.id.back, R.id.back1, R.id.tv, R.id.iv2, R.id.tv2, R.id.iv})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.back1:
                showDialo();
                break;
            case R.id.tv:
                showpupwindow();
                break;
            case R.id.iv2:
                if(!mEt.getText().toString().isEmpty()){
                    UpdataSet updataSet = new UpdataSet();
                    updataSet.setBirthday("");
                    updataSet.setNickname(mEt.getText().toString());
                    updataSet.setUserId(Characterl.newsid);
                    updataSet.setPersonalProfile("");
                    updataSet.setProfessionId("");
                    updataSet.setSex("");
                    Gson gson = new Gson();
                    String json = gson.toJson(updataSet);
                    Log.d("json", "onClick: "+json);
                    mPresentser.getUpdate(json);


                }else{
                    final DialogBuilder dialogBuilder = new DialogBuilder(this);
                    dialogBuilder.title("警告！")
                            .message("用户名不能为空")
                            .sureText("确定")
                            .setSureOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })

                            .build().show();
                }
                break;
            case R.id.tv2:

                showDialo();
                break;
            case R.id.iv:
                showpupwindow();
                break;

        }
    }

    private void showDialo() {
        View inflate = LayoutInflater.from(HeadImageActivity.this).inflate(R.layout.popupbefore, null);
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
        Random random = new Random();
        String result = "user";
        for (int i = 0; i < 10; i++) {
            result += random.nextInt(10);
        }
        final String finalResult = result;
        name.setText(finalResult);
        Button canleButton = inflate.findViewById(R.id.dialog_btn_cancel);

        final Button sureButton = inflate.findViewById(R.id.dialog_btn_sure);

        sureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEt.requestFocus();
                popupWin.dismiss();
            }
        });
        canleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdataSet updataSet = new UpdataSet();
                updataSet.setBirthday("");
                updataSet.setNickname(finalResult);
                updataSet.setUserId(Characterl.newsid);
                updataSet.setPersonalProfile("");
                updataSet.setProfessionId("");
                updataSet.setSex("");
                Gson gson = new Gson();
                String json = gson.toJson(updataSet);
                Log.d("json", "onClick: "+json);
                mPresentser.getUpdate(json);

                popupWin.dismiss();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case Characterl.REQUEST_CODE_TAKE_PICTURE:

                Bundle extras = data.getExtras();
                Bitmap data1 = (Bitmap) extras.get("data");

                mTv.setText("更换图像");
                File file = getFile(data1);
                mPresentser.getUploadHead(file);
                break;
            case Characterl.REQUEST_PHOTO:
                if (data != null) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();



                    File file1 = getFile(BitmapFactory.decodeFile(picturePath));
                    Log.d("moxun", "onActivityResult: " + file1.getPath());
                    mTv.setText("更换图像");
                    mPresentser.getUploadHead(file1);
                }

                break;


            default:
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

    private void showpupwindow() {


        View view = LayoutInflater.from(this).inflate(R.layout.pouwindows, null);
        Button photo = view.findViewById(R.id.buuton_photo);
        Button camera = view.findViewById(R.id.button);

        final PopupWindow pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        pop.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        pop.setContentView(view);

        //背景颜色
        pop.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        //动画效果
        pop.setAnimationStyle(R.style.anim_menu_bottombar);
        //显示位置
        pop.showAtLocation(mIv, Gravity.BOTTOM, 0, 0);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        pop.setBackgroundDrawable(null);
        pop.setOutsideTouchable(true);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(intent, Characterl.REQUEST_PHOTO);
                pop.dismiss();
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 启动系统相机

//                startActivityForResult(intent, Characterl.REQUEST_CODE_TAKE_PICTURE);
                startActivityForResult(intent, Characterl.REQUEST_CODE_TAKE_PICTURE);
                pop.dismiss();
            }
        });
       /* pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        pop.setContentView(view);*/

    }

    @Override
    public void hideProgressbar() {

    }


    @Override
    public void showUploadHead(UploadHeadImageBean uploadHeadImageBean) {
        Log.d("moxun", "showUploadHead: " + uploadHeadImageBean.getHeadImagePath());
        RequestOptions requestOptions1 = RequestOptions.circleCropTransform();
        Glide.with(this).load(uploadHeadImageBean.getHeadImagePath()).apply(requestOptions1).into(mIv);
    }

    @Override
    public void showMessage() {
        Log.d("kkk", "showMessage: ");
        LoginHelper.getInstance().insert(new LoginBean(null,mPhone,true));
        startActivity(new Intent(HeadImageActivity.this,InformationActivity.class));
    }

    @Override
    protected UploadHeadPresenterIml<UploadHeadImageMvp.UploadHeadView> createPresenter() {
        return new UploadHeadPresenterIml<>();
    }


}
