package com.example.administrator.thefirstnavigation.bean.httpbane;

/**
 * Created by Administrator on 2019/2/12.
 */

public class FavouriteNews {
    private String favouritId;
    private String newsId;
    private String title;
    private boolean isSelect;

    public FavouriteNews(String favouritId, String newsId, String title, boolean isSelect) {
        this.favouritId = favouritId;
        this.newsId = newsId;
        this.title = title;
        this.isSelect = isSelect;
    }

    public String getFavouritId() {
        return favouritId;
    }

    public void setFavouritId(String favouritId) {
        this.favouritId = favouritId;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
