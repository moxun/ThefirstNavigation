package com.example.administrator.thefirstnavigation.bean.httpbane;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/17.
 */

public class UpListNewsBean {
    private List<NewsChannelListBean> newsChannelList;

    public List<NewsChannelListBean> getNewsChannelList() {
        return newsChannelList;
    }

    public void setNewsChannelList(List<NewsChannelListBean> newsChannelList) {
        this.newsChannelList = newsChannelList;
    }

    public static class NewsChannelListBean  {
        /**
         * channelId : 0
         * channelName : 资讯
         */

        private String channelId;
        private String channelName;

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }
    }
}
