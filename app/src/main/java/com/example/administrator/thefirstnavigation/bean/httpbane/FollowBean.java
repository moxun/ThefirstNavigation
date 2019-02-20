package com.example.administrator.thefirstnavigation.bean.httpbane;

import java.util.List;

/**
 * Created by Administrator on 2019/2/13.
 */

public class FollowBean {

    private List<FollowListBean> followList;

    public List<FollowListBean> getFollowList() {
        return followList;
    }

    public void setFollowList(List<FollowListBean> followList) {
        this.followList = followList;
    }

    public static class FollowListBean {
        /**
         * followId : 40f6048cb469430c8ed0da32135c1dd0
         * followTime : 2019-01-29
         * followUid : 392cbe1d4c6e4b0094f84bad059c8793
         * headImagePath : http://39.107.254.232/firstga/images/head/2018-05-21/392cbe1d4c6e4b0094f84bad059c8793_1526893725568.jpg
         * nickname : 一航
         * personalProfile :
         */

        private String followId;
        private String followTime;
        private String followUid;
        private String headImagePath;
        private String nickname;
        private String personalProfile;

        public String getFollowId() {
            return followId;
        }

        public void setFollowId(String followId) {
            this.followId = followId;
        }

        public String getFollowTime() {
            return followTime;
        }

        public void setFollowTime(String followTime) {
            this.followTime = followTime;
        }

        public String getFollowUid() {
            return followUid;
        }

        public void setFollowUid(String followUid) {
            this.followUid = followUid;
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

        public String getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(String personalProfile) {
            this.personalProfile = personalProfile;
        }
    }
}
