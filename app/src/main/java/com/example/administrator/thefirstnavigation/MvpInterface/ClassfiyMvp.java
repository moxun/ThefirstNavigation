package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.SearchBean;

/**
 * Created by Administrator on 2019/1/31.
 */

public interface ClassfiyMvp {
    interface  ClassfiyView extends BaseView{
        void showHot(HotBean hotBean);
        void showTopicSearch(SearchBean searchBean);
    }
    interface ClassfiyCallBack extends HttpFinishCallback{
        void setHot(HotBean hot);
        void setTopicSearch(SearchBean search);
    }
    interface ClassfiyModle{
        void getClassfiy(ClassfiyCallBack classfiyCallBack);
        void getTopicSearch(String json,ClassfiyCallBack classfiyCallBack);
    }
}
