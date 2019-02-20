package com.example.administrator.thefirstnavigation.bean.jsonbean;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MoreFollow {
    private String userId;
    private String tagId;
    private String cursor;

    public MoreFollow(String userId, String tagId, String cursor) {
        this.userId = userId;
        this.tagId = tagId;
        this.cursor = cursor;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
