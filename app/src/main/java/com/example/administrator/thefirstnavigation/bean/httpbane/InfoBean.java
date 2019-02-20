package com.example.administrator.thefirstnavigation.bean.httpbane;

/**
 * Created by Administrator on 2019/1/27.
 */

public class InfoBean {
    public String commentTime;
    public String content;
    public String headImagePath;
    public String nickname;
    public String userId;

    public InfoBean(String commentTime, String content, String headImagePath, String nickname, String userId) {
        this.commentTime = commentTime;
        this.content = content;
        this.headImagePath = headImagePath;
        this.nickname = nickname;
        this.userId = userId;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
