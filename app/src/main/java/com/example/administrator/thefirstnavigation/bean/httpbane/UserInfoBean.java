package com.example.administrator.thefirstnavigation.bean.httpbane;

/**
 * Created by Administrator on 2019/1/27.
 */

public class UserInfoBean {
    /**
     * birthday : 1999-01-01
     * headImagePath : http://39.107.254.232/firstga/images/head/2019-01-25/049de01db14a4c8184faa0aca7facf8a_1548423321756.jpg
     * nickname : 傻子
     * personalProfile : 中国
     * phone : 13453905822
     * professionId :
     * professionName : null
     * sex : 女
     * userId : 049de01db14a4c8184faa0aca7facf8a
     */

    private String birthday;
    private String headImagePath;
    private String nickname;
    private String personalProfile;
    private String phone;
    private String professionId;
    private Object professionName;
    private String sex;
    private String userId;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    public Object getProfessionName() {
        return professionName;
    }

    public void setProfessionName(Object professionName) {
        this.professionName = professionName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
