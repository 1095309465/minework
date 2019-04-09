package com.example.myapplication.login.model;

import com.example.myapplication.OnResultListener;

public interface LoginModel {

    void Login(String useName, String passWord, OnResultListener onResultListener);
}
