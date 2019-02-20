package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2019/2/3.
 */

public interface InsertMvp {
    interface  InsertView extends BaseView {
        void showInsert();
    }
    interface InsertCallBack extends HttpFinishCallback {
        void setInsert();
    }
    interface InsertModle{

        void getInsert(String title, String taglist,ArrayList<File> file,String share,InsertCallBack insertCallBack);
    }
}
