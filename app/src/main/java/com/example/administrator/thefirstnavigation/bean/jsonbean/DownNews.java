package com.example.administrator.thefirstnavigation.bean.jsonbean;

/**
 * Created by Administrator on 2019/1/21.
 */

public class DownNews {
    private String userId;
    private String channelId;
    private String cursor;

    public DownNews(String userId, String channelId, String cursor) {
        this.userId = userId;
        this.channelId = channelId;
        this.cursor = cursor;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
