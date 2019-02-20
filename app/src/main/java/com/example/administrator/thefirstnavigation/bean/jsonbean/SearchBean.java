package com.example.administrator.thefirstnavigation.bean.jsonbean;

/**
 * Created by Administrator on 2019/1/24.;
 */

public class SearchBean {
    private String keyword;
    private String cursor;

    public SearchBean(String keyword, String cursor) {
        this.keyword = keyword;
        this.cursor = cursor;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
