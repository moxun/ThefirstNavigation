package com.example.administrator.thefirstnavigation.bean.httpbane;

/**
 * Created by Administrator on 2019/1/29.
 */

public class Follow {
    private String userId;
    private String followUid;
    private String type;

    public Follow(String userId, String followUid, String type) {
        this.userId = userId;
        this.followUid = followUid;
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFollowUid() {
        return followUid;
    }

    public void setFollowUid(String followUid) {
        this.followUid = followUid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
