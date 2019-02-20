package com.example.administrator.thefirstnavigation.bean.jsonbean;

public class UpdataSet {

    /**
     * userId : d56ea66e7ee741f498ca51242c8c6394
     * birthday : 2018-04-19
     * nickname : null
     * personalProfile : 哈哈哈哈哈
     * professionId : 2188e7113b0411e8b64c00163e30445d
     * sex : 1
     */

    private String userId;
    private String birthday;
    private Object nickname;
    private String personalProfile;
    private String professionId;
    private String sex;

    public UpdataSet(String userId, String birthday, Object nickname, String personalProfile, String professionId, String sex) {
        this.userId = userId;
        this.birthday = birthday;
        this.nickname = nickname;
        this.personalProfile = personalProfile;
        this.professionId = professionId;
        this.sex = sex;
    }

    public UpdataSet() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Object getNickname() {
        return nickname;
    }

    public void setNickname(Object nickname) {
        this.nickname = nickname;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UpdataSet{" +
                "userId='" + userId + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nickname=" + nickname +
                ", personalProfile='" + personalProfile + '\'' +
                ", professionId='" + professionId + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
