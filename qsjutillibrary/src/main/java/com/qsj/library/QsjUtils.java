package com.qsj.library;

import android.content.Context;
import android.widget.Toast;

public class QsjUtils {

    public static String var="qsj";

    public static  void  findName(Context context,String var){
        Toast.makeText(context, var, Toast.LENGTH_SHORT).show();
    }
}
