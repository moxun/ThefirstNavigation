package com.example.administrator.thefirstnavigation.MvpInterface;

import com.android.common.Search;
import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;

import java.io.File;

/**
 * Created by Administrator on 2019/1/24.
 */

public interface SearchMvp {
    interface SearchView extends BaseView {
        void  showSearch(UpdaterNewsBean uploadHeadImageBean);

    }
    interface SearchCallBack extends HttpFinishCallback {
        void setSearch(UpdaterNewsBean uploadHead);

    }
    interface SearchModle{

        void getSearch(String json, SearchCallBack updateInfoCallBack);
    }
}
