package com.example.administrator.thefirstnavigation.bean.jsonbean;

/**
 * Created by Administrator on 2019/1/28.
 */

public class LikeBean {
    private  String userId;
    private String objectId;
    private String objectType;
    private String type;

    public LikeBean(String userId, String objectId, String objectType, String type) {
        this.userId = userId;
        this.objectId = objectId;
        this.objectType = objectType;
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
