package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.activity.DetailsActivity;
import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.AboutBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.CommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.DetailsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserInfoBean;

/**
 * Created by Administrator on 2019/1/27.
 */

public interface DetailsMvp {
    interface DetailsView extends BaseView {
        void  showBean(DetailsBean downListNewsBean);
        void  showAbout(AboutBean aboutBean);
        void  showComment(CommentBean commentBean);
        void showInFoBean(UserInfoBean userInfoBean);
        void showDiscuss();
        void showLike();
        void showFavourite();
    }
    interface DetailsCallBack extends HttpFinishCallback {
        void setBean(DetailsBean downListNewsBean);
        void setAbout(AboutBean about);
        void setComment(CommentBean comment);
        void setInFoBean(UserInfoBean userInfoBean);
        void setDiscuss();
        void setLike();
        void setFavourite();
    }
    interface DetailsModle{
        void getNews(String newsid,DetailsCallBack downListNewsCallBack);
        void getAbout(String newid,DetailsCallBack detailsCallBack);
        void getComment(DetailsCallBack detailsCallBack);
        void getUserInfoBean(DetailsCallBack detailsCallBack);
        void getDiscuss(String json,DetailsCallBack detailsCallBack);
        void getLike(String json, DetailsCallBack detailsCallBack);
        void getFavourite(String json,DetailsCallBack detailsCallBack);
    }
}
