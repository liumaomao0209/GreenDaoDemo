package com.maomao.technology.greendaodemo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.maomao.technology.greendaodemo.db.UserDBFactory;
import com.maomao.technology.greendaodemo.db.UserDBManage;
import com.maomao.technology.greendaodemo.db.UserInfoManage;
import com.maomao.technology.greendaodemo.greendao.DaoSession;
import com.maomao.technology.greendaodemo.greendao.UserBeanDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends Activity implements View.OnClickListener {

    private UserInfoManage userInfoManage;
    private List<UserBean> userBeanList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private EditText keyEdit;
    private EditText valueEdit;
    private TextView add;
    private TextView delete;
    private TextView search;
    private TextView show;
    private TextView update;
    private UserBean userBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initdata();
        UserDBFactory userDBFactory = new UserDBFactory();
        userInfoManage = userDBFactory.getUserInfoManage();


    }

    private void initdata() {
        myAdapter = new MyAdapter(userBeanList, R.layout.user_item, this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initview() {
        add = findViewById(R.id.add_btn);
        delete = findViewById(R.id.delete_btn);
        search = findViewById(R.id.search_btn);
        show = findViewById(R.id.show_btn);
        recyclerView = findViewById(R.id.recyclerView);
        keyEdit = findViewById(R.id.key_edt);
        valueEdit = findViewById(R.id.value_edt);
        update = findViewById(R.id.update_btn);
        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        search.setOnClickListener(this);
        show.setOnClickListener(this);
        update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Random mRandom = new Random();
        String key = keyEdit.getText().toString();
        switch (v.getId()) {
            case R.id.add_btn:
                //添加数据
                for (int i = 0; i < 10; i++) {
                    userBean = new UserBean();
                    userBean.setId(i + "");
                    int age = mRandom.nextInt(10) + 10;
                    userBean.setAge(age + "");
                    userBean.setName("瑶瑶" + i);
                    userInfoManage.insertOrUpdate(userBean);//插入或替换
                }
                myAdapter.notifyDataSetChanged();
                //显示
                show.performClick();
                break;
            case R.id.delete_btn:
                //删除key为..的数据
                userInfoManage.deleteByKey(key);
                show.performClick();
                break;
            case R.id.show_btn:
                userBeanList.clear();
                //查询所有并显示
                List<UserBean> userBeans = userInfoManage.queryAll();
                userBeanList.addAll(userBeans);
                myAdapter.notifyDataSetChanged();
                break;
            case R.id.search_btn:
                //搜索key为..的数据
                UserBean query = userInfoManage.query(key);
                if (query != null) {
                    userBeanList.clear();
                    userBeanList.add(query);
                    myAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(this, "没有该条数据", Toast.LENGTH_SHORT).show();
                }
        break;
        case R.id.update_btn:
        //使用主键查询需要修改的数据
        UserBean userBean = userInfoManage.query(key);
        if (userBean != null) {
            userBean.setName(valueEdit.getText().toString());
            //修改
            userInfoManage.update(userBean);
            show.performClick();
        } else {
            Toast.makeText(this, "没有该条数据", Toast.LENGTH_SHORT).show();
        }

        break;
    }
}


}
