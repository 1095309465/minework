package com.example.myapplication.login.presenter.compl;

import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.login.model.IUser;
import com.example.myapplication.login.presenter.LoginPresenter;
import com.example.myapplication.login.view.LoginVIew;


public class LoginPresenterCompl implements LoginPresenter {

    LoginVIew loginVIew;
    IUser user;
    Handler handler;

    public LoginPresenterCompl(LoginVIew loginVIew) {
        this.loginVIew = loginVIew;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    private void initUser() {
        user = new IUser("mvp", "mvp");
    }

    @Override
    public void clear() {
        loginVIew.onClearText();

    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name,passwd);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loginVIew.onLoginResult(result, code);

            }
        }, 3000);



    }

    @Override
    public void setProgressBarVislity(int visiblity) {
        loginVIew.onSetProgressBarVisibility(visiblity);

    }
}
