package com.example.administrator.thefirstnavigation.MvpInterface;

import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.base.view.BaseView;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListCommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicInfoBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;

/**
 * Created by Administrator on 2019/1/29.
 */

public interface TopicInFoMvp {
    interface TopicInFoView extends BaseView {
        void  showTopicInFo(TopicInfoBean uploadHeadImageBean);
        void  showListComment(ListCommentBean listCommentBean);
        void showLike();
        void showFavourite();
        void showFollow();
        void showDiscuss();
    }
    interface TopicInFoCallBack extends HttpFinishCallback {
        void setTopicInFo(TopicInfoBean topicInFo);
        void setListComment(ListCommentBean listComment);
        void setLike();
        void setFavourite();
        void setFollow();
        void setDiscuss();
    }
    interface TopicInFoModle{

        void getTopicInFo(String topicid, TopicInFoCallBack updateInfoCallBack);
        void getListComment(String json, TopicInFoCallBack topicCallBack);
        void getLike(String json, TopicInFoCallBack detailsCallBack);
        void getFavourite(String json,TopicInFoCallBack detailsCallBack);
        void getFollow(String json,TopicInFoCallBack detailsCallBack);
        void getDiscuss(String json,TopicInFoCallBack detailsCallBack);

    }
}
