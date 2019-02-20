package com.example.administrator.thefirstnavigation.bean.httpbane;

import java.util.List;

/**
 * Created by Administrator on 2019/1/27.
 */

public class CommentBean {


    private List<UserCommentListBean> userCommentList;

    public List<UserCommentListBean> getUserCommentList() {
        return userCommentList;
    }

    public void setUserCommentList(List<UserCommentListBean> userCommentList) {
        this.userCommentList = userCommentList;
    }

    public static class UserCommentListBean {
        /**
         * commentId : 457d69deebdc481091bb2bd624441438
         * commentTime : 2019-01-19
         * content : 我是你爸爸
         * objectId : be06d74614a74b81b70d11219240ba9d
         * objectType : 1
         * title : 我是王强，最性感，谁不服就来干服我
         */

        private String commentId;
        private String commentTime;
        private String content;
        private String objectId;
        private String objectType;
        private String title;

        public String getCommentId() {
            return commentId;
        }

        public void setCommentId(String commentId) {
            this.commentId = commentId;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
