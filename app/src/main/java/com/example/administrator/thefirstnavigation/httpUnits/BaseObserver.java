package com.example.administrator.thefirstnavigation.httpUnits;


import android.util.Log;
import android.widget.Toast;

import com.example.administrator.thefirstnavigation.app.MyApp;
import com.example.administrator.thefirstnavigation.base.modle.HttpFinishCallback;
import com.example.administrator.thefirstnavigation.bean.SeveryEcception;
import com.example.administrator.thefirstnavigation.units.DaalogHelper;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by Administrator on 2018/12/21.
 */

public abstract class BaseObserver<T> implements Observer<T> {
    private HttpFinishCallback mHttpFinishCallback;
    public BaseObserver(HttpFinishCallback httpFinishCallback) {
        this.mHttpFinishCallback = httpFinishCallback;
    }

    //管理内存网络请求
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    @Override
    public void onSubscribe(Disposable d) {

        compositeDisposable.add(d);
    }

    @Override
    public void onError(Throwable e) {
        DaalogHelper.stopProgressDlg();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
        if (mHttpFinishCallback != null) {
            if (e instanceof SeveryEcception) {
                SeveryEcception severyEcception = (SeveryEcception) e;
                mHttpFinishCallback.setError(severyEcception.getMessage());
            }else{
                mHttpFinishCallback.setError("网络错误");
            }


        }
    }
    @Override
    public void onComplete() {
        if(compositeDisposable!=null){
            compositeDisposable.clear();
            DaalogHelper.stopProgressDlg();
        }
    }

}
