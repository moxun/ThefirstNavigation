package com.example.administrator.thefirstnavigation.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.base.adapter.BaseAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;



/**
 * Created by Administrator on 2019/2/12.
 */

public class ImageAdapter extends BaseAdapter<String> {
    private String TAG="moxun";
    private ImageView mImageView;

    public ImageAdapter(List<String> dataList) {
        super(dataList);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_image;
    }

    @Override
    public void addAll(List<String> list, int page) {

    }

    @Override
    public void createHolder(ViewHolder holder, String s, int position) {
        mImageView = holder.itemView.findViewById(R.id.image_add);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(s);
            Bitmap bitmap  = BitmapFactory.decodeStream(fis);
            mImageView.setImageBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
