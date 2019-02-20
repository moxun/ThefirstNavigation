package com.example.administrator.thefirstnavigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.thefirstnavigation.bean.httpbane.MainBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpListNewsBean;
import com.example.administrator.thefirstnavigation.httpUnits.BaseObserver;

import com.example.administrator.thefirstnavigation.httpUnits.RetorfitUnits;
import com.example.administrator.thefirstnavigation.httpUnits.RxUtils;
import com.example.administrator.thefirstnavigation.units.DaalogHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Function;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_bu)
    TextView mTvBu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_bu)
    public void onClick(final View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_bu:
                DaalogHelper.showProgressDlg(this, "正在加载数据");
                RetorfitUnits retorfitUnits = new RetorfitUnits();
                retorfitUnits.getNewsObservable("news/listNewsChannel").compose(RxUtils.<MainBean<UpListNewsBean>>rxObserableSchedulerHelper())
                        .compose(RxUtils.<UpListNewsBean>handleResult())
                        .subscribe(new BaseObserver<UpListNewsBean>(null) {
                            @Override
                            public void onNext(UpListNewsBean value) {
                                Log.d("moxun", "onNext: "+value.getNewsChannelList().get(0).getChannelName());
                            }
                        });

                break;
        }
    }
    public static class HandleFuc<T> implements Function<MainBean<T>, T> {

        @Override
        public T apply(MainBean<T> tMainBean) throws Exception {
            if(tMainBean.getCode()!=0){
                throw new RuntimeException(tMainBean.getCode() + "" + tMainBean.getMessage() != null ? tMainBean.getMessage() : "");
            }
            return tMainBean.getData();
        }
    }


}
