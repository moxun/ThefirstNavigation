package com.example.administrator.thefirstnavigation.bean.jsonbean;

/**
 * Created by Administrator on 2019/1/28.
 */

public class Topic {
    private String type;
    private String cursor;
    private  String userId;
    private  String tagId;

    public Topic(String type, String cursor, String userId, String tagId) {
        this.type = type;
        this.cursor = cursor;
        this.userId = userId;
        this.tagId = tagId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
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
}
