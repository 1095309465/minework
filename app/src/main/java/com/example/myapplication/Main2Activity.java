package com.example.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMain2Binding;
import com.example.myapplication.login.model.UserBean;

public class Main2Activity extends AppCompatActivity {
    int age=25;
    UserBean  userBean=new UserBean("张三", age);
    ActivityMain2Binding binding;
    Handler mHandler=new Handler();
    long time=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
         binding= DataBindingUtil.setContentView(this,R.layout.activity_main2 );
        binding.setUser(userBean);
        Runnable  run=new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Main2Activity.this, String.valueOf(userBean.getAge()), Toast.LENGTH_SHORT).show();
                mHandler.postDelayed(this,time );
            }
        };
        mHandler.postDelayed(run, time);

    }

    public void click(View view) {
        userBean.setAge(++age);
        Toast.makeText(this, String.valueOf(age), Toast.LENGTH_SHORT).show();
        binding.setUser(userBean);

    }
}
