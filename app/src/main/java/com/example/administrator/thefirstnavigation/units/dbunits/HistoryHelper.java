package com.example.administrator.thefirstnavigation.units.dbunits;

import com.example.administrator.thefirstnavigation.app.MyApp;
import com.example.administrator.thefirstnavigation.bean.GreenBean.HistoryBean;
import com.example.administrator.thefirstnavigation.bean.GreenBean.SeclectorBean;
import com.example.administrator.thefirstnavigation.bean.jsonbean.SearchBean;
import com.example.administrator.thefirstnavigation.dao.DaoMaster;
import com.example.administrator.thefirstnavigation.dao.DaoSession;
import com.example.administrator.thefirstnavigation.dao.HistoryBeanDao;
import com.example.administrator.thefirstnavigation.dao.SeclectorBeanDao;

import java.util.List;

/**
 * Created by Administrator on 2019/1/23.
 */

public class HistoryHelper {
    private static HistoryHelper sLoginHelper;
    private final HistoryBeanDao mDaoDao;

    private HistoryHelper(){
        //数据库初始化
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(),"hittory.db");
        //获取可读数据库
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        //获取表管理器
        DaoSession daoSession = daoMaster.newSession();
        //获取我们要操作表的工具类；
        mDaoDao=daoSession.getHistoryBeanDao();
    }
    public static HistoryHelper getInstance() {
        if (sLoginHelper == null) {
            synchronized (HistoryHelper.class) {
                if (sLoginHelper == null) {
                    sLoginHelper = new HistoryHelper();
                }
            }
        }

        return sLoginHelper;
    }
    public void insert(HistoryBean seclectorBean){
        mDaoDao.insert(seclectorBean);
    }

    public void delete(HistoryBean seclectorBean){
        mDaoDao.delete(seclectorBean);
    }

    public List<HistoryBean> query(){
        return  mDaoDao.queryBuilder().list();
    }


    public boolean queryLikeId(String search) {
        List<HistoryBean> list = mDaoDao.queryBuilder().where(HistoryBeanDao.Properties.History.eq(search)).list();
        if(list.size()==0){
            return  false;
        }
        return true;
    }

    public void deleteAll(){

        mDaoDao.deleteAll();
    }

    public void insertAll(List<HistoryBean> likeBeans){
        mDaoDao.insertInTx(likeBeans);
    }

    public  void update(HistoryBean student){
        mDaoDao.update(student);
    }
}
