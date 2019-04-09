package com.example.myapplication;

import android.text.TextUtils;

import java.util.Map;

public class VolleyUtils {

    public void ptuMap(final Map<String, String> map, final String url, final OnResultListener onResultListener) {
        if (!TextUtils.isEmpty(url)) {
            onResultListener.onSuccess("dengluchenggong");
        } else {
            onResultListener.onFailure("denglushibai");
        }

    }
}
