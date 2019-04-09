package com.example.myapplication.login.presenter;

public interface LoginPresenter {

    void clear();

    void doLogin(String name, String passwd);

    void setProgressBarVislity(int visiblity);

}
