package com.bowoon.android.alog_example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Null on 2018-02-21.
 */

public class ActivityTwo extends AppCompatActivity {
    private OtherClass otherClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        otherClass = new OtherClass();

        otherClass.method1();
        otherClass.method2();
        otherClass.method3();
        otherClass.method4();
        otherClass.method5();
    }
}
