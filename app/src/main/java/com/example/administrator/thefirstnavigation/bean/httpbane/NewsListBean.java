package com.example.administrator.thefirstnavigation.bean.httpbane;

import java.util.List;

/**
 * Created by Administrator on 2019/1/22.
 */

public class NewsListBean {
    private String cursor;

    private List<DownListNewsBean.NewListBean> newList;



    private List<UpdaterNewsBean.NewListBean> upList;

    public List<UpdaterNewsBean.NewListBean> getUpList() {
        return upList;
    }

    public void setUpList(List<UpdaterNewsBean.NewListBean> upList) {
        this.upList = upList;
    }

    public NewsListBean(String cursor, List<DownListNewsBean.NewListBean> newList, List<UpdaterNewsBean.NewListBean>newListBeans) {
        this.cursor = cursor;
        this.newList = newList;
        this.upList=newListBeans;

    }


    public List<DownListNewsBean.NewListBean> getNewList() {
        return newList;
    }

    public void setNewList(List<DownListNewsBean.NewListBean> newList) {
        this.newList = newList;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public static class NewListBean {
        /**
         * imageListThumb : ["http://cn.ttfly.com/file/upload/201806/15/0512296412328.jpg"]
         * layoutType : 1
         * newsId : dd5cbfef9a204af38e04ef97a58e0c5a
         * origin :
         * pageviews : 9178
         * publishTime : 2018-07-04
         * title : 不看不知道，一看吓一跳的2018珠海航展又来了！！
         */
        private int isTop;
        private String layoutType;
        private String newsId;
        private String origin;
        private int pageviews;
        private String publishTime;
        private String title;
        private List<String> imageListThumb;

        public String getLayoutType() {
            return layoutType;
        }

        public void setLayoutType(String layoutType) {
            this.layoutType = layoutType;
        }

        public String getNewsId() {
            return newsId;
        }

        public void setNewsId(String newsId) {
            this.newsId = newsId;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImageListThumb() {
            return imageListThumb;
        }

        public int getIsTop() {
            return isTop;
        }

        public void setIsTop(int isTop) {
            this.isTop = isTop;
        }

        public void setImageListThumb(List<String> imageListThumb) {
            this.imageListThumb = imageListThumb;
        }
    }
}