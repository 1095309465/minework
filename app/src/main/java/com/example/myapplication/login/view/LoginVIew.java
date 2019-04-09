package com.example.myapplication.login.view;

public interface LoginVIew {

    void onClearText();

    void onLoginResult(Boolean result, int code);

    void onSetProgressBarVisibility(int visbility);
}
