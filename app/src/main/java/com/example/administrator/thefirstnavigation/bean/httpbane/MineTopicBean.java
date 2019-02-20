package com.example.administrator.thefirstnavigation.bean.httpbane;

import java.util.List;

/**
 * Created by lenovo on 2019/2/15.
 */

public class MineTopicBean {

    private String cursor;
    private List<FavouritTopicListBean> favouritTopicList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<FavouritTopicListBean> getFavouritTopicList() {
        return favouritTopicList;
    }

    public void setFavouritTopicList(List<FavouritTopicListBean> favouritTopicList) {
        this.favouritTopicList = favouritTopicList;
    }

    public static class FavouritTopicListBean {
        /**
         * comments : 0
         * imageListThumb : ["http://39.107.254.232/firstga/images/topic/2019-02-14/049de01db14a4c8184faa0aca7facf8a_1550149210688.png"]
         * likes : 0
         * pageviews : 11
         * publishTime : 2019-02-14
         * shareLink : https://user.qzone.qq.com/599904694?ADUIN=599904694&ADSESSION=1541557563&ADTAG=CLIENT.QQ.5593_MyTip.0&ADPUBNO=26858&source=namecardhoverstar
         * title : 第五人格
         * topicId : 3163abb7af3d42f4a1d4f03d3db09ead
         */

        private int comments;
        private int likes;
        private int pageviews;
        private String publishTime;
        private String shareLink;
        private String title;
        private String topicId;
        private List<String> imageListThumb;

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public int getPageviews() {
            return pageviews;
        }

        public void setPageviews(int pageviews) {
            this.pageviews = pageviews;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getShareLink() {
            return shareLink;
        }

        public void setShareLink(String shareLink) {
            this.shareLink = shareLink;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTopicId() {
            return topicId;
        }

        public void setTopicId(String topicId) {
            this.topicId = topicId;
        }

        public List<String> getImageListThumb() {
            return imageListThumb;
        }

        public void setImageListThumb(List<String> imageListThumb) {
            this.imageListThumb = imageListThumb;
        }
    }

}
