package com.example.administrator.thefirstnavigation.bean.httpbane;

import java.util.List;

/**
 * Created by Administrator on 2019/1/27.
 */

public class AboutBean {

    /**
     * imageListThumb : ["http://www.lyunx.com/data/attachment/portal/201801/05/100346szuu20uovuvlktyy.jpg.thumb.jpg"]
     * layoutType : 2
     * newsId : 79b38406b9454a8ab6a07824897a5ee5
     * origin :
     * pageviews : 0
     * publishTime : 2018-01-05
     * title : 新疆加快完善立体交通体系 布局建设准东等一批通用机场
     */

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

    public void setImageListThumb(List<String> imageListThumb) {
        this.imageListThumb = imageListThumb;
    }
}
