package com.maomao.technology.greendaodemo.db;

import com.maomao.technology.greendaodemo.UserBean;
import com.maomao.technology.greendaodemo.base.BaseDBManager;


import org.greenrobot.greendao.AbstractDao;

/**
 * Describe：DB操作类
 */

public class UserInfoManage extends BaseDBManager<UserBean, String> {
    public UserInfoManage(AbstractDao dao) {
        super(dao);
    }
}
