package com.android.logcat.crashlogger;

import android.app.Application;

import com.android.logcat.http.HttpServiceProvider;
import com.android.logcat.http.CreateHttpServiceProvider;
import com.android.logcat.http.VolleyManager;

import org.acra.ACRA;
import org.acra.annotation.AcraCore;
import org.acra.data.StringFormat;

/**
 * Created by Null on 2018-01-03.
 */

@AcraCore(reportFormat = StringFormat.JSON,
        reportSenderFactoryClasses = CrashReportFactory.class)
public class CreateAcra extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpServiceProvider.registerDefaultProvider(new CreateHttpServiceProvider());
        VolleyManager.getInstance().setRequestQueue(getApplicationContext());

        ACRA.init(this);
    }
}
