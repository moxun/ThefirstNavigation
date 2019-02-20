package com.example.administrator.thefirstnavigation.bean.GreenBean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2019/1/22.
 */
@Entity
public class SeclectorBean {
    @Id(autoincrement = true)
    private  Long id;
    private String channelName;
    private String channelId;
    private boolean isShow;
    @Generated(hash = 1522907321)
    public SeclectorBean(Long id, String channelName, String channelId,
            boolean isShow) {
        this.id = id;
        this.channelName = channelName;
        this.channelId = channelId;
        this.isShow = isShow;
    }
    @Generated(hash = 640377946)
    public SeclectorBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getChannelName() {
        return this.channelName;
    }
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    public String getChannelId() {
        return this.channelId;
    }
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    public boolean getIsShow() {
        return this.isShow;
    }
    public void setIsShow(boolean isShow) {
        this.isShow = isShow;
    }
}
