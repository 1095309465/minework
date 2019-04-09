package com.example.myapplication.login;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.Main2Activity;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    EditText  ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        Log.e("123", "app.packageNameId="+getPackageName());
    }

    public void btn(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(new Intent(this, Main2Activity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }else{
            startActivity(new Intent(this, Main2Activity.class));
        }
    }
}
