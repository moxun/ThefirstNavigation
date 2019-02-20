package com.example.administrator.thefirstnavigation.modle;

import android.util.Log;

import com.example.administrator.thefirstnavigation.MvpInterface.DetailsMvp;
import com.example.administrator.thefirstnavigation.bean.SeveryEcception;
import com.example.administrator.thefirstnavigation.bean.httpbane.AboutBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.CommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.DetailsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserInfoBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2019/1/27.
 */

public class DetailsModleIml implements DetailsMvp.DetailsModle {

    @Override
    public void getNews(String newsid, final DetailsMvp.DetailsCallBack downListNewsCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getDetails(newsid).compose(RxUtils.<MainBean<DetailsBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<DetailsBean>handleResult())
                .subscribe(new BaseObserver<DetailsBean>(downListNewsCallBack) {
                    @Override
                    public void onNext(DetailsBean value) {
                        downListNewsCallBack.setBean(value);
                    }
                });

    }

    @Override
    public void getAbout(String newid, final DetailsMvp.DetailsCallBack detailsCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        Log.d("lol", "getAbout: "+newid);
        retorfitUnits.getAbout(newid).compose(RxUtils.<MainBean<AboutBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<AboutBean>handleResult())
                .subscribe(new BaseObserver<AboutBean>(detailsCallBack) {
                    @Override
                    public void onNext(AboutBean value) {
                        detailsCallBack.setAbout(value);
                    }
                });

    }

    @Override
    public void getComment(final DetailsMvp.DetailsCallBack detailsCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getCommentBean().compose(RxUtils.<MainBean<CommentBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<CommentBean>handleResult())
                .subscribe(new BaseObserver<CommentBean>(detailsCallBack) {
                    @Override
                    public void onNext(CommentBean value) {
                        detailsCallBack.setComment(value);
                    }
                });
    }

    @Override
    public void getUserInfoBean(final DetailsMvp.DetailsCallBack detailsCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getUserInfo().compose(RxUtils.<MainBean<UserInfoBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UserInfoBean>handleResult())
                .subscribe(new BaseObserver<UserInfoBean>(detailsCallBack) {
                    @Override
                    public void onNext(UserInfoBean value) {
                        detailsCallBack.setInFoBean(value);
                    }
                });
    }

    @Override
    public void getDiscuss(String json, final DetailsMvp.DetailsCallBack detailsCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getDiscuss(json).compose(RxUtils.<MainBean>rxObserableSchedulerHelper())
                .flatMap(new Function<MainBean, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final MainBean mainBean) throws Exception {
                        if (mainBean.getCode() != 0) {
                            return Observable.error(new SeveryEcception(mainBean.getCode(), mainBean.getMessage()));
                        } else {
                            return Observable.create(new ObservableOnSubscribe<String>() {
                                @Override
                                public void subscribe(ObservableEmitter<String> emm) throws Exception {
                                    try {
                                        emm.onNext(mainBean.getMessage());
                                        emm.onComplete();
                                    } catch (Exception e1) {
                                        emm.onError(e1);
                                    }
                                }
                            });
                        }
                    }
                }).subscribe(new BaseObserver<String>(detailsCallBack) {
            @Override
            public void onNext(String value) {
                detailsCallBack.setDiscuss();
            }
        });
    }

    @Override
    public void getLike(String json, final DetailsMvp.DetailsCallBack detailsCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getLike(json).compose(RxUtils.<MainBean>rxObserableSchedulerHelper())
                .flatMap(new Function<MainBean, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final MainBean mainBean) throws Exception {
                        if (mainBean.getCode() != 0) {
                            return Observable.error(new SeveryEcception(mainBean.getCode(), mainBean.getMessage()));
                        } else {
                            return Observable.create(new ObservableOnSubscribe<String>() {
                                @Override
                                public void subscribe(ObservableEmitter<String> emm) throws Exception {
                                    try {
                                        emm.onNext(mainBean.getMessage());
                                        emm.onComplete();
                                    } catch (Exception e1) {
                                        emm.onError(e1);
                                    }
                                }
                            });
                        }
                    }
                }).subscribe(new BaseObserver<String>(detailsCallBack) {
            @Override
            public void onNext(String value) {
                detailsCallBack.setLike();
            }
        });
    }

    @Override
    public void getFavourite(String json, final DetailsMvp.DetailsCallBack detailsCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        retorfitUnits.getFavourite(json).compose(RxUtils.<MainBean>rxObserableSchedulerHelper())
                .flatMap(new Function<MainBean, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final MainBean mainBean) throws Exception {
                        if (mainBean.getCode() != 0) {
                            return Observable.error(new SeveryEcception(mainBean.getCode(), mainBean.getMessage()));
                        } else {
                            return Observable.create(new ObservableOnSubscribe<String>() {
                                @Override
                                public void subscribe(ObservableEmitter<String> emm) throws Exception {
                                    try {
                                        emm.onNext(mainBean.getMessage());
                                        emm.onComplete();
                                    } catch (Exception e1) {
                                        emm.onError(e1);
                                    }
                                }
                            });
                        }
                    }
                }).subscribe(new BaseObserver<String>(detailsCallBack) {
            @Override
            public void onNext(String value) {
                detailsCallBack.setFavourite();
            }
        });
    }


}
