package com.example.administrator.thefirstnavigation.bean.httpbane;

import java.util.List;

/**
 * Created by Administrator on 2019/1/29.
 */

public class ListCommentBean {


    private List<CommentListBean> commentList;

    public List<CommentListBean> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentListBean> commentList) {
        this.commentList = commentList;
    }

    public static class CommentListBean {
        /**
         * commentTime : 2019-01-28 15:05:35
         * content : 我是你爹
         * headImagePath : http://39.107.254.232/firstga/images/head/2019-01-28/049de01db14a4c8184faa0aca7facf8a_1548681932790.jpg
         * nickname : 傻子
         * userId : 049de01db14a4c8184faa0aca7facf8a
         */

        private String commentTime;
        private String content;
        private String headImagePath;
        private String nickname;
        private String userId;

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
}
