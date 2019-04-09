package com.example.myapplication.login.model;

import android.text.TextUtils;

public class IUser {

    String name;
    String passwd;

    public IUser(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public int checkUserValidity(String name,String paswd){
        if(!TextUtils.isEmpty(name)&&"qsj".equals(name)){
            return 0;
        }else{
            return 1;
        }

    }

}

