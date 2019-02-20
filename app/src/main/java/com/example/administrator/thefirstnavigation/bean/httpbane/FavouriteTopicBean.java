package com.example.administrator.thefirstnavigation.bean.httpbane;

import java.util.List;

/**
 * Created by 88888 on 2019/2/3.
 */

public class FavouriteTopicBean {

    /**
     * cursor : 1539344198
     * favouritTopicList : [{"comment":null,"favouritId":"85ccae08682247fdbe1e6b55bdac366a","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-13/049de01db14a4c8184faa0aca7facf8a_1550018651190.jpg","imageListThumb":["http://39.107.254.232/firstga/images/topic/2018-10-19/049de01db14a4c8184faa0aca7facf8a_1539938842674.png","http://39.107.254.232/firstga/images/topic/2018-10-19/049de01db14a4c8184faa0aca7facf8a_1539938843859.jpg","http://39.107.254.232/firstga/images/topic/2018-10-19/049de01db14a4c8184faa0aca7facf8a_1539938844064.jpg"],"nickname":"哈哈哈","publishTime":"2018-10-19","shareLink":null,"title":"哈哈","topicId":"69ff77ae31b247c5825def625d4b522b","userId":"049de01db14a4c8184faa0aca7facf8a"}]
     */

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
         * comment : null
         * favouritId : 85ccae08682247fdbe1e6b55bdac366a
         * headImagePath : http://39.107.254.232/firstga/images/head/2019-02-13/049de01db14a4c8184faa0aca7facf8a_1550018651190.jpg
         * imageListThumb : ["http://39.107.254.232/firstga/images/topic/2018-10-19/049de01db14a4c8184faa0aca7facf8a_1539938842674.png","http://39.107.254.232/firstga/images/topic/2018-10-19/049de01db14a4c8184faa0aca7facf8a_1539938843859.jpg","http://39.107.254.232/firstga/images/topic/2018-10-19/049de01db14a4c8184faa0aca7facf8a_1539938844064.jpg"]
         * nickname : 哈哈哈
         * publishTime : 2018-10-19
         * shareLink : null
         * title : 哈哈
         * topicId : 69ff77ae31b247c5825def625d4b522b
         * userId : 049de01db14a4c8184faa0aca7facf8a
         */

        private Object comment;
        private String favouritId;
        private String headImagePath;
        private String nickname;
        private String publishTime;
        private Object shareLink;
        private String title;
        private String topicId;
        private String userId;
        private List<String> imageListThumb;

        public Object getComment() {
            return comment;
        }

        public void setComment(Object comment) {
            this.comment = comment;
        }

        public String getFavouritId() {
            return favouritId;
        }

        public void setFavouritId(String favouritId) {
            this.favouritId = favouritId;
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

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public Object getShareLink() {
            return shareLink;
        }

        public void setShareLink(Object shareLink) {
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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public List<String> getImageListThumb() {
            return imageListThumb;
        }

        public void setImageListThumb(List<String> imageListThumb) {
            this.imageListThumb = imageListThumb;
        }
    }
}
