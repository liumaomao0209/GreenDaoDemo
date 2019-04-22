package com.maomao.technology.greendaodemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 创建日期:2019/4/19 on 15:45
 * 作   者:刘喵喵
 * 邮   箱:915850672@qq.com
 * 描   述:
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class MyAdapter extends RecyclerView.Adapter {

    private final int mLayoutId;
    private final List<UserBean> mData;
    private final Context mContext;
    private final LayoutInflater inflater;

    public MyAdapter(List<UserBean> mData, int mLayoutId, Context mContext) {
        this.mData = mData;
        this.mLayoutId = mLayoutId;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(mLayoutId, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.key.setText(mData.get(i).getId()+"");
        holder.name.setText(mData.get(i).getName()+"");
        holder.age.setText(mData.get(i).getAge()+"");

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView age;
        private final TextView name;
        private final TextView key;
        public MyViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            age = v.findViewById(R.id.age);
            key = v.findViewById(R.id.key);

        }


    }
}
