package com.maomao.technology.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 创建日期:2019/4/18 on 16:37
 * 作   者:刘喵喵
 * 邮   箱:915850672@qq.com
 * 描   述:
 * <p>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
@Entity
public class UserBean {
    @Id
    String id;
    @NotNull
    String name;
    String age;
    @Generated(hash = 584616103)
    public UserBean(String id, @NotNull String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
}
