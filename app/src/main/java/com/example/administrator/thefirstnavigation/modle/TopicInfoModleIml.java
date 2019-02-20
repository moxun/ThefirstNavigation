package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.DetailsMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.TopicInFoMvp;
import com.example.administrator.thefirstnavigation.MvpInterface.TopicMvp;
import com.example.administrator.thefirstnavigation.bean.SeveryEcception;
import com.example.administrator.thefirstnavigation.bean.httpbane.ListCommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.TopicInfoBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2019/1/29.
 */

public class TopicInfoModleIml implements TopicInFoMvp.TopicInFoModle {
    private RetorfitUnits mRetorfitUnits=new RetorfitUnits();
    @Override
    public void getTopicInFo(String topicid, final TopicInFoMvp.TopicInFoCallBack updateInfoCallBack) {
        updateInfoCallBack.setShowProgressbar();
        mRetorfitUnits.getTopicInfo(topicid).compose(RxUtils.<MainBean<TopicInfoBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<TopicInfoBean>handleResult())
                .subscribe(new BaseObserver<TopicInfoBean>(updateInfoCallBack) {
                    @Override
                    public void onNext(TopicInfoBean value) {
                        updateInfoCallBack.setTopicInFo(value);
                    }
                });
    }

    @Override
    public void getListComment(String json, final TopicInFoMvp.TopicInFoCallBack topicCallBack) {
        mRetorfitUnits.getListComment(json).compose(RxUtils.<MainBean<ListCommentBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<ListCommentBean>handleResult())
                .subscribe(new BaseObserver<ListCommentBean>(topicCallBack) {
                    @Override
                    public void onNext(ListCommentBean value) {
                        topicCallBack.setListComment(value);
                    }
                });
    }

    @Override
    public void getLike(String json, final TopicInFoMvp.TopicInFoCallBack detailsCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        detailsCallBack.setShowProgressbar();
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
    public void getFavourite(String json, final TopicInFoMvp.TopicInFoCallBack detailsCallBack) {
        RetorfitUnits retorfitUnits = new RetorfitUnits();
        detailsCallBack.setShowProgressbar();
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

    @Override
    public void getFollow(String json, final TopicInFoMvp.TopicInFoCallBack detailsCallBack) {
        detailsCallBack.setShowProgressbar();
        mRetorfitUnits.getFollow(json).compose(RxUtils.<MainBean>rxObserableSchedulerHelper())
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
                detailsCallBack.setFollow();
            }
        });

    }

    @Override
    public void getDiscuss(String json, final TopicInFoMvp.TopicInFoCallBack detailsCallBack) {
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


}
