package com.example.administrator.thefirstnavigation.modle;

import com.example.administrator.thefirstnavigation.MvpInterface.InsertMvp;
import com.example.administrator.thefirstnavigation.bean.SeveryEcception;
import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;
import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;

import java.io.File;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2019/2/3.
 */

public class InsertModle implements InsertMvp.InsertModle {
    private RetorfitUnits mRetorfitUnits=new RetorfitUnits();

    @Override
    public void getInsert(String title, String taglist, ArrayList<File> file, String share, final InsertMvp.InsertCallBack insertCallBack) {
        insertCallBack.setShowProgressbar();
        mRetorfitUnits.getuploadFiles(title,taglist,file,share).compose(RxUtils.<MainBean>rxObserableSchedulerHelper())
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
                }).subscribe(new BaseObserver<String>(insertCallBack) {
            @Override
            public void onNext(String value) {
                insertCallBack.setInsert();
            }
        });
    }


}
