package com.example.administrator.thefirstnavigation.units.dbunits;



import com.example.administrator.thefirstnavigation.app.MyApp;
import com.example.administrator.thefirstnavigation.bean.GreenBean.LoginBean;
import com.example.administrator.thefirstnavigation.dao.DaoMaster;
import com.example.administrator.thefirstnavigation.dao.DaoSession;
import com.example.administrator.thefirstnavigation.dao.LoginBeanDao;

import java.util.List;

/**
 * Created by Administrator on 2019/1/2.
 */

public class LoginHelper {
    private static LoginHelper sLoginHelper;
    private final LoginBeanDao mDaoDao;

    private LoginHelper(){
        //数据库初始化
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(),"loser.db");
        //获取可读数据库
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        //获取表管理器
        DaoSession daoSession = daoMaster.newSession();
        //获取我们要操作表的工具类；
        mDaoDao = daoSession.getLoginBeanDao();
    }
    public static LoginHelper getInstance() {
        if (sLoginHelper == null) {
            synchronized (LoginHelper.class) {
                if (sLoginHelper == null) {
                    sLoginHelper = new LoginHelper();
                }
            }
        }

        return sLoginHelper;
    }
    public void insert(LoginBean likeBean){
        mDaoDao.insert(likeBean);
    }

   public void delete(LoginBean likeBean){
        mDaoDao.delete(likeBean);
   }

    public List<LoginBean> query(){
        return  mDaoDao.queryBuilder().list();
    }


    public boolean queryLikeId() {
        if(mDaoDao.queryBuilder().list().size()!=0){
            return  true;
        }
        return false;
    }
    public LoginBean queryBean(String id) {


        return mDaoDao.queryBuilder().where(LoginBeanDao.Properties.Phone.eq(id)).unique();

    }
    public void deleteAll(){

        mDaoDao.deleteAll();
    }

    public void insertAll(List<LoginBean> likeBeans){
        mDaoDao.insertInTx(likeBeans);
    }
}
