package com.maomao.technology.greendaodemo.db;


import android.util.Log;

import com.maomao.technology.greendaodemo.MyApplication;

public class UserDBFactory {

    private static UserDBFactory mInstance = null;
    private UserInfoManage userInfoManage;

    public static UserDBFactory getInstance() {
        if (mInstance == null) {
            synchronized (UserDBFactory.class) {
                if (mInstance == null) {
                    mInstance = new UserDBFactory();
                }
            }
        }
        return mInstance;
    }

    public UserInfoManage getUserInfoManage() {
        if (userInfoManage == null) {
            userInfoManage = new UserInfoManage(UserDBManage.getInstance(MyApplication.getApplication()).getDaoSession().getUserBeanDao());
        }
        return userInfoManage;
    }
}
