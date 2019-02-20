package com.example.administrator.thefirstnavigation.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.thefirstnavigation.MvpInterface.DetailsMvp;
import com.example.administrator.thefirstnavigation.R;
import com.example.administrator.thefirstnavigation.adapter.CommentAdapter;
import com.example.administrator.thefirstnavigation.base.activity.BaseActicity;
import com.example.administrator.thefirstnavigation.bean.httpbane.AboutBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.CommentBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.DetailsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.InfoBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UpdaterNewsBean;
import com.example.administrator.thefirstnavigation.bean.httpbane.UserInfoBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.Comment;
import com.example.administrator.thefirstnavigation.bean.jsonbean.LikeBean;
import com.example.administrator.thefirstnavigation.chartarray.Characterl;
import com.example.administrator.thefirstnavigation.presenter.DetailsPresenterIml;
import com.example.administrator.thefirstnavigation.units.DialogBuilder;
import com.example.administrator.thefirstnavigation.units.ShareUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/1/27.
 */

public class DetailsActivity extends BaseActicity<DetailsMvp.DetailsView, DetailsPresenterIml<DetailsMvp.DetailsView>> implements DetailsMvp.DetailsView {
    @BindView(R.id.titleBar)
    Toolbar mTitleBar;
    @BindView(R.id.news_title)
    TextView mNewsTitle;
    @BindView(R.id.origin)
    TextView mOrigin;
    @BindView(R.id.addCollected)
    ImageView mAddCollected;
    @BindView(R.id.time)
    TextView mTime;

    @BindView(R.id.major)
    ImageView mMajor;
    @BindView(R.id.about_news)
    RecyclerView mAboutNews;
    @BindView(R.id.pinlun_text)
    TextView mPinlunText;
    @BindView(R.id.rv_pinglun)
    RecyclerView mRvPinglun;

    @BindView(R.id.scrollView)
    ScrollView mScrollView;
    @BindView(R.id.bottom_cutLine)
    View mBottomCutLine;
    @BindView(R.id.write_follow)
    ImageView mWriteFollow;
    @BindView(R.id.pinlun)
    ImageView mPinlun;
    @BindView(R.id.faverate)
    ImageView mFaverate;
    @BindView(R.id.share)
    ImageView mShare;
    @BindView(R.id.bottom_ll)
    LinearLayout mBottomLl;
    @BindView(R.id.webview)
    WebView mWebview;
    private String mContent;
    private String mNewsId;
    private AboutBean mAboutBean1;
    private UserInfoBean mUserInfoBean1;
    private CommentAdapter mCommentAdapter;
    private String mTitle;
    private int mIsLiked;
    private int mIsFavoured;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //注意要清除 FLAG_TRANSLUCENT_STATUS flag
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.gray));
        setToolBar(mTitleBar, "");
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        UpdaterNewsBean.NewListBean bean = (UpdaterNewsBean.NewListBean) extras.getSerializable("bean");
        mNewsId = bean.getNewsId();
        Log.d("moxun", "initData: " + bean.getNewsId());
        List<InfoBean> list = new ArrayList<>();
        mTitle = bean.getTitle();

        mPresentser.getDetails(bean.getNewsId());
