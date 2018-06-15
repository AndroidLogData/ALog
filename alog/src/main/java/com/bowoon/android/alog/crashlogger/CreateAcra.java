package com.bowoon.android.alog.crashlogger;

import android.app.Application;
import com.bowoon.android.alog.http.VolleyManager;
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

        VolleyManager.getInstance().setRequestQueue(getApplicationContext());

        ACRA.init(this);
    }
}
