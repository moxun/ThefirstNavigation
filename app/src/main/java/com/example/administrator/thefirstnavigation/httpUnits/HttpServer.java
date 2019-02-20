package com.example.administrator.thefirstnavigation.httpUnits;


import com.example.administrator.thefirstnavigation.bean.httpbane.AboutBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.CommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.DetailsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.FavouriteTopicBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.FollowBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.HotBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListCommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListNoiftyBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MineTopicBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MoreFollowBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MyCommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.SearchBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicInfoBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpListNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserCenterBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserInfoBean;

import java.io.File;
import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2019/1/17.
 */

public interface HttpServer {
    Observable<MainBean<UpListNewsBean>>  getNewsObservable(String url);

    Observable<MainBean<UploadHeadImageBean>> getUploadHeadImage(File file);

    Observable<MainBean>  getUpdateInfo(String json);

    Observable<MainBean<UpdaterNewsBean>> getDownNews(String json);

    Observable<MainBean<UpdaterNewsBean>> getUpNews(String json);

    Observable<MainBean<UpdaterNewsBean>> getSearch(String json);

    Observable<MainBean<DetailsBean>> getDetails(String newsid);

    Observable<MainBean<AboutBean>> getAbout(String newsid);

    Observable<MainBean<CommentBean>> getCommentBean();

    Observable<MainBean<UserInfoBean>>  getUserInfo();

    Observable<MainBean> getDiscuss(String json);

    Observable<MainBean> getLike(String json);

    Observable<MainBean> getFavourite(String json);

    Observable<MainBean<TopicBean>> getLoadTopic(String json);

    Observable<MainBean<TopicBean>> getRefreshTopic(String json);

    Observable<MainBean<TopicInfoBean>> getTopicInfo(String topicid);

    Observable<MainBean<ListCommentBean>> getListComment(String json);

    Observable<MainBean> getFollow(String json);

    Observable<HotBean> getHot();

    Observable<MainBean<SearchBean>> getTopicSearch(String json);

    Observable<MainBean> getuploadFiles(String title, String taglist,ArrayList<File> file,String share);

    Observable<MainBean<UserCenterBean>> getUserCenter();

    Observable<MainBean> getshowUpdateInfo(String json);

    Observable<MainBean<FavouriteNewsBean>> getFavouriteNews(String cursor);

    Observable<MainBean<FavouriteTopicBean>> getFavouriteTopic(String cursor);

    Observable<MainBean<FollowBean>> getFollow();

    Observable<MainBean<MoreFollowBean>> getMoreFollow(String json);

    Observable<MainBean<MyCommentBean>> getMyComment();

    Observable<ListNoiftyBean> getNoifty();

    Observable<MainBean<MineTopicBean>> getMineTopic(String cursor);
}
