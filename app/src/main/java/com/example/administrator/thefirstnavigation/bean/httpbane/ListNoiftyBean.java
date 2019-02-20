package com.example.administrator.thefirstnavigation.bean.httpbane;

import java.util.List;

/**
 * Created by Administrator on 2019/2/14.
 */

public class ListNoiftyBean {

    /**
     * code : 0
     * data : [{"fromId":"8ddfb6af9bcb438ea9d2dbbebb1bc35b","fromTitle":"摘星入海","fromType":"2","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-14/049de01db14a4c8184faa0aca7facf8a_1550103208398.jpg","nickname":"月儿","notifyContent":null,"notifyContentType":null,"notifyId":"1824aeaf2f3511e99efc00163e30445d","notifyTime":"2019-02-13 10:14:29","notifyTitle":null,"notifyType":"3","userId":"049de01db14a4c8184faa0aca7facf8a"},{"fromId":"8ddfb6af9bcb438ea9d2dbbebb1bc35b","fromTitle":"摘星入海","fromType":"2","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-13/efe7538b97f14d11952f5a13e1c7f7cd_1550061789661.jpg","nickname":"阿正","notifyContent":null,"notifyContentType":null,"notifyId":"e12adcb32edb11e99efc00163e30445d","notifyTime":"2019-02-12 23:35:52","notifyTitle":"测试","notifyType":"2","userId":"efe7538b97f14d11952f5a13e1c7f7cd"},{"fromId":"e7570bd1f195498991ebcb9c7b50ddfb","fromTitle":null,"fromType":"0","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-13/efe7538b97f14d11952f5a13e1c7f7cd_1550061789661.jpg","nickname":"阿正","notifyContent":null,"notifyContentType":null,"notifyId":"c99b70502eb211e99efc00163e30445d","notifyTime":"2019-02-12 18:41:43","notifyTitle":"关注了你","notifyType":"1","userId":"efe7538b97f14d11952f5a13e1c7f7cd"},{"fromId":"2e638e18875c405b8e5b5d56f42e4f54","fromTitle":null,"fromType":"0","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-14/c383f4c9026d471da0184ad5b24c0365_1550074950470.png","nickname":"法号：老秃驴","notifyContent":null,"notifyContentType":null,"notifyId":"59d33f8b2e9f11e99efc00163e30445d","notifyTime":"2019-02-12 16:22:35","notifyTitle":"关注了你","notifyType":"1","userId":"c383f4c9026d471da0184ad5b24c0365"},{"fromId":"e3c923570a2647cb88583017a7ab38cf","fromTitle":"lalalal","fromType":"2","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-14/049de01db14a4c8184faa0aca7facf8a_1550103208398.jpg","nickname":"月儿","notifyContent":null,"notifyContentType":null,"notifyId":"fbb5e3092de511e99efc00163e30445d","notifyTime":"2019-02-11 18:15:40","notifyTitle":"有关法规和几个房价回归","notifyType":"2","userId":"049de01db14a4c8184faa0aca7facf8a"},{"fromId":"4b2d9c996d7c431794d8b1bcfca7bfea","fromTitle":"啊啊啊啊","fromType":"2","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-22/dc223b5fc4b74363a88caf497ece892e_1548111926574.jpg","nickname":"9丶","notifyContent":null,"notifyContentType":null,"notifyId":"a2d0252d2a1111e99efc00163e30445d","notifyTime":"2019-02-06 21:18:04","notifyTitle":"1","notifyType":"2","userId":"dc223b5fc4b74363a88caf497ece892e"},{"fromId":"906b21ec5d8d4cd08ce023dcac88400f","fromTitle":"123456","fromType":"2","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-14/c383f4c9026d471da0184ad5b24c0365_1550074950470.png","nickname":"法号：老秃驴","notifyContent":null,"notifyContentType":null,"notifyId":"14cb2f0427b911e99efc00163e30445d","notifyTime":"2019-02-03 21:39:08","notifyTitle":null,"notifyType":"3","userId":"c383f4c9026d471da0184ad5b24c0365"},{"fromId":"5f4a965536b24f8090f4f3282466cd15","fromTitle":"一只猫的独白","fromType":"2","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-14/049de01db14a4c8184faa0aca7facf8a_1550103208398.jpg","nickname":"月儿","notifyContent":null,"notifyContentType":null,"notifyId":"892e5bb627b611e99efc00163e30445d","notifyTime":"2019-02-03 21:20:55","notifyTitle":null,"notifyType":"3","userId":"049de01db14a4c8184faa0aca7facf8a"},{"fromId":"b8ac3b38bf8c46078aeb884d9f975147","fromTitle":"明明哦","fromType":"2","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-14/049de01db14a4c8184faa0aca7facf8a_1550103208398.jpg","nickname":"月儿","notifyContent":null,"notifyContentType":null,"notifyId":"b6ebfac023b711e99efc00163e30445d","notifyTime":"2019-01-29 19:19:16","notifyTitle":null,"notifyType":"3","userId":"049de01db14a4c8184faa0aca7facf8a"}]
     * message : 成功
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * fromId : 8ddfb6af9bcb438ea9d2dbbebb1bc35b
         * fromTitle : 摘星入海
         * fromType : 2
         * headImagePath : http://39.107.254.232/firstga/images/head/2019-02-14/049de01db14a4c8184faa0aca7facf8a_1550103208398.jpg
         * nickname : 月儿
         * notifyContent : null
         * notifyContentType : null
         * notifyId : 1824aeaf2f3511e99efc00163e30445d
         * notifyTime : 2019-02-13 10:14:29
         * notifyTitle : null
         * notifyType : 3
         * userId : 049de01db14a4c8184faa0aca7facf8a
         */

        private String fromId;
        private String fromTitle;
        private String fromType;
        private String headImagePath;
        private String nickname;
        private Object notifyContent;
        private Object notifyContentType;
        private String notifyId;
        private String notifyTime;
        private Object notifyTitle;
        private String notifyType;
        private String userId;

        public String getFromId() {
            return fromId;
        }

        public void setFromId(String fromId) {
            this.fromId = fromId;
        }

        public String getFromTitle() {
            return fromTitle;
        }

        public void setFromTitle(String fromTitle) {
            this.fromTitle = fromTitle;
        }

        public String getFromType() {
            return fromType;
        }

        public void setFromType(String fromType) {
            this.fromType = fromType;
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

        public Object getNotifyContent() {
            return notifyContent;
        }

        public void setNotifyContent(Object notifyContent) {
            this.notifyContent = notifyContent;
        }

        public Object getNotifyContentType() {
            return notifyContentType;
        }

        public void setNotifyContentType(Object notifyContentType) {
            this.notifyContentType = notifyContentType;
        }

        public String getNotifyId() {
            return notifyId;
        }

        public void setNotifyId(String notifyId) {
            this.notifyId = notifyId;
        }

        public String getNotifyTime() {
            return notifyTime;
        }

        public void setNotifyTime(String notifyTime) {
            this.notifyTime = notifyTime;
        }

        public Object getNotifyTitle() {
            return notifyTitle;
        }

        public void setNotifyTitle(Object notifyTitle) {
            this.notifyTitle = notifyTitle;
        }

        public String getNotifyType() {
            return notifyType;
        }

        public void setNotifyType(String notifyType) {
            this.notifyType = notifyType;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
