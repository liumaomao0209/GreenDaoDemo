package com.maomao.technology.greendaodemo;

import android.app.Application;
import android.content.Context;


/**
 * Describe：基础Application所有需要模块化开发的module都需要继承自BaseApplication
 * Created by More on 2019/2/25.
 */
public class MyApplication extends Application {

    //全局唯一的context
    private static MyApplication application;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
    }
    public static Context getContext() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    /**
     * 获取全局唯一上下文
     *
     * @return BaseApplication
     */
    public static MyApplication getApplication() {
        return application;
    }
}