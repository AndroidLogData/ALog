package com.android.logcat.crashlogger;

import android.app.Application;

import org.acra.ACRA;
import org.acra.annotation.AcraHttpSender;
import org.acra.sender.HttpSender;

/**
 * Created by Null on 2018-01-03.
 */

@AcraHttpSender(uri = "http://52.231.37.113:8080/crash",
        httpMethod = HttpSender.Method.PUT)
public class CreateAcra extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);
    }
}
