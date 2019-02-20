package com.example.administrator.thefirstnavigation.bean.GreenBean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2019/1/18.
 */
@Entity
public class LoginBean {

    @Id(autoincrement = true)
    private  Long id;

    private String phone;

    private boolean islogin;



    @Generated(hash = 1595833009)
    public LoginBean(Long id, String phone, boolean islogin) {
        this.id = id;
        this.phone = phone;
        this.islogin = islogin;
    }

    @Generated(hash = 1112702939)
    public LoginBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getIslogin() {
        return this.islogin;
    }

    public void setIslogin(boolean islogin) {
        this.islogin = islogin;
    }


}
