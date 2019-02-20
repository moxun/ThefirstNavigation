package com.example.administrator.thefirstnavigation.httpUnits;

import android.util.Log;

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
import com.example.administrator.thefirstnavigation.chartarray.Characterl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2019/1/17.
 */

public class RetorfitUnits implements HttpServer {
      private FristServer mFristServer;

    public RetorfitUnits() {
        mFristServer = HttpManager.getInstance().getServer(FristServer.URL, FristServer.class);
    }

    @Override
    public Observable<MainBean<UpListNewsBean>> getNewsObservable(String url) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), "");
        return mFristServer.postData(url,requestBody);
    }

    @Override
    public Observable<MainBean<UploadHeadImageBean>> getUploadHeadImage(File file) {

            RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("userId", "049de01db14a4c8184faa0aca7facf8a")
                    .addFormDataPart("headImageFile", file.getName(), RequestBody.create(MediaType.parse("image/jpg"), file)).build();
            Observable<MainBean<UploadHeadImageBean>> mainBeanObservable = mFristServer.uploadFileMore(requestBody);
            return mainBeanObservable;
        }

    @Override
    public Observable<MainBean> getUpdateInfo(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return  mFristServer.getData(requestBody);
    }

    @Override
    public Observable<MainBean<UpdaterNewsBean>> getDownNews(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getDownList(requestBody);
    }

    @Override
    public Observable<MainBean<UpdaterNewsBean>> getUpNews(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getUpList(requestBody);
    }

    @Override
    public Observable<MainBean<UpdaterNewsBean>> getSearch(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getSearch(requestBody);
    }

    @Override
    public Observable<MainBean<DetailsBean>> getDetails(String newsid) {
        RequestBody build = new FormBody.Builder()
                .add("userId", Characterl.newsid)
                .add("newsId", newsid)
                .build();
        return mFristServer.getDetails(build);
    }

    @Override
    public Observable<MainBean<AboutBean>> getAbout(String newsid) {

        Log.d("moxun", "getAbout: "+newsid);
        RequestBody build = new FormBody.Builder()
                .add("newsId", newsid)
                .build();
        return mFristServer.getAbout(build);
    }

    @Override
    public Observable<MainBean<CommentBean>> getCommentBean() {
        RequestBody build = new FormBody.Builder()
                .add("userId", Characterl.newsid)
                .build();
        return mFristServer.getComment(build);
    }

    @Override
    public Observable<MainBean<UserInfoBean>> getUserInfo() {
        RequestBody build = new FormBody.Builder()
                .add("userId", Characterl.newsid)
                .build();
        return mFristServer.getUerInfo(build);
    }

    @Override
    public Observable<MainBean> getDiscuss(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getDiscuss(requestBody);
    }

    @Override
    public Observable<MainBean> getLike(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getLike(requestBody);
    }

    @Override
    public Observable<MainBean> getFavourite(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getFavourite(requestBody);
    }

    @Override
    public Observable<MainBean<TopicBean>> getLoadTopic(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getloadTopic(requestBody);
    }

    @Override
    public Observable<MainBean<TopicBean>> getRefreshTopic(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getrefreshTopic(requestBody);
    }

    @Override
    public Observable<MainBean<TopicInfoBean>> getTopicInfo(String topicid) {
        RequestBody build = new FormBody.Builder()
                .add("topicId", topicid)
                .add("userId",Characterl.newsid)
                .build();
        return mFristServer.getTopicInFo(build);
    }

    @Override
    public Observable<MainBean<ListCommentBean>> getListComment(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getListComment(requestBody);
    }

    @Override
    public Observable<MainBean> getFollow(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getfollow(requestBody);
    }

    @Override
    public Observable<HotBean> getHot() {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), "");
        return mFristServer.getHot(requestBody);
    }

    @Override
    public Observable<MainBean<SearchBean>> getTopicSearch(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getTopicSearch(requestBody);
    }

    @Override
    public Observable<MainBean> getuploadFiles(String title, String taglist,ArrayList<File> file,String share) {
//        String format = String.format("%s,", taglist.get(0));
//        String format1 = String.format("%s", taglist.get(1));
//        if(file!=null){
//            Log.d("moxun", "getuploadFiles: "+file.getName());
//            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//            List<MultipartBody.Part> parts = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM)
//                    .addFormDataPart("userId", Characterl.newsid)
//                    .addFormDataPart("title",title)
//                    .addFormDataPart("tagList",format+format1 )
//                    .addFormDataPart("shareLink", "https://home.firefoxchina.cn/?from=extra_start")
//                    .addFormDataPart("fileList", file.getName(), requestBody)
//                    .build()
//                    .parts();
//            return mFristServer.uploadFiles(parts);
//        }else {
//            Log.d("moxun", "getuploadFiles: "+"辣鸡");
//            List<MultipartBody.Part> parts = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM)
//                    .addFormDataPart("userId", Characterl.newsid)
//                    .addFormDataPart("title",title)
//                    .addFormDataPart("tagList",format+format1 )
//                    .addFormDataPart("shareLink", "https://home.firefoxchina.cn/?from=extra_start")
//
//                    .build()
//                    .parts();
//            return mFristServer.uploadFiles(parts);
        if(file!=null){
            MultipartBody.Builder build = new MultipartBody.Builder()
                    //这里设置的请求头类型 不需要再传入@header写类型
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("userId", Characterl.newsid)
                    .addFormDataPart("title", title)
                    .addFormDataPart("tagList", taglist)
                    .addFormDataPart("shareLink","https://home.firefoxchina.cn/?from=extra_start")
                    ;

            for (int i = 0; i < file.size(); i++) {
                File file1 = file.get(i);
                RequestBody body = RequestBody.create(MediaType.parse("image/png"), file1);
                build.addFormDataPart("fileList",file1.getName(),body);
            }
            RequestBody body = build.build();

            return mFristServer.uploadFiles(body);
        }else{
            MultipartBody.Builder build = new MultipartBody.Builder()
                    //这里设置的请求头类型 不需要再传入@header写类型
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("userId", Characterl.newsid)
                    .addFormDataPart("title", title)
                    .addFormDataPart("tagList", taglist)
                    .addFormDataPart("shareLink","https://home.firefoxchina.cn/?from=extra_start")
                    ;
            MultipartBody build1 = build.build();
            return mFristServer.uploadFiles(build1);
        }

        }




    @Override
    public Observable<MainBean<UserCenterBean>> getUserCenter() {
        RequestBody build = new FormBody.Builder()
                .add("userId", Characterl.newsid)
                .build();
        return mFristServer.getUsercenter(build);
    }

    @Override
    public Observable<MainBean> getshowUpdateInfo(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getUpdateInfo(requestBody);
    }

    @Override
    public Observable<MainBean<FavouriteNewsBean>> getFavouriteNews(String cursor) {
        RequestBody build = new FormBody.Builder()
                .add("userId", Characterl.newsid)
                .add("cursor",cursor)
                .build();
        return mFristServer.getFavouriteNews(build);
    }

    @Override
    public Observable<MainBean<FavouriteTopicBean>> getFavouriteTopic(String cursor) {
        RequestBody build = new FormBody.Builder()
                .add("userId", Characterl.newsid)
                .add("cursor",cursor)
                .build();
        return mFristServer.getFavouriteTopic(build);
    }

    @Override
    public Observable<MainBean<FollowBean>> getFollow() {
        RequestBody build = new FormBody.Builder()
                .add("userId", Characterl.newsid)
                .build();
        return mFristServer.getFollow(build);
    }

    @Override
    public Observable<MainBean<MoreFollowBean>> getMoreFollow(String json) {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),json);
        return mFristServer.getMoreFollow(requestBody);
    }

    @Override
    public Observable<MainBean<MyCommentBean>> getMyComment() {
        RequestBody build = new FormBody.Builder()
                .add("userId", Characterl.newsid)
                .build();
        return mFristServer.getMyComment(build);
    }

    @Override
    public Observable<ListNoiftyBean> getNoifty() {
        RequestBody build = new FormBody.Builder()
                .add("userId", Characterl.newsid)
                .build();
        return mFristServer.getNoifty(build);
    }

    @Override
    public Observable<MainBean<MineTopicBean>> getMineTopic(String cursor) {
        RequestBody build = new FormBody.Builder()
                .add("userId", Characterl.newsid)
                .add("cursor",cursor)
                .build();
        return mFristServer.getMineTopic(build);
    }


}
