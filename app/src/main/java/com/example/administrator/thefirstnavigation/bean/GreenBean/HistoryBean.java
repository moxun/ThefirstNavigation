package com.example.administrator.thefirstnavigation.bean.GreenBean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2019/1/23.
 */
@Entity
public class HistoryBean {
    @Id(autoincrement = true)
    private  Long id;

    private String history;

    @Generated(hash = 1422002473)
    public HistoryBean(Long id, String history) {
        this.id = id;
        this.history = history;
    }

    @Generated(hash = 48590348)
    public HistoryBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistory() {
        return this.history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
