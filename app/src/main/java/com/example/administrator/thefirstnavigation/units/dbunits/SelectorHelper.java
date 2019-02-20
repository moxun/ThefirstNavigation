package com.example.administrator.thefirstnavigation.units.dbunits;

import com.example.administrator.thefirstnavigation.app.MyApp;
import com.example.administrator.thefirstnavigation.bean.GreenBean.LoginBean;
import com.example.administrator.thefirstnavigation.bean.GreenBean.SeclectorBean;
import com.example.administrator.thefirstnavigation.dao.DaoMaster;
import com.example.administrator.thefirstnavigation.dao.DaoSession;
import com.example.administrator.thefirstnavigation.dao.LoginBeanDao;
import com.example.administrator.thefirstnavigation.dao.SeclectorBeanDao;

import java.util.List;

/**
 * Created by Administrator on 2019/1/22.
 */

public class SelectorHelper {
    private static SelectorHelper sLoginHelper;
    private final SeclectorBeanDao mDaoDao;

    private SelectorHelper(){
        //数据库初始化
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(),"isbo.db");
        //获取可读数据库
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        //获取表管理器
        DaoSession daoSession = daoMaster.newSession();
        //获取我们要操作表的工具类；
        mDaoDao=daoSession.getSeclectorBeanDao();
    }
    public static SelectorHelper getInstance() {
        if (sLoginHelper == null) {
            synchronized (SelectorHelper.class) {
                if (sLoginHelper == null) {
                    sLoginHelper = new SelectorHelper();
                }
            }
        }

        return sLoginHelper;
    }
    public void insert(SeclectorBean seclectorBean){
        mDaoDao.insert(seclectorBean);
    }

    public void delete(SeclectorBean seclectorBean){
        mDaoDao.delete(seclectorBean);
    }

    public List<SeclectorBean> query(){
        return  mDaoDao.queryBuilder().list();
    }

    public SeclectorBean queryBean(boolean isshow) {


        return mDaoDao.queryBuilder().where(SeclectorBeanDao.Properties.IsShow.eq(isshow)).unique();

    }


    public void deleteAll(){

        mDaoDao.deleteAll();
    }

    public void insertAll(List<SeclectorBean> likeBeans){
        mDaoDao.insertInTx(likeBeans);
    }

    public  void update(SeclectorBean student){
        mDaoDao.update(student);
    }
}
