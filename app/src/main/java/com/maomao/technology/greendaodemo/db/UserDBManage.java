package com.maomao.technology.greendaodemo.db;

import android.content.Context;
import android.util.Log;


import com.maomao.technology.greendaodemo.base.DBConfig;
import com.maomao.technology.greendaodemo.greendao.DaoMaster;
import com.maomao.technology.greendaodemo.greendao.DaoSession;

public class UserDBManage {


    private static UserDBManage dbManage;

    private Context context;

    public static UserDBManage getInstance(Context context) {
        if (dbManage == null) {
            synchronized (UserDBManage.class) {
                if (dbManage == null) {
                    dbManage = new UserDBManage(context);
                }
            }
        }
        return dbManage;
    }

    private UserDBManage(Context context) {
        this.context = context;
    }

    private DaoMaster.DevOpenHelper mHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;


    /**
     * 获取DaoSession * * @return
     */
    public synchronized DaoSession getDaoSession() {
        if (null == mDaoSession) {
            mDaoSession = getDaoMaster().newSession();
        }
        return mDaoSession;
    }

    /**
     * 关闭数据库
     */
    public synchronized void closeDataBase() {
        closeHelper();
        closeDaoSession();
    }

    /**
     * 判断数据库是否存在，如果不存在则创建 * * @return
     */
    private DaoMaster getDaoMaster() {
        if (null == mDaoMaster) {
            if (context==null){
                Log.e("cccccccccc","cccc");
            }
            mHelper = new DaoMaster.DevOpenHelper(context, DBConfig.DB_NAME, null);
            mDaoMaster = new DaoMaster(mHelper.getWritableDb());
        }
        return mDaoMaster;
    }

    private void closeDaoSession() {
        if (null != mDaoSession) {
            mDaoSession.clear();
            mDaoSession = null;
        }
    }

    private void closeHelper() {
        if (mHelper != null) {
            mHelper.close();
            mHelper = null;
        }
    }
}
