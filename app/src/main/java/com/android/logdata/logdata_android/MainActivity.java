package com.android.logdata.logdata_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.logcat.log.Logcat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logcat.logSetting(getApplicationContext(), true, true);
        Logcat.setDebug(true);

        Practice p = new Practice();
        p.pracitce();

        Hello h = new Hello();

        Logcat.i("info");
        Logcat.e("error");
        Logcat.d("debug");
        Logcat.w("warning");
        Logcat.v("verb");


//        TextView textView = null;
//        textView.setText("Hello, World!");
    }
}