//        mPresentser.getAbout(bean.getNewsId());

        mPresentser.getUserInfo();
        mPresentser.getComment();
    }

    @Override
    public int createLayoutID() {
        return R.layout.activity_details;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void hideProgressbar() {

    }


    @Override
    public void showBean(final DetailsBean downListNewsBean) {
        mIsLiked = downListNewsBean.getIsLiked();
        if (downListNewsBean.getIsLiked() == 0) {
            mMajor.setImageResource(R.mipmap.news_praise);
        } else {
            mMajor.setImageResource(R.mipmap.news_praise_high);
        }
        mIsFavoured = downListNewsBean.getIsFavoured();
        if (mIsFavoured == 0) {
            mFaverate.setImageResource(R.mipmap.news_favouredx);
        } else {
            mFaverate.setImageResource(R.mipmap.news_favoured_highx);
        }
        Log.d("moxun", "showBean: " + downListNewsBean.getTitle() + mIsLiked);

        mContent = downListNewsBean.getContent();
        Log.d("moxun", "showBean: " + downListNewsBean.getContent());
        //解析下来的对象的body Html字符串 放入该方法中 得到的字符串 用webview 调用loadData()方法 即可显示!

        mNewsTitle.setText(downListNewsBean.getTitle());
        mOrigin.setText(downListNewsBean.getOrigin());
        mTime.setText(downListNewsBean.getPublishTime());
        String htmlData = getHtmlData(mContent);
        //得到设置webview的对象
        WebSettings settings = mWebview.getSettings();
//设置字体
        settings.setDefaultFontSize(18);
        //  mWebview.loadData(htmlData, "text/html", "UTF -8");//API提供的标准用法，无法解决乱码问题
        mWebview.loadData(htmlData, "text/html; charset=UTF-8", null);//这种写法可以正确解码
    }

    @Override
    public void showAbout(AboutBean aboutBean) {
        Log.d("chimu", "showAbout: " + aboutBean.getNewsId());
        mAboutBean1 = aboutBean;
    }

    @Override
    public void showComment(CommentBean commentBean) {
        List<InfoBean> list = new ArrayList<>();
        Log.d("woshinidie", "showComment: " + commentBean.getUserCommentList().size());
        for (int i = 0; i < commentBean.getUserCommentList().size(); i++) {
            CommentBean.UserCommentListBean userCommentListBean = commentBean.getUserCommentList().get(i);
            if (commentBean.getUserCommentList().get(i).getObjectId().equals(mNewsId)) {
                list.add(new InfoBean(userCommentListBean.getCommentTime(), userCommentListBean.getContent(), mUserInfoBean1.getHeadImagePath(), mUserInfoBean1.getNickname(), Characterl.newsid));
            }
        }
        Log.d("moxun", "showComment: " + list.size());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvPinglun.setLayoutManager(linearLayoutManager);
        mCommentAdapter = new CommentAdapter(this, list);
        mRvPinglun.setAdapter(mCommentAdapter);
    }

    @Override
    public void showInFoBean(UserInfoBean userInfoBean) {
        Log.d("woshinidie", "showInFoBean: " + userInfoBean.getNickname());
        mUserInfoBean1 = userInfoBean;
    }

    @Override
    public void showDiscuss() {
        Log.d("moxun", "showDiscuss: " + "发布成功");
        mCommentAdapter.list.clear();
        mPresentser.getComment();
    }

    @Override
    public void showLike() {
        Log.d("moxun", "showLike: " + "doo");
    }

    @Override
    public void showFavourite() {

    }

    @Override
    protected DetailsPresenterIml<DetailsMvp.DetailsView> createPresenter() {
        return new DetailsPresenterIml<>();
    }

    private String getHtmlData(String bodyHTML) {
        String head = "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style>img{max-width: 100%; width:auto; height:auto;}</style>" +
                "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }


    @SuppressLint("WrongConstant")
    @OnClick({R.id.pinlun, R.id.faverate, R.id.share, R.id.addCollected, R.id.major, R.id.write_follow})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.pinlun:
                showPop();
                break;
            case R.id.faverate:
                if (mIsFavoured == 0) {
                    mFaverate.setImageResource(R.mipmap.news_favoured_highx);
                    mIsFavoured=1;
                    LikeBean likeBean = new LikeBean(Characterl.newsid, mNewsId, "0", "0");
                    Gson gson = new Gson();
                    String json = gson.toJson(likeBean);
                    mPresentser.getFavourite(json);
                } else {
                    mFaverate.setImageResource(R.mipmap.news_favouredx);
                    mIsFavoured=0;
                    LikeBean likeBean = new LikeBean(Characterl.newsid, mNewsId, "0", "1");
                    Gson gson = new Gson();
                    String json = gson.toJson(likeBean);
                    mPresentser.getFavourite(json);
                }
                break;
            case R.id.share:
                ShareUtil.shareText(DetailsActivity.this, mTitle, "分享一篇文章");
                break;
            case R.id.addCollected:

                break;
            case R.id.major:
                if (mIsLiked == 0) {
                    LikeBean likeBean = new LikeBean(Characterl.newsid, mNewsId, "0", "0");
                    Gson gson = new Gson();
                    String json = gson.toJson(likeBean);
                    mPresentser.getLike(json);

                    mMajor.setImageResource(R.mipmap.news_praise_high);
                    mIsLiked = 1;
                } else {
                    LikeBean likeBean = new LikeBean(Characterl.newsid, mNewsId, "0", "1");
                    Gson gson = new Gson();
                    String json = gson.toJson(likeBean);
                    mPresentser.getLike(json);
                    mMajor.setImageResource(R.mipmap.news_praise);
                    mIsLiked = 0;
                }
                break;
            case R.id.write_follow:
                showPop();
                break;
        }
    }

    @SuppressLint("WrongConstant")
    private void showPop() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.commentpop, null);
        TextView faBu = inflate.findViewById(R.id.fabu);
        final EditText neiRong = inflate.findViewById(R.id.neiRong);
        final TextView length = inflate.findViewById(R.id.length);
        final PopupWindow pop = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        pop.showAsDropDown(faBu, 0, 0);
        pop.setFocusable(true);
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        final InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE); //这里给它设置了弹出的时间，
        imm.toggleSoftInput(1000, InputMethodManager.HIDE_NOT_ALWAYS);
        TextView quXiao = inflate.findViewById(R.id.quXiao);
        neiRong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this, "11111", Toast.LENGTH_SHORT).show();
                pop.dismiss();
            }
        });
        quXiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                imm.hideSoftInputFromWindow(neiRong.getWindowToken(), 0);
            }
        });
        neiRong.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 150) {
                    length.setText(s.length() + "");
                } else {
                    DialogBuilder dialogBuilder = new DialogBuilder(DetailsActivity.this);
                    dialogBuilder.title("警告！")
                            .message("字符不能超过150")
                            .sureText("确定")
                            .setSureOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })

                            .build().show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                imm.hideSoftInputFromWindow(neiRong.getWindowToken(), 0);
            }
        });
        faBu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comment comment = new Comment(Characterl.newsid, mNewsId, "0", neiRong.getText().toString());
                Gson gson = new Gson();
                String json = gson.toJson(comment);
                mPresentser.getDiscuss(json);
                imm.hideSoftInputFromWindow(neiRong.getWindowToken(), 0);
                pop.dismiss();
            }
        });

    }


}
