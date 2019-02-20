package com.example.administrator.thefirstnavigation.bean.httpbane;

import java.util.List;

/**
 * Created by Administrator on 2019/2/13.
 */

public class MyCommentBean {

    private List<UserCommentListBean> userCommentList;

    public List<UserCommentListBean> getUserCommentList() {
        return userCommentList;
    }

    public void setUserCommentList(List<UserCommentListBean> userCommentList) {
        this.userCommentList = userCommentList;
    }

    public static class UserCommentListBean {
        /**
         * commentId : 3bec7c7aaa2b4bdfb7d1734086aab809
         * commentTime : 2019-02-13
         * content : 渣男锡纸烫
         * objectId : 03ca4730d3f349d1bee3a3b409f03bc8
         * objectType : 0
         * title : 航空器国籍和适航证件系统5月7日起正式启用
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
