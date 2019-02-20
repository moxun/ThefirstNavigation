package com.example.administrator.thefirstnavigation.httpUnits;

import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.SeveryEcception;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名：MyProject
 * 包名：  com.liangxq.mydemo.utils
 * 文件名：RxUtils
 * 创建者：liangxq
 * 创建时间：2018/12/21  9:46
 * 描述：TODO
 */
public class RxUtils {


    public static <T> ObservableTransformer<T, T> rxObserableSchedulerHelper() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> ObservableTransformer<MainBean<T>,T>handleResult(){
        return new ObservableTransformer<MainBean<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<MainBean<T>> upstream) {
                return upstream.flatMap(new Function<MainBean<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(MainBean<T> tMainBean) throws Exception {
                        if(tMainBean.getCode()!=0){
                            return  Observable.error(new SeveryEcception(tMainBean.getCode(),tMainBean.getMessage()));
                        }else{
                            return createData(tMainBean.getData());
                        }
                    }
                });
            }
        };
    }
    /**
     * 统一线程处理
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
    public static <T> Observable<T> createData(final T t){
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emm) throws Exception {
                try {
                    emm.onNext(t);
                    emm.onComplete();
                }catch (Exception e1){
                    emm.onError(e1);
                }
            }
        });
    }
}
