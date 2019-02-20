package com.example.administrator.thefirstnavigation.httpUnits;

import com.example.administrator.thefirstnavigation.bean.httpbane.AboutBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.CommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.DetailsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.DownListNewsBean;
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
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdateInfoBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UploadHeadImageBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserCenterBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserInfoBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2019/1/17.
 */

public interface FristServer {

    String URL="https://www.firstgainfo.com/firstga/app/";


    /*

     */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<UpListNewsBean>> postData(@Url String url, @Body RequestBody requestBody);

    /*
    修改个人信息
     */
    @POST("users/updateInfo")
    @Headers("Content-Type:application/json")
    Observable<MainBean>getData(@Body RequestBody requestBody);

    /*
    上传头像
     */
    @POST("users/uploadHeadImage")
    Observable<MainBean<UploadHeadImageBean>> uploadFileMore(@Body RequestBody requestBody);

    @POST("news/downListNews")
    @Headers("Content-Type:application/json")
    Observable<MainBean<UpdaterNewsBean>>getDownList(@Body RequestBody requestBody);

    @POST("news/upListNews")
    @Headers("Content-Type:application/json")
    Observable<MainBean<UpdaterNewsBean>>getUpList(@Body RequestBody requestBody);

    @POST("news/search")
    @Headers("Content-Type:application/json")
    Observable<MainBean<UpdaterNewsBean>>getSearch(@Body RequestBody requestBody);

    @POST("news/info")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<DetailsBean>>getDetails(@Body RequestBody requestBody);

    @POST("news/relevant")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<AboutBean>>getAbout(@Body RequestBody requestBody);

    @POST("users/listComment")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<CommentBean>>getComment(@Body RequestBody requestBody);

    @POST("users/info")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<UserInfoBean>>getUerInfo(@Body RequestBody requestBody);

    @POST("users/center")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<UserCenterBean>>getUsercenter(@Body RequestBody requestBody);

    @POST("users/comment")
    @Headers("Content-Type:application/json")
    Observable<MainBean>getDiscuss(@Body RequestBody requestBody);

    @POST("users/like")
    @Headers("Content-Type:application/json")
    Observable<MainBean>getLike(@Body RequestBody requestBody);

    @POST("users/favourite")
    @Headers("Content-Type:application/json")
    Observable<MainBean>getFavourite(@Body RequestBody requestBody);

    @POST("topic/loadTopic")
    @Headers("Content-Type:application/json")
    Observable<MainBean<TopicBean>>getloadTopic(@Body RequestBody requestBody);

    @POST("topic/refreshTopic")
    @Headers("Content-Type:application/json")
    Observable<MainBean<TopicBean>>getrefreshTopic(@Body RequestBody requestBody);

    @POST("topic/info")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<TopicInfoBean>>getTopicInFo(@Body RequestBody requestBody);


    @POST("comment/listComment")
    @Headers("Content-Type:application/json")
    Observable<MainBean<ListCommentBean>>getListComment(@Body RequestBody requestBody);

    @POST("users/follow")
    @Headers("Content-Type:application/json")
    Observable<MainBean>getfollow(@Body RequestBody requestBody);

    @POST("tags/hot")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<HotBean>getHot(@Body RequestBody requestBody);



    @POST("tags/search")
    @Headers("Content-Type:application/json")
    Observable<MainBean<SearchBean>>getTopicSearch(@Body RequestBody requestBody);

    @POST("topic/insertTopic")
    Observable<MainBean> uploadFiles(@Body RequestBody requestBody);


    @POST("users/updateInfo")
    @Headers("Content-Type:application/json")
    Observable<MainBean>getUpdateInfo(@Body RequestBody requestBody);

    @POST("users/favourite/news")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<FavouriteNewsBean>>getFavouriteNews(@Body RequestBody requestBody);

    @POST("users/favourite/topic")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<FavouriteTopicBean>>getFavouriteTopic(@Body RequestBody requestBody);

    @POST("users/listFollow")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<FollowBean>>getFollow(@Body RequestBody requestBody);

    @POST("users/moreFollow")
    @Headers("Content-Type:application/json")
    Observable<MainBean<MoreFollowBean>>getMoreFollow(@Body RequestBody requestBody);

    @POST("users/listComment")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<MyCommentBean>>getMyComment(@Body RequestBody requestBody);


    @POST("users/listNotify")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<ListNoiftyBean>getNoifty(@Body RequestBody requestBody);


    @POST("users/listTopic")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<MainBean<MineTopicBean>>getMineTopic(@Body RequestBody requestBody);
}
