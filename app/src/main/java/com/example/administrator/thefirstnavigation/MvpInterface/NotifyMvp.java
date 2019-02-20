package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListNoiftyBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MyCommentBean;

/**
 * Created by Administrator on 2019/2/14.
 */

public interface NotifyMvp {
    interface  NotifyView extends BaseView {
        void showNotify(ListNoiftyBean listNoiftyBean);
    }
    interface NotifyCallBack extends HttpFinishCallback {
        void setNotify(ListNoiftyBean listNoiftyBean);
    }
    interface NotifyModle{
        void getNotify(NotifyCallBack classfiyCallBack);

    }
}
