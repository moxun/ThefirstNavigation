package com.example.administrator.thefirstnavigation.bean.httpbane;

import java.util.List;

/**
 * Created by Administrator on 2019/1/28.
 */

public class TopicBean {

    /**
     * cursor : 1547808702201616ba11ef384493ca9d2e098f3d0e8da
     * topicList : [{"comments":0,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-26/efe7538b97f14d11952f5a13e1c7f7cd_1548497318017.jpg","imageListThumb":null,"likes":0,"nickname":"阿正","pageviews":2,"publishTime":"2019-01-28","shareLink":"http://www.baidu.com","title":"刺激啊","topicId":"c855113c77ae4dcb8a8a0e2429afdb86","userId":"efe7538b97f14d11952f5a13e1c7f7cd"}]
     */
    private String maxCursor;
    private String minCursor;

    /**
     * cursor : 1547808702201616ba11ef384493ca9d2e098f3d0e8da
     * topicList : [{"comments":0,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-27/e7d9914be4214263ad8e2a3e88e72263_1548576779148.jpg","imageListThumb":null,"likes":0,"nickname":"干啥工作吧","pageviews":3,"publishTime":"2019-01-25","shareLink":"https://home.firefoxchina.cn/","title":"你回家要记得发春哦  兄得","topicId":"88d930de7ffe4fcba027fb28feccb86b","userId":"e7d9914be4214263ad8e2a3e88e72263"}]
     */

    private String cursor;
    private List<TopicListBean> topicList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<TopicListBean> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<TopicListBean> topicList) {
        this.topicList = topicList;
    }

    public static class TopicListBean {
        @Override
        public String toString() {
            return "TopicListBean{" +
                    "comments=" + comments +
                    ", headImagePath='" + headImagePath + '\'' +
                    ", likes=" + likes +
                    ", nickname='" + nickname + '\'' +
                    ", pageviews=" + pageviews +
                    ", publishTime='" + publishTime + '\'' +
                    ", shareLink='" + shareLink + '\'' +
                    ", title='" + title + '\'' +
                    ", topicId='" + topicId + '\'' +
                    ", userId='" + userId + '\'' +
                    ", imageListThumb=" + imageListThumb +
                    '}';
        }

        /**
         * comments : 0
         * headImagePath : /head/2018-04-580.png
         * imageListThumb : ["http://39.107.224f468136360.png","http://39.106394_1524968136908.jpg","http://39.104968137327.jpg"]
         * likes : 0
         * nickname : 李红梅
         * pageviews : 0
         * publishTime : 2018-04-29 10:15:40
         * shareLink : http://www.baidu.com
         * title : postman测试发布话题
         * topicId : 452faafc1bfe4f0585be52255c10748e
         * userId : d56ea66e7ee741f498ca51242c8c6394
         */

        private int comments;
        private String headImagePath;
        private int likes;
        private String nickname;
        private int pageviews;
        private String publishTime;
        private String shareLink;
        private String title;
        private String topicId;
        private String userId;
        private List<String> imageListThumb;

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public String getHeadImagePath() {
            return headImagePath;
        }

        public void setHeadImagePath(String headImagePath) {
            this.headImagePath = headImagePath;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
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
